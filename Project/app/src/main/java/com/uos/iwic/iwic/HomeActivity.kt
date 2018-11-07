package com.uos.iwic.iwic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.View

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun EventsButtonClicked(view: View) {
        intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    fun NewsButtonClicked(view: View) {
        intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    fun UpdatesButtonClicked(view: View) {
        intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    fun AccountButtonClicked(view: View) {
        intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    fun MapsButtonClicked(view: View) {
        intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
    }

    fun LogoButtonClicked(view: View) {
        intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
