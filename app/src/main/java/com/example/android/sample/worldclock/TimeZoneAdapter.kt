package com.example.android.sample.worldclock

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextClock
import android.widget.TextView
import java.util.*

class TimeZoneAdapter(private val context: Context,
                      private val timeZones: Array<String> =
                           TimeZone.getAvailableIDs() )
    :BaseAdapter() {
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: createView(parent)

        val timeZoneId = getItem(position)

        val timeZone = TimeZone.getTimeZone(timeZoneId)

        val viewHolder = view.tag as viewHolder

        @SuppressLint("SetTextI18n")
        viewHolder.name.text = "${timeZone.displayName}(${timeZone.id})"

        viewHolder.clock.timeZone = timeZone.id

        return view
    }

    override fun getItem(position: Int) = timeZones[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = timeZones.size

    private class viewHolder(view: View) {
        val name = view.findViewById<TextView>(R.id.textZone)
        val clock = view.findViewById<TextClock>(R.id.clock)
    }

    private fun createView(parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.list_time_zone_row, parent, false)
        view.tag = viewHolder(view)
        return  view
    }
}