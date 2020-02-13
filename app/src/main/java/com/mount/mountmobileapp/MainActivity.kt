package com.mount.mountmobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalibrate.setOnClickListener {
            startActivity(Intent(this, CalibrateActivity::class.java))
        }


        buttonTrack.setOnClickListener {

            var isCalibrated = intent.getBooleanExtra("isCalibrated",false)

            if (isCalibrated) {
                startActivity(Intent(this, TrackActivity::class.java))
            } else {
                Toast.makeText(this, "Please Calibrate First", Toast.LENGTH_SHORT).show()
            }
        }


        buttonAbort.setOnClickListener {

            var currentlyTracking = intent.getBooleanExtra("currentlyTracking",false)

            if (currentlyTracking) {
                Toast.makeText(this, "Tracking Aborted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Not Currently Tracking", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
