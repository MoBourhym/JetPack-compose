package fr.iutlan.tp4.feu3.controller

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import fr.iutlan.tp4.feu3.state.*

class Feu3ViewModel : ViewModel() {

    private val _state = mutableStateOf(Feu3State())
    var state
        get() = _state.value
        private set(value) {
            _state.value = value
        }

    init {
        reset()
    }

    fun reset() {
        state = Feu3State()
    }

    fun suivant() {
        state = with(state) {
            when (couleur) {
                FeuCouleur.ROUGE -> copyChangeCouleur(FeuCouleur.VERT)
                FeuCouleur.VERT -> copyChangeCouleur(FeuCouleur.ORANGE)
                FeuCouleur.ORANGE -> copyChangeCouleur(FeuCouleur.ROUGE)
            }
        }
    }
}
