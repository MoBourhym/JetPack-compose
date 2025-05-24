package fr.iutlan.tp4.carrefour.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.iutlan.tp4.carrefour.state.CarrefourState
import fr.iutlan.tp4.feu3.ui.Feu3ViewV3 // Assure-toi que ce composable est bien présent

@Composable
fun CarrefourView(state: CarrefourState, modifier: Modifier = Modifier, size: Dp = 180.dp) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(size * 2)
            .padding(60.dp)
    ) {
        val mod = Modifier.scale(0.5f).align(Alignment.Center)
        // Feu en haut (0)
        Feu3ViewV3(state = state.feux[0], modifier = mod.offset(y = -size))
        // Feu en bas (1)
        Feu3ViewV3(state = state.feux[1], modifier = mod.offset(y = size))
        // Feu à gauche (2)
        Feu3ViewV3(state = state.feux[2], modifier = mod.offset(x = -size))
        // Feu à droite (3)
        Feu3ViewV3(state = state.feux[3], modifier = mod.offset(x = size))
    }
}
