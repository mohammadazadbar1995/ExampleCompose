package ir.examplecompose.Slider

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember {
        mutableFloatStateOf(0f)
    }

    Column {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            steps = 10,
            valueRange = 0f..10f,
        )
        Text(text = "Slider Position: $sliderPosition")

    }
}

@Preview
@Composable
fun SliderMinimalExamplePreview() {
    SliderMinimalExample()
}