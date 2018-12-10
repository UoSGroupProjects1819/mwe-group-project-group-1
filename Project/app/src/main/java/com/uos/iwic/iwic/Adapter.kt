package com.uos.iwic.iwic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class EventAdapter(val Events: ArrayList<Event>, val context: Context) : RecyclerView.Adapter<EventAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder{
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.eventsholder, parent, false))
    }


    override fun getItemCount() = Events.size


    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) {
        holder.bindEvents(Events[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val eventName: TextView = itemView.findViewById(R.id.EventName)
        private val eventDescription: TextView = itemView.findViewById(R.id.EventLocation)
        private val eventTime: TextView = itemView.findViewById(R.id.EventTime)

        //Binds the data from each track to fields within the class
        fun bindEvents(event : Event) {


            //2019-01-23T11:30:00Z
            eventName.text = event.name.text

            // setup a date formatter that uses the pattern that eventbrite gives back dates in
            val df = SimpleDateFormat("yyyy-M-d'T'H:m:s")
            // parse the date from the eventbrite event.
            val date = df.parse(event.start.local)
            // use a new date formatter to print the stored date in a format we want.
            eventTime.text = SimpleDateFormat("E d MMM - H:m").format(date)
            eventDescription.text = event.description.text
        }




    }



}