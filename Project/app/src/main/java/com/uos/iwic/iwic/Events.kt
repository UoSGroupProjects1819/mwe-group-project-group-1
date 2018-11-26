package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_events.*
import java.util.ArrayList

class Events : Fragment() {

    //List of events to be passed to the adapter
    var events = ArrayList<Event>()

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



        return rootView
    }


}

