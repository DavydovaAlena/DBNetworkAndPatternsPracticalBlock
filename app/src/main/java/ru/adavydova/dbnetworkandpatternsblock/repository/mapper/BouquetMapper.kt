package ru.adavydova.dbnetworkandpatternsblock.repository.mapper

import ru.adavydova.dbnetworkandpatternsblock.data.models.BouquetDBO
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Bouquet

fun BouquetDBO.toBouquet() = Bouquet(
    id = id,
    description = description,

)

fun Bouquet.toBouquetDBO() = BouquetDBO(
    id = id,
    description = description
)
