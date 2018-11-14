package com.uos.iwic.iwic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.EventLog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Events : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_events, container, false)
    }
}
