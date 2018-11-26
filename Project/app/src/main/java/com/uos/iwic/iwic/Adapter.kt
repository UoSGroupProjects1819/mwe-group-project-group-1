package com.uos.iwic.iwic

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


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
        private val eventLocation: TextView = itemView.findViewById(R.id.EventLocation)
        private val eventTime: TextView = itemView.findViewById(R.id.EventTime)

        //Binds the data from each track to fields within the class
        fun bindEvents(event : Event) {

            eventName.text = event.event_name_html.toString()
            eventTime.text = event.event_start_utc.toString()
            eventLocation.text = event.event_venue_id.toString()
        }




    }



}