package com.alexma.messagelist.ui.pruebas

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


@Preview
@ExperimentalMaterial3Api
@Composable
fun SerchBarMaterial() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    val context = LocalContext.current
    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { Toast.makeText(context, query, Toast.LENGTH_SHORT).show(); active = false },
        active = active,
        onActiveChange = { active = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search") },
        leadingIcon = { IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
            )
        } },
        trailingIcon = { IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
            )
        } },
    ) {

    }
}