package com.mount.mountmobileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calibrate.*

class CalibrateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calibrate)

        buttonNextCal.setOnClickListener {
            val intent = Intent(this@CalibrateActivity, MainActivity::class.java)
            intent.putExtra("isCalibrated",true)
            startActivity(intent)
        }
    }

}