package com.example.jetwishlistapp.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetwishlistapp.R
import com.example.jetwishlistapp.data.local.Wish
import com.example.jetwishlistapp.ui.view.components.AppBarView
import com.example.jetwishlistapp.viewmodel.WishViewModel

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = id) {
        if (id != 0L) {
            viewModel.getAWishById(id).collect { wish ->
                viewModel.onWishTitleChange(wish.title)
                viewModel.onWishDescriptionChange(wish.description)
            }
        } else {
            viewModel.onWishTitleChange("")
            viewModel.onWishDescriptionChange("")
        }
    }

    Scaffold(
        topBar = {
            AppBarView(
                title = if (id != 0L) "Update" else "Create", hideBackButton = true
            ) {
                navController.navigateUp()
            }
        },
        modifier = Modifier.background(Color.White)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.wishTitleState,
                    onValueChange = { viewModel.onWishTitleChange(it) },
                    singleLine = true,
                    label = {
                        Text(text = "Title", color = MaterialTheme.colorScheme.onSurface)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        cursorColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = viewModel.wishDescriptionState,
                    onValueChange = { viewModel.onWishDescriptionChange(it) },
                    label = {
                        Text(
                            text = "Description",
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = MaterialTheme.colorScheme.tertiary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        cursorColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        keyboardController?.hide()

                        if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                            if (id != 0L) {
                                viewModel.updateWish(
                                    Wish(
                                        id = id,
                                        title = viewModel.wishTitleState.trim(),
                                        description = viewModel.wishDescriptionState.trim()
                                    )
                                )
                                Toast.makeText(context, "Note has been updated", Toast.LENGTH_SHORT)
                                    .show()
                                navController.navigateUp()
                            } else {
                                viewModel.addWish(
                                    Wish(
                                        title = viewModel.wishTitleState.trim(),
                                        description = viewModel.wishDescriptionState.trim()
                                    )
                                )
                                Toast.makeText(context, "Note has been created", Toast.LENGTH_SHORT)
                                    .show()
                                navController.navigateUp()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Enter all fields to save the note",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                ) {
                    Text(
                        text = if (id != 0L)
                            stringResource(id = R.string.update_wish)
                        else
                            stringResource(id = R.string.add_wish),
                        style = TextStyle(fontSize = 16.sp),
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }
        }
    }
}