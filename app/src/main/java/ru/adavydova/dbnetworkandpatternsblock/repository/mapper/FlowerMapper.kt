package ru.adavydova.dbnetworkandpatternsblock.repository.mapper

import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Flower


fun FlowerDBO.toFlower() = Flower(
    id = id,
    type = type.toFlowerType(),
    numOfBouquet = numOfBouquet
)

fun FlowerDBO.TypeOfFlower.toFlowerType(): Flower.TypeOfFlower {
    return enumValueOf<Flower.TypeOfFlower>(name)

}


fun Flower.toFlowerDBO() = FlowerDBO(
    id = id,
    type = type.toFlowerDBOType(),
    numOfBouquet = numOfBouquet
)

fun Flower.TypeOfFlower.toFlowerDBOType(): FlowerDBO.TypeOfFlower {
    return enumValueOf<FlowerDBO.TypeOfFlower>(name)

}