package fr.iutlan.tp4.carrefour.controller

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import fr.iutlan.tp4.carrefour.state.CarrefourState
import fr.iutlan.tp4.feu3.state.FeuCouleur
import fr.iutlan.tp4.carrefour.state.*

class CarrefourViewModel : ViewModel() {

    private val _state = mutableStateOf(CarrefourState())

    var state
        get() = _state.value
        private set(value) { _state.value = value }

    init {
        state = CarrefourState()
    }

    fun suivant() {
        val couleur = state.feuCourant.couleur
        when (couleur) {
            FeuCouleur.ROUGE -> {
                // passe au vert
                state = state.copyChangeCouleurCourant(FeuCouleur.VERT)
            }
            FeuCouleur.VERT -> {
                // passe à l'orange
                state = state.copyChangeCouleurCourant(FeuCouleur.ORANGE)
            }
            FeuCouleur.ORANGE -> {
                // passe au rouge et change feu courant (cycle)
                state = state.copyChangeCouleurCourant(FeuCouleur.ROUGE)
                state = state.copyChangeCourant(state.courant + 1)
            }
        }
    }
}
