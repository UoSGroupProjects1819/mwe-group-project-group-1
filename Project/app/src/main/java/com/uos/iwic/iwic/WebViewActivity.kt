package com.uos.iwic.iwic

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import kotlinx.android.synthetic.main.abc_select_dialog_material.*
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : Fragment(){

    private val URL = "https://iwic.skedda.com"
    private var isAlreadyCreated = false
    private lateinit var loaderImage:ImageView
    private lateinit var webView:WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_web_view, container, false)

        loaderImage = view.findViewById(R.id.loaderImage)
        webView = view.findViewById(R.id.webView)

        startLoaderAnimate()

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                endLoaderAnimate()
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                endLoaderAnimate()
                showErrorDialog("Error",
                        "No internet connection. Please check your connection.",
                        view!!.context)
            }
        }

        webView.loadUrl(URL)

        return view
    }

    override fun onResume() {
        super.onResume()

        if (isAlreadyCreated && !isNetworkAvailable()) {
            val context = activity!!.applicationContext
            isAlreadyCreated = false
            showErrorDialog("Error", "No internet connection. Please check your connection.",
                    context)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectionManager =
                activity!!.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

            /*override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack()
                    return true
                }
                return super.onKeyDown(keyCode, event)
            }*/

    private fun showErrorDialog(title: String, message: String, context: Context) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setNegativeButton("Cancel") { _, _ ->
            //this@WebViewActivity.finish()
        }
        dialog.setNeutralButton("Settings") { _, _ ->
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
        dialog.setPositiveButton("Retry") { _, _ ->
            //this@WebViewActivity.recreate()
        }
        dialog.create().show()
    }

    private fun endLoaderAnimate() {
        loaderImage.clearAnimation()
        loaderImage.visibility = View.GONE
    }

    private fun startLoaderAnimate() {
        val objectAnimator = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val startHeight = 170
                val newHeight = (startHeight + (startHeight + 40) * interpolatedTime).toInt()
                loaderImage.layoutParams.height = newHeight
                loaderImage.requestLayout()
            }

            override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
                super.initialize(width, height, parentWidth, parentHeight)
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        objectAnimator.repeatCount = -1
        objectAnimator.repeatMode = ValueAnimator.REVERSE
        objectAnimator.duration = 1000
        loaderImage.startAnimation(objectAnimator)
    }


}

