package com.uos.iwic.iwic

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.*
import kotlin.concurrent.schedule

class SplashScreenActivity : Fragment () {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_splash_screen, container, false)
        Timer().schedule(3000) {
            val intent = Intent(view.context, WebViewActivity::class.java)
            startActivity(intent)
        }
        return view
    }

}