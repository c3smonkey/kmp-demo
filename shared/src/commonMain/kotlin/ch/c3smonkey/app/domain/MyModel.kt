// Domain Layer
// MyModel class in the domain layer to use MyRepository instead of fetching the data directly.
package ch.c3smonkey.app.domain

import ch.c3smonkey.app.repository.MyRepository


class MyModel(private val myRepository: MyRepository) {
    suspend fun fetchDataFromRemote(): Count {
        val data = myRepository.fetchDataFromRemote()
        return Count(data) // Wrap the data in a Count value object
    }
}
