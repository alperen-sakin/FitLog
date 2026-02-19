package com.example.fitlog.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fitlog.presentation.home.component.TopAppBar

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "Home Screen")

        }
    }
}