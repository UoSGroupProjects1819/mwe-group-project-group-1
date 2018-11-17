package com.uos.iwic.iwic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_events.*
import java.util.ArrayList

//class Events : Fragment() {

// override fun onCreateView(
// inflater: LayoutInflater, container: ViewGroup?,
// savedInstanceState: Bundle?
//
// ): View? {
//
//
// //List of events to be passed to the adapter
// var events = ArrayList<Event>()
//
// //Late init tells the system that this variable is to be assigned to during runtime
// lateinit var adapter:Adapter
//
// //Passing the adapter the list of tracks
// adapter = Adapter(events, this)
//
// eventsRecycler.adapter = adapter
//
//
// }
//
//
// //Authentication token may be required
// //https://www.eventbrite.com/oauth/authorize?response_type=token&client_id=YOUR_CLIENT_KEY
//
// fun ShowEvents()
// {
//
// }
//
// }
//
// *\\