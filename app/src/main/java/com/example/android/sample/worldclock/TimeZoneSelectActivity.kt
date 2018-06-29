package com.example.android.sample.worldclock

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class TimeZoneSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_zone_select)

        setResult(Activity.RESULT_CANCELED)

        val list = findViewById<ListView>(R.id.clockList)

        val adapter = TimeZoneAdapter(this)

        list.adapter = adapter

        list.setOnItemClickListener { _, _, position, _ ->
            val timeZone = adapter.getItem(position)

            val result = Intent()

            result.putExtra("timeZone", timeZone)

            setResult(Activity.RESULT_OK, result)

            finish()
        }
    }
}
