package br.android.iddog.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import br.android.iddog.BaseActivity
import br.android.iddog.R
import br.android.iddog.ui.login.LoginActivity
import br.android.iddog.utils.SessionUtils
import br.android.iddog.utils.USER_COLUMN_IDTOKEN
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        this.configView()
    }

    private fun configView(){
        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            SessionUtils.resetSession(this)
            val intent = LoginActivity.newIntent(this)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() { }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }
}