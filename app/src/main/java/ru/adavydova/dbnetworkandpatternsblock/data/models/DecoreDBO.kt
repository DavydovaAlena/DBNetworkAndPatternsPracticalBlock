package ru.adavydova.dbnetworkandpatternsblock.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DecorDBO.TABLE_NAME)
data class DecorDBO (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(ID)
    val id: Long? = null,
    @ColumnInfo(TITLE)
    val title: String,
    @ColumnInfo(PRICE)
    val price: Double

){
    companion object {
        const val TABLE_NAME = "decor"
        const val ID = "decor_id"
        const val TITLE = "decor_title"
        const val PRICE = "decor_price"
    }
}