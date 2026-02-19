package com.example.fitlog.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Neutral500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Blue500
        ),
        title = {
            Text(
                text = "FITLOG",
                fontWeight = FontWeight.Black,
                fontFamily = Inter,
                fontSize = 30.sp
            )
        },
        actions = {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(
                        color = Neutral500.copy(alpha = 0.1f),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Rounded.AddCircleOutline,
                    contentDescription = "Add",
                    tint = Color.Black,
                )
            }
        }

    )
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}
