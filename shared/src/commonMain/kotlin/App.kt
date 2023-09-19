import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

// TODO: Implement your Model here. This could be a class or interface that provides methods for accessing your data.
// For example, you might have methods for fetching data from a database or making network requests.
class MyModel {
    // TODO: Implement methods for accessing your data here.
}

class SimpleViewModel(private val model: MyModel) : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun incrementCount() {
        _count.value++
        // TODO: Here you can call methods on your Model to fetch or update data.
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {


// TODO: Create an instance of your Model here. You might need to provide additional dependencies.
    val model = MyModel()

    // Pass the Model to your ViewModel.
    //    val viewModel = SimpleViewModel(model)

   // Factory version
    val viewModel = getViewModel(
        key = "simple-model",
        factory = viewModelFactory {
            SimpleViewModel(model)
        }
    )
    val count by viewModel.count.collectAsState()


    MaterialTheme {

        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = { viewModel.incrementCount() }) {
                Text("Count is $count")
            }

            Button(onClick = {
                greetingText = "Hello, ${getPlatformName()}"
                showImage = !showImage
            }) {
                Text(greetingText)
            }
            AnimatedVisibility(showImage) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null
                )
            }
        }
    }
}

expect fun getPlatformName(): String
