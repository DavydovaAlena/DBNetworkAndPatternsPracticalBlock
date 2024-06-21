package ru.adavydova.dbnetworkandpatternsblock.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.adavydova.dbnetworkandpatternsblock.data.models.BouquetDBO.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class BouquetDBO(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(ID)
    val id: String,
    @ColumnInfo(DESCRIPTION)
    val description: String,
    @Embedded
    val decorDBO: DecorDBO? = null
){

    companion object {
        const val TABLE_NAME = "bouquet"
        const val ID = "id"
        const val DESCRIPTION = "description"
    }
}