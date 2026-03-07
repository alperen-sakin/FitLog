package com.example.fitlog.presentation.addScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitlog.ui.theme.Blue500
import com.example.fitlog.ui.theme.Inter
import com.example.fitlog.ui.theme.Natural500

@Composable
fun SelectCountBox(
    modifier: Modifier = Modifier,
    value: Int,
    label: String,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(4.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            color = Natural500
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Natural500,
                    shape = CircleShape
                )
                .background(
                    color = Color.White
                ),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = onMinusClick

                ),
                tint = Color.Red
            )

            Text(
                text = value.toString(),
                fontSize = 18.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                color = Blue500
            )

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.clickable(
                    onClick = onPlusClick

                ),
                tint = Color.Green
            )
        }
    }
}
