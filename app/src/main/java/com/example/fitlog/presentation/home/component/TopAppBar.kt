package com.example.fitlog.presentation.home.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "FitLog",
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    )
}
@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}