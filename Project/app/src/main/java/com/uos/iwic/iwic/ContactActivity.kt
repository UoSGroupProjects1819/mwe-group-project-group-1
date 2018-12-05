package com.uos.iwic.iwic

import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.firebase.firestore.GeoPoint
import com.google.android.gms.maps.MapView
import com.uos.iwic.iwic.R.id.container


class ContactActivity : Fragment() {

    //private val mapView: MapView? = null
   // private val mapController: MapController? = null
   // private val geoPoint: GeoPoint = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_contact, container, false)
    }
}
       // mapView = (MapView) findViewById (R.id.mapview)

        //sets the zoom to see the location closer
       // mapView.getController().setZoom(12)

        //this will let you to zoom in or out using the controllers
      //  mapView.setBuiltInZoomControls(true)

       // List<overlay> mapOverlays = mapView . getOverlays ()
       // Drawable drawable = this.resources.getDrawable(R.drawable.marker)

        //MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(drawable, this)

      //  GeoPoint point = new GeoPoint(46066940, 23570000)
        //this will show you the map at the exact location you want (if you not set this you will see the map somewhere in America)
      //  mapView.getController().setCenter(point)

      //  GeoPoint point2 = new GeoPoint(35410000, 139460000)
       // OverlayItem overlayitem2 = new OverlayItem(point2, "Title for dialog", "Japan")

      //  itemizedoverlay.addOverlay(overlayitem)
       // itemizedoverlay.addOverlay(overlayitem2)
      //  mapOverlays.add(itemizedoverlay)

  //  @Override
    //protected boolean isRouteDisplayed()
       // return false;
//
      //

