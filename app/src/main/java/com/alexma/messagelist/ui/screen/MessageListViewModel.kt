package com.alexma.messagelist.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexma.messagelist.message.domain.GetMessageUseCase
import com.alexma.messagelist.message.domain.item.MessageItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MessageListViewModel @Inject constructor(
    private val getMessageUseCase: GetMessageUseCase
) : ViewModel() {

    private val _messages = MutableStateFlow(emptyList<MessageItem>())
    val messages: StateFlow<List<MessageItem>> get() = _messages

    init {
        getMessages()
    }

    private fun getMessages() {
        viewModelScope.launch {
            try {
                val messages = getMessageUseCase()
                _messages.value = messages
            } catch (_: Exception) {

            }
        }
    }

    fun dateFormatter(date: Date): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return formatter.format(date)
    }
}