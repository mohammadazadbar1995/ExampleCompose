package ir.examplecompose.ui.chip

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AssistChipExample() {
    AssistChip(
        onClick = { Log.d("Assist chip", "hello world") },
        label = { Text(text = "Assist Chip") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Localized description",
                modifier = Modifier.size(AssistChipDefaults.IconSize)
            )
        },
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipExample() {

    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        selected = selected,
        label = {
            Text(text = "Filter Chip")
        },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit
) {
    var enabled by remember {
        mutableStateOf(true)
    }
    if (!enabled) return

    InputChip(
        selected =
        enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = {
            Text(text = text)
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.IconSize)
            )
        }
    )

}


@Preview
@Composable
fun AssistChipExamplePreview() {
//    AssistChipExample()
    InputChipExample(
        text = "Input Chip",
        onDismiss = { Log.d("Input chip", "dismissed") }
    )
}