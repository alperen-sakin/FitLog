package com.example.fitlog.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.fitlog.domain.model.Days
import com.example.fitlog.presentation.home.component.DaysBox
import com.example.fitlog.presentation.home.component.TopAppBar

@Composable
fun HomeScreen(
    // navController: NavController,
) {
    var selectedDay by remember { mutableStateOf(Days.Mon) }

    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            DaysBox(
                modifier = Modifier,
                selectedDay = selectedDay,
                onDaySelected = {
                    selectedDay = Days.valueOf(it)
                }
            )
        }
    }
}
