package br.android.iddog.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModelProvider
import br.android.iddog.R
import br.android.iddog.di.module.User
import br.android.iddog.ui.BaseFragment
import br.android.iddog.ui.main.MainActivity
import br.android.iddog.ui.main.MainViewModel
import br.android.iddog.utils.AlertDialogs
import br.android.iddog.utils.EmailValidator
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

    private lateinit var mEmailValidator: EmailValidator

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
        this.addWatchers()
        this.viewActions()
    }

    private fun addWatchers(){
        mEmailValidator = EmailValidator()
        inputEmail.addTextChangedListener(mEmailValidator)
    }

    private fun resetFields() {
        inputName.setText("")
        inputEmail.setText("")
        inputPassword.setText("")
    }

    private fun viewActions(){
        btCreate.setOnClickListener {
            if (mEmailValidator.isValid) {
                mAuth.createUserWithEmailAndPassword(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        saveInRealTimeDatabase()
                    } else {
                        this.resetFields()
                        AlertDialogs.showDialog(
                            view!!.context,
                            getString(R.string.alert_error_create_user)
                        )
                    }
                }
            } else {
                this.resetFields()
                AlertDialogs.showDialog(
                    view!!.context,
                    getString(R.string.alert_error_email)
                )
            }
        }
    }

    private fun saveInRealTimeDatabase() {
        val user = User(FirebaseAuth.getInstance().currentUser!!.uid, inputName.text.toString(), inputEmail.text.toString())
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
                    ).setPositiveButton(R.string.ok) { _, _ ->
                        val intent = MainActivity.newIntent(view!!.context)
                        startActivity(intent)
                        activity!!.finish()
                    }.create().show()

                } else {
                    AlertDialogs.showDialogRedirect(
                        view!!.context,
                        getString(R.string.atenttion),
                        getString(R.string.alert_error_create_user)
                    ).setPositiveButton(R.string.ok) { _, _ ->
                        false
                    }.create().show()
                }
            }
    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}
