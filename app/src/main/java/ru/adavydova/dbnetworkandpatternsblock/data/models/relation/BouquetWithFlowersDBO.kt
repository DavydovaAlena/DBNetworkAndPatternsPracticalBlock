package ru.adavydova.dbnetworkandpatternsblock.data.models.relation

import androidx.room.Embedded
import androidx.room.Relation
import ru.adavydova.dbnetworkandpatternsblock.data.models.BouquetDBO
import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO


data class BouquetWithFlowersDBO (
    @Embedded
    val bouquetDBO: BouquetDBO,
    @Relation(
        parentColumn = BouquetDBO.ID,
        entityColumn = FlowerDBO.NUM_OF_BOUQUET
    )
    val flowerDBO: List<FlowerDBO>
)