package ir.examplecompose.ui.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilledButtonExample(onClick: () -> Unit) {

    var press by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = {press++}) {
            Text("Filled")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = "$press")
    }

}

@Preview
@Composable
fun FilledButtonExamplePreview() {
    FilledButtonExample(onClick = {})
}