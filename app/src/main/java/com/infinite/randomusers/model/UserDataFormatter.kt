package com.infinite.randomusers.model

import com.infinite.randomusers.utils.formatDate

class UserDataFormatter(val user: User) {
    
    fun getFormattedName() = with(user.name) {"$title. $first $last"}
    
    fun getDobAgeFormatted() = with(user.dob) {"Dob: ${formatDate(date)} / Age: $age"}
    
    fun getLocationFormatted(): String {
        return with(user.location)  {
            """${street.number}, ${street.name}
                |$city
                |$state - $postcode
                |$country
            """.trimMargin()
        }
    }
    
}