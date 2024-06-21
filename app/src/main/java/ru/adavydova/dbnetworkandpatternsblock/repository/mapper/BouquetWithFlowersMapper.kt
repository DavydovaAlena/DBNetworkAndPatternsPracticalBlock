package ru.adavydova.dbnetworkandpatternsblock.repository.mapper

import ru.adavydova.dbnetworkandpatternsblock.data.models.relation.BouquetWithFlowersDBO
import ru.adavydova.dbnetworkandpatternsblock.repository.models.BouquetWithFlowers


fun BouquetWithFlowersDBO.toBouquetWithFlowers() = BouquetWithFlowers(
    bouquet = bouquetDBO.toBouquet(),
    flower = flowerDBO.map { it.toFlower() }
)
