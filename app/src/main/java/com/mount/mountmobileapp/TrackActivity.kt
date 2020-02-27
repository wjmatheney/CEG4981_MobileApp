package com.mount.mountmobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_track.*
import java.io.InputStream

class TrackActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        //code to load database here
        val starListInputStream = resources.openRawResource(R.raw.hygdata_v3)

        buttonStart.setOnClickListener {
            val intent = Intent(this@TrackActivity, MainActivity::class.java)
            intent.putExtra("currentlyTracking",true)
            startActivity(intent)
        }
    }
}