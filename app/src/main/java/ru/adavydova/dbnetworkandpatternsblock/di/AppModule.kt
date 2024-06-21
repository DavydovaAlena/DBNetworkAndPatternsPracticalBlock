package ru.adavydova.dbnetworkandpatternsblock.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.adavydova.dbnetworkandpatternsblock.data.FlowersDatabase
import ru.adavydova.dbnetworkandpatternsblock.data.FlowersRepositoryImpl
import ru.adavydova.dbnetworkandpatternsblock.data.dao.FlowersDao
import ru.adavydova.dbnetworkandpatternsblock.repository.repository.FlowersRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
    }




    @Provides
    @Singleton
    fun provideFlowersDao(application: Application): FlowersDao {
        return Room.databaseBuilder(
            application,
            FlowersDatabase::class.java,
            FlowersDatabase.NAME
        )
            .addMigrations(FlowersDatabase.migrateFrom2To3())
            .build()
            .dao
    }

    @Provides
    @Singleton
    fun provideRepository(dao: FlowersDao): FlowersRepository {
        return FlowersRepositoryImpl(dao)
    }
}