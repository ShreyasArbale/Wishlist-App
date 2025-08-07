package com.example.jetwishlistapp.ui.view

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetwishlistapp.ui.navigation.Screen
import com.example.jetwishlistapp.ui.view.components.AppBarView
import com.example.jetwishlistapp.ui.view.components.EmptyExpenseCard
import com.example.jetwishlistapp.ui.view.components.WishItem
import com.example.jetwishlistapp.viewmodel.WishViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(title = "Notes", hideBackButton = false) {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate(Screen.AddScreen.route + "/0L")
                },
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        val wishlist by viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(4.dp)
        ) {
            if(wishlist.isEmpty()) {
                item {
                    EmptyExpenseCard("No Note Found", "You haven’t added any note.", "Add Note", onActionClick = {
                        navController.navigate(Screen.AddScreen.route + "/0L")
                    })
                }
            }else{
                items(wishlist, key = { wish -> wish.id }) { wish ->
                    var showDeleteDialog by remember { mutableStateOf(false) }

                    if (showDeleteDialog) {
                        AlertDialog(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            onDismissRequest = { showDeleteDialog = false },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        viewModel.deleteWish(wish)
                                        showDeleteDialog = false
                                        Toast.makeText(context, "Note deleted", Toast.LENGTH_SHORT)
                                            .show()
                                    }) {
                                    Text("Delete", color = MaterialTheme.colorScheme.tertiary)
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    showDeleteDialog = false
                                }) {
                                    Text("Cancel", color = MaterialTheme.colorScheme.tertiary)
                                }
                            },
                            title = { Text("Delete Note") },
                            text = { Text("Are you sure you want to delete this Note?") }
                        )
                    }

                    WishItem(
                        wish = wish,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth()
                            .combinedClickable(
                                onClick = {
                                    navController.navigate(Screen.AddScreen.route + "/${wish.id}")
                                },
                                onLongClick = {
                                    showDeleteDialog = true
                                }
                            )
                    )
                }
            }
        }
    }
}
