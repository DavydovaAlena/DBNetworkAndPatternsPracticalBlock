package ru.adavydova.dbnetworkandpatternsblock.repository.models


data class BouquetWithFlowers(
    val bouquet: Bouquet,
    val flower: List<Flower>
)