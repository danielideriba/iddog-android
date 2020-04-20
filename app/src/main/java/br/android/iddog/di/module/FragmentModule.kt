package br.android.iddog.di.module

import br.android.iddog.ui.login.LoginFragment
import br.android.iddog.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by danielideriba on 08,February,2019
 * TODO: All fragment with injection must be declared here
 * Ex:. @ContributesAndroidInjector
 *      abstract fun contribute[NAME_FRAGMENT](): [NAME_FRAGMENT]
 */

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}