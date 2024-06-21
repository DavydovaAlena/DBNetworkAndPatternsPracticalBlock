package ru.adavydova.dbnetworkandpatternsblock.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.MapColumn
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.adavydova.dbnetworkandpatternsblock.data.models.BouquetDBO
import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO
import ru.adavydova.dbnetworkandpatternsblock.data.models.relation.BouquetWithFlowersDBO

@Dao
interface FlowersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlower(flowerDBO: FlowerDBO)

    @Delete
    suspend fun deleteFlower(flowerDBO: FlowerDBO)

    @Query("SELECT * FROM ${FlowerDBO.TABLE_NAME}")
    fun getFlowers(): Flow<List<FlowerDBO>>

    @Query("SELECT * FROM ${FlowerDBO.TABLE_NAME} ORDER BY ${FlowerDBO.TYPE}")
    fun getFlowersGroupByType(): Flow<Map<@MapColumn(columnName = FlowerDBO.TYPE) FlowerDBO.TypeOfFlower, List<FlowerDBO>>>


    @Query("SELECT * FROM ${FlowerDBO.TABLE_NAME} WHERE ${FlowerDBO.NUM_OF_BOUQUET} IS NULL ORDER BY ${FlowerDBO.TYPE}")
    fun getAvailableFlowersGroupByType(): Flow<Map<@MapColumn(columnName = FlowerDBO.TYPE) FlowerDBO.TypeOfFlower, List<FlowerDBO>>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquet(bouquetDBO: BouquetDBO)

    @Query("SELECT * FROM ${BouquetDBO.TABLE_NAME} WHERE ${BouquetDBO.ID} =:id")
    suspend fun getBouquet(id:String): BouquetDBO

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFlowers(flowersDBO: List<FlowerDBO>)

    @Delete
    suspend fun deleteBouquet(bouquetDBO: BouquetDBO)

    @Transaction
    @Query("SELECT * FROM ${BouquetDBO.TABLE_NAME}")
    suspend fun getBouquetsWithFlowers(): List<BouquetWithFlowersDBO>

}