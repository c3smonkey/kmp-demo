// Data Layer
//In this example, I’ve added a RemoteDataSource interface and an implementation RemoteDataSourceImpl in the data layer.
// This is where you would put your code for fetching data from a remote service.
package ch.c3smonkey.app.data

import kotlinx.coroutines.delay

interface RemoteDataSource {
    suspend fun fetchData(): Int
}

class RemoteDataSourceImpl : RemoteDataSource {
    override suspend fun fetchData(): Int {
        delay(1000) // Simulate network delay
        return (0..100).random() // Simulate random data from remote service
    }
}
