package ch.c3smonkey.app.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ch.c3smonkey.app.data.RemoteDataSourceImpl
import ch.c3smonkey.app.domain.MyModel
import ch.c3smonkey.app.repository.MyRepository
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory


@Composable
fun App() {
    // Create an instance of your RemoteDataSource and Repository here.
    val remoteDataSource = RemoteDataSourceImpl()
    val myRepository = MyRepository(remoteDataSource)
    // Pass the Repository to your Model.
    val model = MyModel(myRepository)
    // Pass the Model to your ViewModel.
    val viewModel = getViewModel(
        key = "simple-model",
        factory = viewModelFactory {
            SimpleViewModel(model)
        }
    )
    val count by viewModel.count.collectAsState()

    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { viewModel.incrementCount() }) {
                Text("Count is $count")
            }
        }
    }
}


expect fun getPlatformName(): String


