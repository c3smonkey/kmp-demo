package ch.c3smonkey.app.presentation.ch.c3smonkey.app.presentation

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ch.c3smonkey.app.presentation.MainView


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        MainView()
    }
}
