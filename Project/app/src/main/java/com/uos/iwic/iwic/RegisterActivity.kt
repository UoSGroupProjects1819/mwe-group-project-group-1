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
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun onRegisterClicked(view: View){
        val email = emailText.text.toString()
        val password = passwordText.text.toString()
        val passwordConfirm = passwordConfirmText.text.toString()

        if (password != passwordConfirm) {
            Toast.makeText(baseContext, "Passwords must match",
                    Toast.LENGTH_SHORT).show()

            return
        }

        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        activitySpinner.visibility = View.VISIBLE

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("AUTH", "createUserWithEmail:success")
                        val user = firebaseAuth.currentUser

                        user?.sendEmailVerification()
                                ?.addOnCompleteListener { task ->
                                    if(task.isSuccessful) {
                                        Log.d("AUTH", "Email sent")
                                    }
                                }

                        val intent = Intent(this,Navigation::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("AUTH", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }
                }


    }
}
