package com.alexma.messagelist.ui.pruebas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexma.messagelist.ui.screen.MessageListViewModel
import java.util.Date

@Composable
fun CardMaterial(viewModel: MessageListViewModel, date: Date, name: String, email: String, message: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Column {
            Text(
                text = name,
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = email,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = message,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = viewModel.dateFormatter(date),
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }


    }
}