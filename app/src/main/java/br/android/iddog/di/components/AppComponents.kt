package br.android.iddog.di.components

import android.app.Application
import br.android.iddog.MyApp
import br.android.iddog.di.module.ActivityModule
import br.android.iddog.di.module.FragmentModule
import br.android.iddog.di.module.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NetModule::class
//        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MyApp)
}