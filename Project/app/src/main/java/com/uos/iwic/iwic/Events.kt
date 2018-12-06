package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beust.klaxon.Klaxon
import khttp.async
import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.notification_template_lines_media.*
import java.util.ArrayList

class Events : Fragment() {

    //List of events to be passed to the adapter
    var events = ArrayList<Event>()

    private val organiserId = "11880541692"
    private val authKey = "3GOGLWYHLB4XKTBZ7ZNH"

    //Late init tells the system that this variable is to be assigned to during runtime
    lateinit var adapter:EventAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.activity_events, container, false)

        adapter = EventAdapter(events, container!!.context)

        val events_recycler = rootView.findViewById(R.id.eventsRecycler) as RecyclerView
        events_recycler.layoutManager = LinearLayoutManager(activity)
        events_recycler.adapter = adapter


        async.get("https://www.eventbriteapi.com/v3/events/search/?organizer.id=$organiserId", headers=mapOf("Authorization" to "Bearer $authKey"), onResponse = {

            val returned = Klaxon()
                    .parse<EventData>(this.text)

            var listOfEvents = returned!!.events

            for (event in listOfEvents){
                events.add(event)
            }

            adapter.notifyDataSetChanged()

        })
        adapter.notifyDataSetChanged()

        return rootView





    }




}

