package com.alexma.messagelist.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexma.messagelist.R
import com.alexma.messagelist.message.domain.item.MessageItem
import com.alexma.messagelist.ui.pruebas.CardMaterial
import com.alexma.messagelist.ui.pruebas.SerchBarMaterial

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MessageListScreen() {

    val messageListViewModel = viewModel(modelClass = MessageListViewModel::class.java)
    val messages = messageListViewModel.messages.collectAsState()

    Scaffold(
        topBar = {
            SerchBarMaterial()
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Check")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Delete")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        // Bookmark icon
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bookmark_border_24),
                            contentDescription = "Edit"
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = MaterialTheme.shapes.small
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification",
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn {

            items(messages.value) { message: MessageItem ->

                CardMaterial(
                    viewModel = messageListViewModel,
                    date = message.date,
                    name = message.name,
                    email = message.email,
                    message = message.message
                )

            }

        }
    }


}