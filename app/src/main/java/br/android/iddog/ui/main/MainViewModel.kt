package br.android.iddog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.android.iddog.data.DogsRepository
import br.android.iddog.data.error.ErrorResponse
import br.android.iddog.data.remote.Breed
import br.android.iddog.data.remote.Breeds
import br.android.iddog.data.remote.MessageBreeds
import br.android.iddog.data.remote.SubBreed
import br.android.iddog.data.source.RepositoryCallback
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(var dogsRepository: DogsRepository) : ViewModel() {
//    fun getAllBreeds(mainFragment: MainFragment): LiveData<List<Breeds>> {
////        return dogsRepository.
//    }

    fun getBreed() {
//        dogsRepository.getBreed().object : CallBack<Breed> {
//            override fun onSuccess(result: Any?) {
//                if(result != null){
//                    Timber.d("---"+result)
//                }
//            }
//
//            override fun onFailure(error: ErrorResponse?) {
//                error?.let {
//                    Timber.d(it.errorMessage)
//                }
//            }
//
//        })
    }
}