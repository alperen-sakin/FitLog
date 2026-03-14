package com.example.fitlog.presentation.addScreen.component

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitlog.R
import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.presentation.addScreen.viewModel.AddScreenViewModel
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Green500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural500
import com.example.fitlog.ui.theme.Natural900

@SuppressLint("LocalContextResourcesRead")
@Composable
fun SelectExerciseBox(
    exercise: Exercise,
    modifier: Modifier = Modifier,
    onUpdate: (AddScreenViewModel.UpdateType) -> Unit,
    onAddClick: () -> Unit,
    selectedDays: Set<Days>,
    onDayToggled: (Days) -> Unit
) {
    var isOpen by rememberSaveable { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { })
            .border(
                width = 1.dp,
                color = Blue500,
                shape = CardDefaults.elevatedShape
            ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            isOpen = !isOpen
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TopSection(exercise, isOpen)
            }

            AnimatedVisibility(visible = isOpen) {
                BottomSection(exercise, onUpdate, onAddClick, selectedDays, onDayToggled)
            }
        }
    }
}

@SuppressLint("LocalContextResourcesRead", "DiscouragedApi")
@Composable
private fun TopSection(exercise: Exercise, isOpen: Boolean) {
    val context = LocalContext.current

    val imageResId = remember(exercise.img) {
        context.resources.getIdentifier(exercise.img, "drawable", context.packageName)
    }
    Image(
        painter = painterResource(id = if (imageResId != 0) imageResId else R.drawable.plank),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(height = 50.dp, width = 100.dp)
            .blur(if (exercise.done) 10.dp else 0.dp)

    )

    Text(
        text = exercise.name,
        fontSize = 18.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        color = if (exercise.done) Natural500 else Natural900
    )

    Icon(
        imageVector = if (isOpen) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
        contentDescription = null,
    )
}

@Composable
private fun BottomSection(
    exercise: Exercise,
    onUpdate: (AddScreenViewModel.UpdateType) -> Unit,
    onAddClick: () -> Unit,
    selectedDays: Set<Days>,
    onDayToggled: (Days) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .height(2.dp)
                .background(Blue500)
                .fillMaxWidth(),
        )

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SelectCountBox(
                Modifier.weight(1f),
                value = exercise.set,
                label = "Sets",
                onMinusClick = { onUpdate(AddScreenViewModel.UpdateType.SET_MINUS) },
                onPlusClick = { onUpdate(AddScreenViewModel.UpdateType.SET_PLUS) }

            )
            SelectCountBox(
                Modifier.weight(1f),
                value = exercise.rep,
                label = "Reps",
                onMinusClick = { onUpdate(AddScreenViewModel.UpdateType.REP_MINUS) },
                onPlusClick = { onUpdate(AddScreenViewModel.UpdateType.REP_PLUS) }
            )
            SelectCountBox(
                Modifier.weight(1f),
                value = exercise.time,
                label = "Time",
                onMinusClick = { onUpdate(AddScreenViewModel.UpdateType.TIME_MINUS) },
                onPlusClick = { onUpdate(AddScreenViewModel.UpdateType.TIME_PLUS) }
            )
        }

        MultiChoiceSegmentedButton(
            selectedDays = selectedDays,
            onDayToggled = onDayToggled
        )

        AddButton(onAddClick)
    }
}

@Composable
private fun AddButton(onAddClick: () -> Unit) {
    Button(
        onClick = onAddClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green500,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add",
            fontSize = 18.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MultiChoiceSegmentedButton(
    selectedDays: Set<Days>,
    onDayToggled: (Days) -> Unit
) {
    val options = Days.entries.toTypedArray()

    MultiChoiceSegmentedButtonRow {
        options.forEachIndexed { index, day ->
            val isSelected = selectedDays.contains(day)

            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onCheckedChange = {
                    onDayToggled(day)
                },
                checked = isSelected,
                label = {
                    Text(
                        text = day.name,
                        style = MaterialTheme.typography.labelSmall,
                        maxLines = 1
                    )
                },
//                icon = {
//                    SegmentedButtonDefaults.Icon(
//                        active = false
//                    )
//                },
                colors = SegmentedButtonDefaults.colors(
                    activeContentColor = Color.White,
                    activeContainerColor = Blue500,
                    inactiveContentColor = Blue500,
                    inactiveContainerColor = Color.White
                )

            )
        }
    }
}
