package ru.adavydova.dbnetworkandpatternsblock.data.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO.Companion.TABLE_NAME
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Flower

@Entity(
    tableName = TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BouquetDBO::class,
            parentColumns = arrayOf(BouquetDBO.ID),
            childColumns = arrayOf(FlowerDBO.NUM_OF_BOUQUET),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)

data class FlowerDBO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(ID)
    val id: Long? = null,
    @ColumnInfo(TYPE)
    val type: TypeOfFlower,
    @ColumnInfo(NUM_OF_BOUQUET, index = true)
    val numOfBouquet: String? = null,
    @ColumnInfo(COUNTRY_OF_ORIGIN, defaultValue = "-")
    val countryOfOrigin: String = "-"
) {
    companion object {
        const val TABLE_NAME = "flowers"
        const val ID = "id"
        const val TYPE = "type"
        const val NUM_OF_BOUQUET = "numOfBouquet"
        const val COUNTRY_OF_ORIGIN = "countryOfOrigin"


    }

    class FlowerConverters() {
        @TypeConverter
        fun fromTypeOfFlowerToString(value: TypeOfFlower): String {
            return value.name
        }

        @TypeConverter
        fun fromStringToTypeOfFlower(value: String): TypeOfFlower {
            return enumValueOf<TypeOfFlower>(value)
        }
    }

    enum class TypeOfFlower {
        ROSE,
        PEONY,
        CHAMOMILE,
        LILY,
        CARNATION,
        ORCHID,
        TULIP,
        DAFFODIL,
        IRIS,
        HYDRANGEA
    }



}
