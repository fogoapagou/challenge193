package com.fogoapagou.challenge193

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(btn: View?) {
        when (btn?.id) {
            btnSimulation.id -> {
                startActivity(Intent(this, CallActivity::class.java))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnSimulation.setOnClickListener(this)
    }
}
