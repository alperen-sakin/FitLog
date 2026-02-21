package com.example.fitlog.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fitlog.domain.model.Days
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural100
import com.example.fitlog.ui.theme.Natural500

@Composable
fun DayBox(
    modifier: Modifier = Modifier,
    label: Days,
    selectedDay: Boolean,
    onDaySelected: (Days) -> Unit
) {
    Box(
        modifier = modifier
            .size(45.dp)
            .clip(RoundedCornerShape(size = 10.dp))
            .background(
                color = if (selectedDay) Blue500 else Natural100
            )
            .clickable(onClick = { onDaySelected(label) }),

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label.name,
                color = if (selectedDay) Color.White else Natural500,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )

            if (selectedDay) {
                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        }
    }
}
