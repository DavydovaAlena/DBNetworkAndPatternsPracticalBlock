package ru.adavydova.dbnetworkandpatternsblock.repository.repository

import kotlinx.coroutines.flow.Flow
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Bouquet
import ru.adavydova.dbnetworkandpatternsblock.repository.models.BouquetWithFlowers
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Flower
import ru.adavydova.dbnetworkandpatternsblock.repository.models.FlowersByType

interface FlowersRepository {
    suspend fun insertFlower(flower: Flower): Result<Unit>
    suspend fun deleteFlower(flower: Flower): Result<Unit>
    suspend fun insertBouquet(bouquet: Bouquet): Result<Unit>
    suspend fun updateFlowers(flowers: List<Flower>): Result<Unit>
    suspend fun deleteBouquet(bouquet: Bouquet): Result<Unit>
    suspend fun getBouquet(id: String): Result<Bouquet>
    suspend fun getBouquetsWithFlowers(): Result<List<BouquetWithFlowers>>
    fun getFlowersGroupByType(): Result<Flow<List<FlowersByType>>>
    fun getAvailableFlowersGroupByType(): Result<Flow<List<FlowersByType>>>

}