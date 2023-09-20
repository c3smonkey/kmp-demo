// Repository Layer
//The MyRepository class in the repository layer uses this RemoteDataSource to fetch data.
//This is where you would put any additional logic for managing your data, such as caching.
package ch.c3smonkey.app.repository

import ch.c3smonkey.app.data.RemoteDataSource


class MyRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun fetchDataFromRemote(): Int {
        return remoteDataSource.fetchData()
    }
}
