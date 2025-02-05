package com.adormantsakthi.watchfacemobileapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.adormantsakthi.watchfacemobileapp.R

@Composable
fun Homescreen() {

    val editableComponents = setOf(
        "Colours",
        "Complication 1",
        "Complication 2",
    )

    val selectedComponents = remember { mutableStateOf("Colours") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your Watch Face",
            style = MaterialTheme.typography.titleMedium,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.watchface),
            contentDescription = "Sample Watch Face",
            modifier = Modifier
                .size(225.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Connected to Galaxy Watch 5 (5X6Y)",
            style = MaterialTheme.typography.displaySmall.copy(
                color = Color.White.copy(alpha = 0.6f)
            )
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            editableComponents.forEach{component ->
                EditWatchFaceSection(component, selectedComponents)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(400.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Spacer(modifier = Modifier.height(125.dp))
    }
}

@Composable
fun EditWatchFaceSection(
    text: String,
    selectedComponents: androidx.compose.runtime.MutableState<String>
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                1.dp,
                if (selectedComponents.value == text) Color.White else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                selectedComponents.value = text
            }
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 10.dp)
        )
    }
}