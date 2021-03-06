package com.uos.iwic.iwic

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.nav_header_navigation.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.gallery_image.*

class Navigation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var webFragment: Fragment? = null
    var inBooking: Boolean = false

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if ( inBooking && webFragment != null ) {

            val webView = webFragment as WebViewActivity

            if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                webView.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        var navigationView = findViewById<NavigationView>(R.id.nav_view)
        var header = navigationView.getHeaderView(0)
        var header_email = header.findViewById<TextView>(R.id.nav_header_email)

        //navigation_header_image
        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            //nav_header_username.text = name
            header_email.text = email

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }

        if ( user == null )
        {
            var loginitem = navigationView.menu.findItem(R.id.SignOutMenuButton)
            loginitem.title = "Log in"


            //var bookNow = navigationView.menu.findItem(R.id.BookNowMenuButton)
           //bookNow.setVisible(false)

            var header_email = header.findViewById<TextView>(R.id.nav_header_email)
            header_email.setAlpha(0.0f)

            //var header_image= header.findViewById<TextView>(R.id.nav_header_username)

           // var header_background = header.findViewById<NavigationView>(R.id.HeaderAndroid)
           //header_background.setAlpha(0.0f)
          // var header_desc = header.findViewById<TextView>(R.id.nav_header_image)
           // header_desc.setAlpha(0.0f)

        }



        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_holder, IntroductionFragment())
        ft.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        inBooking = false
        webFragment = null
        var fragment:Fragment? = null
        when (item.itemId) {
            R.id.IntroductionMenuButton -> {
                fragment = IntroductionFragment()
            }
            R.id.EventsMenuButton -> {
                fragment = Events ()
            }
            R.id.NewsMenuButton -> {
            }
            R.id.FindUsMenuButton -> {
                fragment = ContactActivity ()
            }
            R.id.MembershipsMenuButton -> {
                fragment = MembershipActivity()
            }
            R.id.BookNowMenuButton -> {
                fragment = WebViewActivity()
                webFragment = fragment
                inBooking = true
            }
            R.id.GalleryMenuButton -> {
                fragment = GalleryActivity()
            }
            R.id.AboutUsMenuButton -> {

            }
            R.id.SignOutMenuButton -> {
                if ( FirebaseAuth.getInstance().currentUser == null )
                {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    item.title = "Sign out"
                } else {
                    FirebaseAuth.getInstance().signOut()
                    item.title = "Log In"
                    val intent = Intent(this, Navigation::class.java)
                    startActivity(intent)
                }
            }
        }
        if ( fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment_holder, fragment)
            ft.commit()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
