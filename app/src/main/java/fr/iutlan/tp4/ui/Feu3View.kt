package fr.iutlan.tp4.feu3.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.hsv
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.iutlan.tp4.feu3.controller.Feu3ViewModel
import fr.iutlan.tp4.feu3.state.*

@Composable
fun MainActivityFeu3View(viewmodel: Feu3ViewModel = viewModel()) {
    val state = viewmodel.state

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Feu3ViewV1(state, modifier = Modifier.padding(16.dp))
        Feu3ViewV2(state, modifier = Modifier.padding(16.dp))
        Feu3ViewV3(state, modifier = Modifier.padding(16.dp))

        Button(
            onClick = { viewmodel.suivant() },
            modifier = Modifier.fillMaxWidth().padding(32.dp)
        ) {
            Text(text = "état suivant")
        }
    }
}

@Composable
fun Feu3ViewV1(state: Feu3State, modifier: Modifier = Modifier) {
    Text(
        text = "Feu ${state.nomCouleur}",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier,
    )
}

@Composable
fun Feu3ViewV2(state: Feu3State, modifier: Modifier = Modifier) {
    Column(modifier.wrapContentSize()) {
        Row(Modifier.align(Alignment.Start).padding(horizontal = 16.dp)) {
            RadioButton(selected = state.rouge, onClick = null)
            Text(text = "rouge", modifier = Modifier.padding(start = 16.dp))
        }
        Row(Modifier.align(Alignment.Start).padding(horizontal = 16.dp)) {
            RadioButton(selected = state.orange, onClick = null)
            Text(text = "orange", modifier = Modifier.padding(start = 16.dp))
        }
        Row(Modifier.align(Alignment.Start).padding(horizontal = 16.dp)) {
            RadioButton(selected = state.vert, onClick = null)
            Text(text = "vert", modifier = Modifier.padding(start = 16.dp))
        }
    }
}

@Composable
fun Feu3ViewV3(state: Feu3State, modifier: Modifier = Modifier) {
    Column(modifier = modifier.wrapContentSize(Alignment.Center)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(48.dp, 128.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.DarkGray)
        ) {
            Column {
                Feu(Color.Red, state.rouge)
                Feu(Color.Orange, state.orange)
                Feu(Color.Green, state.vert)
            }
        }
    }
}

@Composable
fun Feu(color: Color, isOn: Boolean, modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier.size(40.dp).padding(4.dp),
        onDraw = {
            drawCircle(color = if (isOn) color else Color.Gray)
        }
    )
}

private val Color.Companion.Orange: Color
    get() = hsv(33.0f, 1.0f, 1.0f)

@Preview(showBackground = true)
@Composable
fun Feu3ViewV3Preview() {
    Feu3ViewV3(state = Feu3State(FeuCouleur.ORANGE))
}
