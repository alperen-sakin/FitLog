package com.example.fitlog.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural50
import com.example.fitlog.ui.theme.Natural900
import kotlin.math.roundToInt

@Composable
fun ProgressCard(
    modifier: Modifier = Modifier,
    leftExercises: Int,
    progress: Float,

) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        )

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Daily Progress",
                    fontFamily = Inter,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Natural900
                )

                Text(
                    text = "%${(progress * 100).roundToInt()}",
                    fontFamily = Inter,
                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp,
                    color = Blue500

                )
            }

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth()
                    .height(8.dp)
                    .clip(CircleShape),
                trackColor = Natural50,
                color = Blue500,
                strokeCap = StrokeCap.Round

            )

            Text(
                text = if (leftExercises > 0) "$leftExercises Exercises left" else "All exercises completed",
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp

            )
        }
    }
}
