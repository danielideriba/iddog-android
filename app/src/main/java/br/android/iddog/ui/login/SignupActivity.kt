package br.android.iddog.ui.login

import android.content.Intent
import android.os.Bundle
import br.android.iddog.BaseActivity
import br.android.iddog.R
import br.android.iddog.ui.main.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class SignupActivity: BaseActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        this.createUser("danielideriba@gmail.com", "123mudar")
    }

    fun createUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener{ task ->
            if(task.isSuccessful){
//                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
//                Toast.makeText(this, "Registration Failed", Toast.LENGTH_LONG).show()
            }
        })
    }
}