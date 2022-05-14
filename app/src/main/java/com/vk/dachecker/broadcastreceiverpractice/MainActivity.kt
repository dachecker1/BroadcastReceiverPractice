package com.vk.dachecker.broadcastreceiverpractice

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val receiver = Receiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilterAirPlane = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val intentFilterBatteryLow = IntentFilter(Intent.ACTION_BATTERY_LOW)
        registerReceiver(receiver, intentFilterAirPlane)
        registerReceiver(receiver, intentFilterBatteryLow)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)

    }
}