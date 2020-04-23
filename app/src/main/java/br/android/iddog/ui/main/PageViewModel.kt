package br.android.iddog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import br.android.iddog.data.DogsRepository
import javax.inject.Inject

class PageViewModel
@Inject constructor(var dogsRepository: DogsRepository) : ViewModel(){
    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "$it"
    }


    fun setIndex(index: Int) {
        _index.value = index
    }

}