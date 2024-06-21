package ru.adavydova.dbnetworkandpatternsblock.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.adavydova.dbnetworkandpatternsblock.data.dao.FlowersDao
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toBouquet
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toBouquetDBO
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toBouquetWithFlowers
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toFlower
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toFlowerDBO
import ru.adavydova.dbnetworkandpatternsblock.repository.mapper.toFlowerType
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Bouquet
import ru.adavydova.dbnetworkandpatternsblock.repository.models.BouquetWithFlowers
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Flower
import ru.adavydova.dbnetworkandpatternsblock.repository.models.FlowersByType
import ru.adavydova.dbnetworkandpatternsblock.repository.repository.FlowersRepository
import javax.inject.Inject


class FlowersRepositoryImpl @Inject constructor(
    private val dao: FlowersDao
) : FlowersRepository {

    override suspend fun getBouquet(id: String): Result<Bouquet> {
        return try {
            Result.success(dao.getBouquet(id).toBouquet())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getAvailableFlowersGroupByType(): Result<Flow<List<FlowersByType>>> {
        return try {
            Result.success(
                dao.getFlowersGroupByType().map {
                    it.entries.map { (type, flowers) ->
                        FlowersByType(
                            type.toFlowerType(),
                            flowers.map { flowerDBO -> flowerDBO.toFlower() }
                        )
                    }
                }
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getFlowersGroupByType(): Result<Flow<List<FlowersByType>>> {
        return try {
            Result.success(
                dao.getFlowersGroupByType().map {
                    it.entries.map { (type, flowers) ->
                        FlowersByType(
                            type.toFlowerType(),
                            flowers.map { flowerDBO -> flowerDBO.toFlower() }
                        )
                    }
                }
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun insertFlower(flower: Flower): Result<Unit> {
        return try {
            Result.success(dao.insertFlower(flower.toFlowerDBO()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteFlower(flower: Flower): Result<Unit> {
        return try {
            Result.success(dao.deleteFlower(flower.toFlowerDBO()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    override suspend fun insertBouquet(bouquet: Bouquet): Result<Unit> {
        return try {
            Result.success(dao.insertBouquet(bouquet.toBouquetDBO()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateFlowers(flowers: List<Flower>): Result<Unit> {
        return try {
            Result.success(dao.updateFlowers(flowers.map { it.toFlowerDBO() }))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteBouquet(bouquet: Bouquet): Result<Unit> {
        return try {
            Result.success(dao.deleteBouquet(bouquet.toBouquetDBO()))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getBouquetsWithFlowers(): Result<List<BouquetWithFlowers>> {
        return try {
            Result.success(
                dao.getBouquetsWithFlowers().map {
                    it.toBouquetWithFlowers()
                })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}