package br.android.iddog

import android.app.Activity
import android.app.Application
import br.android.iddog.di.components.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class MyApp: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
        this.debugConfigs()
    }

    private fun debugConfigs() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Stetho.initializeWithDefaults(this)
    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

}