package br.android.iddog.ui.login

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import br.android.iddog.R
import br.android.iddog.di.module.User
import br.android.iddog.ui.BaseFragment
import br.android.iddog.ui.main.MainActivity
import br.android.iddog.ui.main.MainViewModel
import br.android.iddog.utils.AlertDialogs
import br.android.iddog.utils.SIGNUP_EMAIL
import br.android.iddog.utils.SessionUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_signup.*
import timber.log.Timber
import javax.inject.Inject

class SignupFragment: BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    private lateinit var mAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        this.configureViewModel()
        this.viewActions()
    }

    private fun viewActions(){
        btCreate.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(
                inputEmail.text.toString(),
                inputPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    saveInRealTimeDatabase()
                } else {
                    Timber.d(it.exception?.message)
                }
            }
        }
    }

    private fun saveInRealTimeDatabase() {
        val user = User("", inputName.text.toString(), inputEmail.text.toString())
        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    SessionUtils.createSession(view!!.context, user)
                    AlertDialogs.showDialogRedirect(
                        view!!.context,
                        getString(R.string.atenttion),
                        getString(R.string.alert_registred_successful)
                    ).setPositiveButton(R.string.ok) { dialog, which ->
                        val intent = MainActivity.newIntent(view!!.context)
                        startActivity(intent)
                        activity!!.finish()
                    }.create().show()

                } else {
                    AlertDialogs.showDialogRedirect(
                        view!!.context,
                        getString(R.string.atenttion),
                        getString(R.string.alert_error_create_user)
                    ).setPositiveButton(R.string.ok) { dialog, which ->
                        false
                    }.create().show()
                }
            }
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}
