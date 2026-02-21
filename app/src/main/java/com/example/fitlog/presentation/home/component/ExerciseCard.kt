package com.example.fitlog.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.ui.theme.Green50
import com.example.fitlog.ui.theme.Green500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural500
import com.example.fitlog.ui.theme.Natural900

@Composable
fun ExerciseCard(
    exercise: Exercise,
    onCardClick: (Exercise) -> Unit,
    modifier: Modifier
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { onCardClick(exercise) }),
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (exercise.done) Green50 else Color.White
        ),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = exercise.img),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .blur(if (exercise.done) 10.dp else 0.dp)

                )

                if (exercise.done) {
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = Green500
                            )
                            .padding(vertical = 8.dp, horizontal = 16.dp),

                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckCircleOutline,
                            contentDescription = null,
                            tint = Color.White
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "COMPLETED",
                            fontSize = 14.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }

            ExerciseInfo(exercise)
        }
    }
}

@Composable
private fun ExerciseInfo(exercise: Exercise) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Text(
                text = exercise.name,
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                color = if (exercise.done) Natural500 else Natural900
            )

            Icon(
                imageVector = if (exercise.done) Icons.Default.CheckCircleOutline else Icons.Outlined.Circle,
                contentDescription = null,
                tint = if (exercise.done) Green500 else Natural500
            )
        }

        val repsOrTime = if (exercise.rep > 0) {
            "${exercise.rep} Reps"
        } else {
            "${exercise.time} Sec"
        }

        Text(
            text = "${exercise.set} Sets x $repsOrTime ",
            fontSize = 14.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            color = Natural500
        )
    }
}
