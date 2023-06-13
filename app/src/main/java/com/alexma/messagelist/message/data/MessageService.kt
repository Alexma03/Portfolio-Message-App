package com.alexma.messagelist.message.data

import com.alexma.messagelist.message.data.model.MessageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MessageService @Inject constructor(private val messageApi: MessageApi) {

    suspend fun getMessages(): List<MessageModel> {
        return withContext(Dispatchers.IO) {
            val message = messageApi.getMessages()
            message.body() ?: emptyList()
        }
    }

}