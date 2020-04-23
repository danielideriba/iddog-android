package br.android.iddog.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.android.iddog.data.error.ErrorResponse
import br.android.iddog.data.remote.BreedImage
import br.android.iddog.data.remote.DogAPIService
import br.android.iddog.data.source.RepositoryCallback
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

    fun getBreedImage(dogBreed: String, callback: RepositoryCallback) {
        dogAPIService.getDogBreedImage(dogBreed).enqueue(object : Callback<BreedImage> {
            override fun onResponse(call: Call<BreedImage>, response: Response<BreedImage>) {
                callback.onSuccess(response.body())
            }

            override fun onFailure(call: Call<BreedImage>, t: Throwable) {
                callback.onFailure(ErrorResponse(t))
            }

        })
    }
}