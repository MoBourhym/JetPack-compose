package fr.iutlan.tp4.carrefour.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.iutlan.tp4.carrefour.controller.CarrefourViewModel

@Composable
fun MainActivityCarrefourView(viewmodel: CarrefourViewModel = viewModel()) {
    val state = viewmodel.state

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CarrefourView(state = state)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { viewmodel.suivant() }) {
            Text("Suivant")
        }
    }
}
