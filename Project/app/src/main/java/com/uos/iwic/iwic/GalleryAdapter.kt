package com.uos.iwic.iwic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.uos.iwic.iwic.R.id.image
import com.uos.iwic.iwic.R.id.imagegallery

class GalleryAdapter (private val data:List<String>, private val context: Context) : RecyclerView.Adapter<GalleryAdapter.GalleryHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryAdapter.GalleryHolder {
        val galleryView = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false)
        return GalleryHolder(galleryView)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: GalleryAdapter.GalleryHolder, position: Int) {
        holder.bindImage(data[position])
    }
    inner class GalleryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById <ImageView> (R.id.imagegallery)

        fun bindImage (imageUrls: String?) {
            if (imageUrls == null)
                return
            if (imageUrls != null)
                Picasso.get().load(imageUrls).into(image)

        }
    }
}