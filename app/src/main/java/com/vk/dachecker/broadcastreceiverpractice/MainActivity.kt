package com.vk.dachecker.broadcastreceiverpractice

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val receiver = Receiver()
    private var clickCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            clickCounter++
            val intent = Intent(Receiver.ACTION_CLICKED)
            intent.putExtra(CLICK_COUNTER, clickCounter)
            sendBroadcast(intent)
        }


        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Receiver.ACTION_CLICKED)
        }
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)

    }

    companion object {
        const val CLICK_COUNTER = "click_counter"
    }
}