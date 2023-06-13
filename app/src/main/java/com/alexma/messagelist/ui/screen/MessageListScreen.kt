package com.alexma.messagelist.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexma.messagelist.message.domain.item.MessageItem

@Composable
fun MessageListScreen() {

    val messageListViewModel = viewModel(modelClass = MessageListViewModel::class.java )
    val messages = messageListViewModel.messages.collectAsState()

    LazyColumn {

        items(messages.value) { message: MessageItem ->

            MessageCard(message = message)

        }

    }

}

@Composable
fun MessageCard(message: MessageItem) {
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        shape = MaterialTheme.shapes.medium
    ){
        Column {
            Text(text = message.name)
            Text(text = message.email)
            Text(text = message.date.toString())
            Text(text = message.message)

        }
    }
}
