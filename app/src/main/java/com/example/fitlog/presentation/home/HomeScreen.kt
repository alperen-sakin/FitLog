package com.example.fitlog.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fitlog.presentation.home.component.DaysBox
import com.example.fitlog.presentation.home.component.TopAppBar
import com.example.fitlog.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    // navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

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
                selectedDay = state.value.selectedDay,
                onDaySelected = viewModel::onDaySelected
            )
        }
    }
}
