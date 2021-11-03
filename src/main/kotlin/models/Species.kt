package com.company.models

sealed class Species(open val species: String) {
    class European(override val species: String = "European") : Species(species)
    class Arabic(override val species: String = "Arabic") : Species(species)
    class Nigger(override val species: String = "Nigger") : Species(species)
}