package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import com.uos.iwic.iwic.R.id.imagegallery


class GalleryActivity : Fragment() {


    val imageUrls = arrayListOf<String>()

    override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment

        val db = FirebaseFirestore.getInstance()
        db.collection("Gallery")
                .get()
                .addOnSuccessListener { result ->
                    val urls = result.documents[0]
                    val test = urls.data
                    if ( test != null ) {
                        val list:ArrayList<String> = test["urls"] as ArrayList<String>
                        for ( url in list) {
                            imageUrls.add(url)
                        }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("Gallery", "Error getting documents: ", exception)
                }
        return inflater.inflate (R.layout.activity_gallery, container, false)
        }
    }




