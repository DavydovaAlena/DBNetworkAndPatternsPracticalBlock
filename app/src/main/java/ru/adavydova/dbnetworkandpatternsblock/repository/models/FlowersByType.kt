package ru.adavydova.dbnetworkandpatternsblock.repository.models

data class FlowersByType (
    val type: Flower.TypeOfFlower,
    val flowers: List<Flower>
)