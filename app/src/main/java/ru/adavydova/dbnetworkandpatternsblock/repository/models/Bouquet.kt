package ru.adavydova.dbnetworkandpatternsblock.repository.models


data class Bouquet(
    val id: String,
    val description: String,
    val decor: Decor? = null
)