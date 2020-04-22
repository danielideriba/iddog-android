package br.android.iddog.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import br.android.iddog.R
import br.android.iddog.di.module.User
import br.android.iddog.ui.BaseFragment
import br.android.iddog.ui.main.MainViewModel
import br.android.iddog.utils.AlertDialogs
import br.android.iddog.utils.SIGNUP_EMAIL
import br.android.iddog.utils.SessionUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber
import javax.inject.Inject

class LoginFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    private lateinit var mAuth: FirebaseAuth
    private val newUserRequestCode = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater!!.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        this.configureViewModel()
        this.checkIfAlreadyLogged()
        this.viewActions()
    }

    private fun checkIfAlreadyLogged() {
        if (mAuth.currentUser != null) {
            val user = User(mAuth.currentUser!!.uid, mAuth.currentUser!!.displayName, mAuth.currentUser!!.email)
            SessionUtils.createSession(view!!.context, user!!)

            goToHome()
        }
    }

    private fun viewActions(){
        btLogin.setOnClickListener {
            mAuth.signInWithEmailAndPassword(
                inputLoginEmail.text.toString(),
                inputLoginPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    goToHome()
                } else {
                    AlertDialogs.showDialog(view!!.context, getString(R.string.alert_login_error_text))
                }
            }
        }

        btSignup.setOnClickListener {
            val intent = SignupActivity.newIntent(view!!.context)
            startActivityForResult(intent, newUserRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newUserRequestCode && resultCode == Activity.RESULT_OK) {
            inputLoginEmail.setText(data?.getStringExtra(SIGNUP_EMAIL))
        }
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}
