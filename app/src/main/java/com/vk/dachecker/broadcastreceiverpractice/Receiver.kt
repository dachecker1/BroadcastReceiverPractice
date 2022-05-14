package com.vk.dachecker.broadcastreceiverpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                Toast.makeText(p0, "Mode Airplane have been changed", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(p0, "Battery low", Toast.LENGTH_LONG).show()
            }
        }
    }
}