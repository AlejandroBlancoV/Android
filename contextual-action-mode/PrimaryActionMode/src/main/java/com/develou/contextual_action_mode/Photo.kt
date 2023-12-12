package com.develou.contextual_action_mode

import java.util.*

data class Photo(
    val featuredImage: Int,
    val id: String = UUID.randomUUID().toString()
)
