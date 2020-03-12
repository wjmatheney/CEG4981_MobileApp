package com.mount.mountmobileapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_track.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class TrackActivity : AppCompatActivity()  {

    private var names = mutableListOf<String>()
    private var RA = mutableListOf<Float>()
    private var dec = mutableListOf<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track)

        // Load database from file
        val inStream = resources.openRawResource(R.raw.hygdata_v3_short)
        val read = BufferedReader(InputStreamReader(inStream))
        val lines = read.readLines().toTypedArray().toList()

        lines.forEach {
            val fields: List<String> = it.split(',')

            names.add(fields[0])
            RA.add(fields[1].toFloat())
            dec.add(fields[2].toFloat())
        }

        // Populate list view
        val listview = findViewById<ListView>(R.id.targetListView)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, names)
        listview.adapter = arrayAdapter
        //val starDB = StarDatabase(R.raw.hygdata_v3_short)

        buttonStart.setOnClickListener {
            val intent = Intent(this@TrackActivity, MainActivity::class.java)
            intent.putExtra("currentlyTracking",true)
            startActivity(intent)
        }
    }

    companion object {
        var context: Context? = null
            internal set
    }
}