package br.android.iddog.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.android.iddog.data.DogsRepository
import br.android.iddog.data.error.ErrorResponse
import br.android.iddog.data.remote.BreedImage
import br.android.iddog.data.source.RepositoryCallback
import javax.inject.Inject

class MainViewModel @Inject constructor(var dogsRepository: DogsRepository) : ViewModel() {
    var dataModel: MutableLiveData<BreedImage> = MutableLiveData<BreedImage>()

    fun getOneBreedImage(dogBreed: String){
        dogsRepository.getBreedImage(dogBreed, object : RepositoryCallback {
            override fun onSuccess(result: Any?) {
                val results = result as BreedImage
                if(results.status == "success") {
                    dataModel.postValue(results)
                }
            }

            override fun onFailure(error: ErrorResponse?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }
}