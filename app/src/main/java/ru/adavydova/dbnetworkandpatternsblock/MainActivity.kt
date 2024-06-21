package ru.adavydova.dbnetworkandpatternsblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.adavydova.dbnetworkandpatternsblock.presentation.FlowersViewModel
import ru.adavydova.dbnetworkandpatternsblock.ui.theme.DBNetworkAndPatternsBlockTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            DBNetworkAndPatternsBlockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val vm = hiltViewModel<FlowersViewModel>()

                    LaunchedEffect(key1 = Unit) {
                        vm.sellBouquet()
                    }


                }
            }
        }
    }
}
