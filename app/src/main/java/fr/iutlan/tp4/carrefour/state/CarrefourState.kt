package fr.iutlan.tp4.carrefour.state

import fr.iutlan.tp4.feu3.state.Feu3State
import fr.iutlan.tp4.feu3.state.FeuCouleur

@Suppress("ArrayInDataClass")
data class CarrefourState(
    val courant: Int = 0, // feu courant (vert ou orange, les autres rouges)
    val feux: Array<Feu3State> = arrayOf(
        Feu3State(), Feu3State(), Feu3State(), Feu3State()
    )
) {
    val feuCourant get() = feux[courant]

    fun copyChangeCouleurCourant(couleur: FeuCouleur): CarrefourState {
        // copie le tableau des feux pour modifier la couleur du feu courant
        val newFeux = feux.copyOf()
        newFeux[courant] = feux[courant].copy(couleur = couleur)
        return copy(feux = newFeux)
    }

    fun copyChangeCourant(num: Int): CarrefourState {
        // num ramené modulo 4 (taille des feux)
        val newNum = num % feux.size
        return copy(courant = newNum)
    }
}
