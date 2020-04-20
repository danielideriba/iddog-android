package br.android.iddog.data


import br.android.iddog.data.remote.Breed
import br.android.iddog.data.remote.DogAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DogsRepository
@Inject constructor(private val dogAPIService: DogAPIService, private val executor: Executor) {
    fun getBreed(
        onComplete: (Breed?) -> Unit,
        onError: (Throwable?) -> Unit
    ){
        dogAPIService.getBreed().enqueue(object : Callback<Breed>{
            override fun onResponse(call: Call<Breed>, response: Response<Breed>) {
                executor.execute {
                    Timber.d("---" + response.body())
                    onComplete(response?.body())
                }
            }

            override fun onFailure(call: Call<Breed>, t: Throwable) {
                onError(t)
            }

        })
    }
}