package com.alexma.messagelist.message.repository

import com.alexma.messagelist.message.data.MessageService
import com.alexma.messagelist.message.domain.item.MessageItem
import com.alexma.messagelist.message.domain.item.toMessageItem
import javax.inject.Inject

class MessageRepository @Inject constructor(private val messageService: MessageService){

    suspend fun getMessages(): List<MessageItem> {
        return messageService.getMessages().map { it.toMessageItem() }
    }

}