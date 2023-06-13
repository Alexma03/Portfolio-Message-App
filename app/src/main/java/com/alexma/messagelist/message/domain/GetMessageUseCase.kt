package com.alexma.messagelist.message.domain

import com.alexma.messagelist.message.domain.item.MessageItem
import com.alexma.messagelist.message.repository.MessageRepository
import javax.inject.Inject

class GetMessageUseCase @Inject constructor(private val messageRepository: MessageRepository) {

    suspend operator fun invoke(): List<MessageItem> {
        return messageRepository.getMessages()
    }
}