package com.example.fitlog.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fitlog.domain.model.Days

@Composable
fun DaysBox(
    modifier: Modifier,
    selectedDay: Days,
    onDaySelected: (String) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(Days.entries) { day ->
            DayBox(
                label = day.name,
                selectedDay = (day == selectedDay),
                onDaySelected = onDaySelected

            )
        }
    }
}
