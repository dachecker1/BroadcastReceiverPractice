package com.vk.dachecker.broadcastreceiverpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            ACTION_CLICKED -> {
                val count = p1.getIntExtra(MainActivity.CLICK_COUNTER, 0)
                Toast.makeText(p0, "Click Counter: $count", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val isModeOn = p1.getBooleanExtra("state", false)
                Toast.makeText(p0, "Airplane mode on: $isModeOn", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(p0, "Battery low", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "clicked"
    }
}