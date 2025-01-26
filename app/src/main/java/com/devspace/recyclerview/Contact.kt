package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Contact(
    val name : String,
    val number : String,
    @DrawableRes val icon: Int
)
