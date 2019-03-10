package com.fogoapagou.challenge193

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_call.*


class CallActivity : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {
    override fun onClick(btn: View?) {
        when (btn?.id) {
            btnAccept.id -> {
                val gmmIntentUri = Uri.parse("google.navigation:q=Av Paulista, 1439")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
            btnReject.id -> {
                onBackPressed()
            }
        }
    }

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        btnAccept.setOnClickListener(this)
        btnReject.setOnClickListener(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val pos = LatLng(-23.5626136,-46.6553373)
        mMap.addMarker(MarkerOptions().position(pos).title("Av Paulista, 111"))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                pos,
                18.0f
            )
        )

    }
}
