package com.fogoapagou.challenge193

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRegister.setOnClickListener(this)
        btnLogin.setOnClickListener(this)
        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                btnLogin.isEnabled = txtCpf.text.isNotEmpty() && txtPassword.text.isNotEmpty()
                btnLogin.alpha = if(btnLogin.isEnabled) 1f else .4f
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

        txtCpf.addTextChangedListener(watcher)
        txtPassword.addTextChangedListener(watcher)

        watcher.afterTextChanged(null)
    }


    override fun onClick(btn: View?) {
        when (btn?.id) {
            btnRegister.id -> {
                val intentRegister = Intent(this, RegisterActivity::class.java)
                startActivity(intentRegister)
            }
            btnLogin.id -> {
                val intentLogin = Intent(this, ProfileActivity::class.java)
                startActivity(intentLogin)
            }
        }
    }


}
