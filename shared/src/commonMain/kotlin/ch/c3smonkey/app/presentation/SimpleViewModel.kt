package ch.c3smonkey.app.presentation

import ch.c3smonkey.app.domain.MyModel
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SimpleViewModel(private val model: MyModel) : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun incrementCount() {
        viewModelScope.launch {
            val data = model.fetchDataFromRemote()
            _count.value = data
        }
    }
}
