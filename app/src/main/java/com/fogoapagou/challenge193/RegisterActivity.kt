package com.fogoapagou.challenge193

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegister.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(btn: View?) {
        when (btn?.id) {
            btnRegister.id -> {
                onClickRegister()
            }

            btnCancel.id -> {
                onBackPressed()
            }
        }

    }

    private fun onClickRegister() {
        //TODO: VALIDATE FIELDS
        //TODO: SEND DATA TO SERVER
        var intentProfile = Intent(this, ProfileActivity::class.java)//OPEN PROFILE ACTIVITY
        startActivity(intentProfile)
    }

}
