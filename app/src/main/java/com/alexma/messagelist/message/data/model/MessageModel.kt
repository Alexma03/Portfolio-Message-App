package com.alexma.messagelist.message.data.model

import java.util.Date

data class MessageModel(
    val date: Date,
    val name: String,
    val email: String,
    val message: String
)
