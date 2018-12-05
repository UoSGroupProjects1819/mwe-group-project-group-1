package com.uos.iwic.iwic

import android.content.ContentValues.TAG
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.annotation.NonNull
import android.util.Log
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot




class GalleryActivity : Fragment() {

    override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment

        val db = FirebaseFirestore.getInstance()
        db.collection("Gallery")
                .get()
                .addOnSuccessListener { result ->
                    for (urls in result) {
                        Log.d(TAG, urls.id + " => " + urls.data)
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "Error getting documents: ", exception)
                }


        return inflater.inflate (R.layout.activity_gallery, container, false)
        }
    }
