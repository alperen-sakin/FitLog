package com.example.fitlog.presentation.addScreen.component

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
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
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural500
import com.example.fitlog.ui.theme.Natural900

@SuppressLint("LocalContextResourcesRead")
@Composable
fun SelectExerciseBox(
    exercise: Exercise,
    modifier: Modifier = Modifier,
) {
    var isOpen by rememberSaveable { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { }),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
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

            AnimatedVisibility(visible = isOpen) {
                Column {
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .background(Blue500)
                            .fillMaxWidth()
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
                            onMinusClick = { /*TODO*/ },
                            onPlusClick = { /*TODO*/ }
                        )
                        SelectCountBox(
                            Modifier.weight(1f),
                            value = exercise.rep,
                            label = "Reps",
                            onMinusClick = { /*TODO*/ },
                            onPlusClick = { /*TODO*/ }
                        )
                        SelectCountBox(
                            Modifier.weight(1f),
                            value = exercise.time,
                            label = "Time",
                            onMinusClick = { /*TODO*/ },
                            onPlusClick = { /*TODO*/ }
                        )
                    }
                }
            }
        }
    }
}
