package ru.adavydova.dbnetworkandpatternsblock.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Bouquet
import ru.adavydova.dbnetworkandpatternsblock.repository.models.Flower
import ru.adavydova.dbnetworkandpatternsblock.repository.repository.FlowersRepository
import javax.inject.Inject

@HiltViewModel
class FlowersViewModel @Inject constructor(
    private val repository: FlowersRepository
) : ViewModel() {


    fun sellBouquet() {
        viewModelScope.launch {
            insertFlowers()
            val bouquet = createAndGetBouquet()
            bouquet.onSuccess { successBouquet ->
                updateFlowers(successBouquet).onSuccess {
                    deleteBouquet(successBouquet)
                }
            }
        }
    }

    private suspend fun insertFlowers() = withContext(Dispatchers.IO) {
        Flower.flowers.forEach {
            repository.insertFlower(it)
        }
    }

    private suspend fun createAndGetBouquet() = withContext(Dispatchers.IO) {
        repository.insertBouquet(Bouquet(id = "bouquet1", description = "..."))
        val bouquet = repository.getBouquet("bouquet1")
        bouquet
    }

    /*
     Hаходит совободные цветы (незадействованные в других букетах),
     выбирает по одному цветку каждого вида (просто для простоты) и
     обновляет у них поле id_bouquet. После передаем их в updateFlowers,
     тем самым добавляя их в букет.
      */

    private suspend fun updateFlowers(bouquet: Bouquet) = withContext(Dispatchers.IO) {
        repository.getAvailableFlowersGroupByType().onSuccess {
            it.map { flowersByTypeList ->
                val flowers = flowersByTypeList.map { type ->
                    type.flowers.first().copy(numOfBouquet = bouquet.id)
                }
                repository.updateFlowers(flowers)
            }
        }
    }


    //  Удаляем(продаем) букет и с ним все входящие в его состав цветы

    suspend fun deleteBouquet(bouquet: Bouquet) = withContext(Dispatchers.IO){
        repository.deleteBouquet(bouquet)
    }
}