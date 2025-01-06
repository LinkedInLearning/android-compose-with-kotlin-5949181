package com.example.red30.compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.red30.ui.theme.Red30TechTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SessionTags(
    modifier: Modifier = Modifier,
    track: String,
    roomName: String
) {
    FlowRow(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = track,
            modifier = Modifier.sessionTag(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
        )
        Text(
            text = roomName,
            modifier = Modifier.sessionTag(
                color = MaterialTheme.colorScheme.tertiaryContainer
            )
        )
    }
}

fun Modifier.sessionTag(color: Color) =
    this then Modifier.border(
        border = BorderStroke(
            width = 1.dp,
            color = color
        )
    ) then Modifier.padding(
        horizontal = 6.dp,
        vertical = 4.dp,
    )

@Preview(showBackground = true)
@Composable
private fun SessionTagsPreview() {
    Red30TechTheme {
        SessionTags(
            track = "AI for Beginners",
            roomName = "201"
        )
    }
}
