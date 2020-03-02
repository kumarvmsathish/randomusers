package com.infinite.randomusers.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.infinite.randomusers.application.RandomUserApplication
import com.infinite.randomusers.databinding.FragmentUserDetailBinding
import com.infinite.randomusers.viewmodel.UserDetailModelFactory
import com.infinite.randomusers.viewmodel.UserDetailViewModel
import javax.inject.Inject

class UserDetailFragment: Fragment() {

    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    @Inject
    lateinit var userDetailModelFactory: UserDetailModelFactory

    private val args: UserDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val application = requireActivity().application as RandomUserApplication
        application.appComponent.userDataComponent().setUser(args.user).build().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this, userDetailModelFactory).get(UserDetailViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

}