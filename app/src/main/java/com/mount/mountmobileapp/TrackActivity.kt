package com.mount.mountmobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_track.*

class TrackActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        buttonStart.setOnClickListener {
            val intent = Intent(this@TrackActivity, MainActivity::class.java)
            intent.putExtra("currentlyTracking",true)
            startActivity(intent)
        }
    }
}