package com.fogoapagou.challenge193

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnCancel.setOnClickListener(this)
        btnEnter.setOnClickListener(this)
    }

    override fun onClick(btn: View?) {
        when (btn?.id) {
            btnCancel.id -> {
                onBackPressed()
            }
            btnEnter.id -> {
                validateLogin()
            }

        }
    }

    private fun validateLogin() {
        var success = true //TODO: CHECK LOGIN DATA ON DATA BASE

        onLoginCallback(success)
    }

    private fun onLoginCallback(success: Boolean) {
        if (success) {
            var intentProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentProfile)
        } else {
            //TODO: SHOW ERROR
        }
    }
}
