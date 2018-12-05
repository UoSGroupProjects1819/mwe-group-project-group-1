package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
<<<<<<< HEAD
import com.squareup.picasso.Picasso
import com.uos.iwic.iwic.R.id.imagegallery


class GalleryActivity : Fragment() {


    val imageUrls = arrayListOf<String>()
=======

class GalleryActivity : Fragment() {

    val imageUrls = arrayListOf<String>()
    lateinit var adapter: GalleryAdapter
>>>>>>> ecf693dfc069ac6a98d9e10eae5bc4635a754256

    override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
        ): View? {
        // Inflate the layout for this fragment
<<<<<<< HEAD

=======
        val view = inflater.inflate (R.layout.activity_gallery, container, false)

        adapter = GalleryAdapter(imageUrls, activity!!.applicationContext)

        val recycler = view.findViewById<RecyclerView>(R.id.gallery_recycler_view)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity!!.applicationContext)

>>>>>>> ecf693dfc069ac6a98d9e10eae5bc4635a754256
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
<<<<<<< HEAD
=======
                        adapter.notifyDataSetChanged()
>>>>>>> ecf693dfc069ac6a98d9e10eae5bc4635a754256
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("Gallery", "Error getting documents: ", exception)
                }
<<<<<<< HEAD
        return inflater.inflate (R.layout.activity_gallery, container, false)
=======
        return view
>>>>>>> ecf693dfc069ac6a98d9e10eae5bc4635a754256
        }
    }




<<<<<<< HEAD
=======


>>>>>>> ecf693dfc069ac6a98d9e10eae5bc4635a754256
