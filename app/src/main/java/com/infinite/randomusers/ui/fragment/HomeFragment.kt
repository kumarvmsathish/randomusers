package com.infinite.randomusers.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinite.randomusers.adapter.RandomUserListAdapter
import com.infinite.randomusers.adapter.VerticalSpaceItemDecoration
import com.infinite.randomusers.application.RandomUserApplication
import com.infinite.randomusers.databinding.FragmentHomeBinding
import com.infinite.randomusers.interfaces.IListItemClickListener
import com.infinite.randomusers.model.User
import com.infinite.randomusers.network.RemoteDataSource
import com.infinite.randomusers.repository.UserRepository
import com.infinite.randomusers.utils.setupSnackBar
import com.infinite.randomusers.viewmodel.HomeViewModel
import com.infinite.randomusers.viewmodel.HomeViewModelFactory
import javax.inject.Inject


class HomeFragment: Fragment(), IListItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var layoutManager: LinearLayoutManager
    private val lastVisibleItemPosition: Int
        get() = layoutManager.findLastVisibleItemPosition()

    @Inject
    lateinit var remoteDataSource: RemoteDataSource

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    private lateinit var homeViewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val application = requireActivity().application as RandomUserApplication
        application.appComponent.homeComponent().build().inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        homeViewModel = ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
        binding.viewModel = homeViewModel

        setupUserListData()

        return binding.root
    }

    /**
     * Set layout manager to user list and set adapter to user list recycler view
     * Add scroll change listener to fetch data on scroll to bottom
     */
    private fun setupUserListData() {
        layoutManager = LinearLayoutManager(context)
        binding.userListView.layoutManager = layoutManager
        binding.userListView.adapter = RandomUserListAdapter(viewModel = homeViewModel, onItemClickListener = this)
        binding.userListView.addOnScrollListener(scrollListener)
        binding.userListView.addItemDecoration(VerticalSpaceItemDecoration(16))
    }

    override fun onStart() {
        super.onStart()
        view?.setupSnackBar(this, homeViewModel.error)
    }

    /**
     * Scroll change listener to fetch data on scroll to bottom
     * Validates total item count and last visible item by position
     */
    private val scrollListener = object: RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            val totalItemCount = recyclerView.layoutManager!!.itemCount
            if (totalItemCount == lastVisibleItemPosition + 1) {
                homeViewModel.fetchNextPageData()
            }
        }

    }

    /**
     * Handles click action from user list recycler view
     * Navigate to user details using Nav Directions with User model argument
     * @param user Selected user from User list displayed
     */
    override fun onClick(user: User) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToUserDetailFragment(user))
    }


}