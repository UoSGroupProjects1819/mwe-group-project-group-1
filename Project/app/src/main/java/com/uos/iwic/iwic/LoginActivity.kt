package com.uos.iwic.iwic

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginRegisterClicked(view:View) {
        val intent=Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

    fun loginOnClick(view:View){
        val email = EmailText.text.toString()
        val password = passwordText.text.toString()

        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        activitySpinner.visibility = View.VISIBLE

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    activitySpinner.visibility = View.INVISIBLE

                    if (it.isSuccessful)
                    {
                        val intent=Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Log.w("AUTH", "signInWithEmail:failure", it.exception)
                        Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
                }

    }
}
