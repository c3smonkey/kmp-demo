package ch.c3smonkey.app.domain

import kotlinx.coroutines.delay

// TODO: Implement your Model here. This could be a class or interface that provides methods for accessing your data.
// For example, you might have methods for fetching data from a database or making network requests.
class MyModel {
    // Simulate a remote service call
    suspend fun fetchDataFromRemote(): Int {
        delay(1000) // Simulate network delay
        return (0..100).random() // Simulate random data from remote service
    }
}
