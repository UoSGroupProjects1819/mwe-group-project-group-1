package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso


class GalleryActivity : Fragment() {

    val imageUrls = arrayListOf<String>()
    lateinit var adapter: GalleryAdapter

    override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate (R.layout.activity_gallery, container, false)

        adapter = GalleryAdapter(imageUrls, activity!!.applicationContext)

        val recycler = view.findViewById<RecyclerView>(R.id.gallery_recycler_view)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity!!.applicationContext)

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

                        adapter.notifyDataSetChanged()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("Gallery", "Error getting documents: ", exception)
                }

        return view
        }
    }
