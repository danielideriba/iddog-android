package br.android.iddog.di.module

import br.android.iddog.ui.login.LoginFragment
import br.android.iddog.ui.login.SignupFragment
import br.android.iddog.ui.main.MainFragment
import br.android.iddog.ui.main.PlaceholderFragment
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
    abstract fun contributePlaceholderFragment(): PlaceholderFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeSignupFragment(): SignupFragment
}