package br.android.iddog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import br.android.iddog.ui.main.MainActivity
import dagger.android.support.AndroidSupportInjection

open class BaseFragment: Fragment(){
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    fun goToHome() {
        val intent = MainActivity.newIntent(view!!.context)
        startActivity(intent)
        activity!!.finish()
    }
}