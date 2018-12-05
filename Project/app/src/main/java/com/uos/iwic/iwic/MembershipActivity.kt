package com.uos.iwic.iwic

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.system.Os.bind
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.*

class MembershipActivity : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.activity_membership, container, false)
        val button: Button = view.findViewById(R.id.buttonpayment)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://onlineshop.ucs.ac.uk/product-catalogue/university-services/ipswich-waterfront-innovation-centre")
            startActivity(intent)
        }
        return view
    }
}
