package com.alexma.messagelist.message.domain.item

import com.alexma.messagelist.message.data.model.MessageModel
import java.util.Date

data class MessageItem(
    val date: Date,
    val name: String,
    val email: String,
    val message: String
)

fun MessageModel.toMessageItem() = MessageItem(
    date = date,
    name = name,
    email = email,
    message = message
)
