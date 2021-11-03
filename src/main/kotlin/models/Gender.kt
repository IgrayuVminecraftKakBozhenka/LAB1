package com.company.models

sealed class Gender(open val gender: String) {
    class Male(override val gender: String = "Male") : Gender(gender)
    class Female(override val gender: String = "Female") : Gender(gender)
}