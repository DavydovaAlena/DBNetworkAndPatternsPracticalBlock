package ru.adavydova.dbnetworkandpatternsblock.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.adavydova.dbnetworkandpatternsblock.data.dao.FlowersDao
import ru.adavydova.dbnetworkandpatternsblock.data.models.BouquetDBO
import ru.adavydova.dbnetworkandpatternsblock.data.models.DecorDBO
import ru.adavydova.dbnetworkandpatternsblock.data.models.FlowerDBO

@Database(
    entities = [BouquetDBO::class, FlowerDBO::class, DecorDBO::class],
    autoMigrations = [AutoMigration(1, 2)],
    version = 3
)
@TypeConverters(FlowerDBO.FlowerConverters::class)
abstract class FlowersDatabase : RoomDatabase() {
    abstract val dao: FlowersDao

    companion object {
        const val NAME = "flowers.db"


        fun migrateFrom2To3() = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS ${DecorDBO.TABLE_NAME} " +
                            "(${DecorDBO.ID} INTEGER PRIMARY KEY AUTOINCREMENT, ${DecorDBO.TITLE} " +
                            "TEXT NOT NULL, ${DecorDBO.PRICE} REAL NOT NULL)"
                )
                db.execSQL(
                    "ALTER TABLE ${BouquetDBO.TABLE_NAME} ADD COLUMN ${DecorDBO.ID} INT"
                )
                db.execSQL(
                    "ALTER TABLE ${BouquetDBO.TABLE_NAME} ADD COLUMN ${DecorDBO.TITLE} TEXT"
                )
                db.execSQL(
                    "ALTER TABLE ${BouquetDBO.TABLE_NAME} ADD COLUMN ${DecorDBO.PRICE} REAL"
                )
            }
        }
    }


}