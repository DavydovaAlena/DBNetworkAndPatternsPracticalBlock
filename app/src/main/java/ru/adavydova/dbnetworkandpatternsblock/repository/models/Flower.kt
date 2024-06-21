package ru.adavydova.dbnetworkandpatternsblock.repository.models

import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO

data class Flower(
    val id: Long? = null,
    val type: TypeOfFlower,
    val numOfBouquet: String? = null
) {
    enum class TypeOfFlower(val title: String) {
        ROSE("Rose"),
        PEONY("Peony"),
        CHAMOMILE("Chamomile"),
        LILY("Lily"),
        CARNATION("Carnation"),
        ORCHID("Orchid"),
        TULIP("Tulip"),
        DAFFODIL("Daffodil"),
        IRIS("Iris"),
        HYDRANGEA("Hydrangea")
    }

    companion object {
        val flowers = listOf(
            Flower(type = TypeOfFlower.TULIP),
            Flower(type = TypeOfFlower.TULIP),
            Flower(type = TypeOfFlower.TULIP),
            Flower(type = TypeOfFlower.TULIP),
            Flower(type = TypeOfFlower.TULIP),
            Flower(type = TypeOfFlower.CARNATION),
            Flower(type = TypeOfFlower.CARNATION),
            Flower(type = TypeOfFlower.CARNATION),
            Flower(type = TypeOfFlower.CARNATION),
            Flower(type = TypeOfFlower.DAFFODIL),
            Flower(type = TypeOfFlower.DAFFODIL),
            Flower(type = TypeOfFlower.DAFFODIL),
            Flower(type = TypeOfFlower.DAFFODIL),
            Flower(type = TypeOfFlower.DAFFODIL),
            Flower(type = TypeOfFlower.ROSE),
            Flower(type = TypeOfFlower.ROSE),
            Flower(type = TypeOfFlower.ROSE),
            Flower(type = TypeOfFlower.ROSE),
            Flower(type = TypeOfFlower.ROSE),
            Flower(type = TypeOfFlower.PEONY),
            Flower(type = TypeOfFlower.PEONY),
            Flower(type = TypeOfFlower.PEONY),
            Flower(type = TypeOfFlower.PEONY),
            Flower(type = TypeOfFlower.PEONY),
        )
    }
}
