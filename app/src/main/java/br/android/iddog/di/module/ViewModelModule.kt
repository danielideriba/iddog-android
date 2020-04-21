package br.android.iddog.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.android.iddog.di.key.ViewModelKey
import br.android.iddog.ui.main.MainViewModel
import br.android.iddog.utils.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(repoViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory
}