package com.example.basicmapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main)
        val map1 = findViewById<MapView>(R.id.map1)
        map1.controller.setZoom(16.0)
        map1.controller.setCenter(GeoPoint(51.05, -0.72))

        val btn1 = findViewById<Button>(R.id.btn1)
        val etLat = findViewById<EditText>(R.id.etLat)
        val etLon = findViewById<EditText>(R.id.etLon)
        btn1.setOnClickListener {
            val lat = etLat.text.toString().toDouble()
            val lon = etLon.text.toString().toDouble()
            map1.controller.setCenter(GeoPoint(lat, lon))
        }
    }

}
