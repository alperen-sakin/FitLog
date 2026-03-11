package com.example.fitlog.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.presentation.home.component.DaysBox
import com.example.fitlog.presentation.home.component.ExerciseCard
import com.example.fitlog.presentation.home.component.ProgressCard
import com.example.fitlog.presentation.home.component.TopAppBar
import com.example.fitlog.presentation.home.viewModel.HomeState
import com.example.fitlog.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                onAddClick = {
                    navController.navigate("add")
                }
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            DaysBox(
                modifier = Modifier,
                selectedDay = state.value.selectedDay,
                onDaySelected = viewModel::onDaySelected
            )

            ProgressCard(
                modifier = Modifier.padding(horizontal = 16.dp),
                leftExercises = state.value.leftExercise,
                progress = state.value.currentProgress
            )

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                exercisesList(state, viewModel, viewModel::onDeleteExercise)
            }
        }
    }
}

private fun LazyListScope.exercisesList(
    state: State<HomeState>,
    viewModel: HomeViewModel,
    onDelete: (Exercise) -> Unit
) {
    items(
        state.value.exercises,
        key = { it.id }
    ) { exercise ->

        val dismissState = rememberSwipeToDismissBoxState()

        LaunchedEffect(dismissState.currentValue) {
            if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
                onDelete(exercise)
            }
        }

        SwipeToDismissBox(
            state = dismissState,
            enableDismissFromStartToEnd = false,
            backgroundContent = {
                val color =
                    if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart) {
                        Color.Red.copy(alpha = 0.8f)
                    } else {
                        Color.Transparent
                    }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color, shape = CardDefaults.elevatedShape)
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete",
                        tint = Color.White
                    )
                }
            }
        ) {
            ExerciseCard(
                onCardClick = viewModel::onCardClick,
                exercise = exercise,
                modifier = Modifier
            )
        }
    }
}
