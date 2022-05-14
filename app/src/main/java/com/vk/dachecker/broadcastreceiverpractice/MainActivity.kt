package com.vk.dachecker.broadcastreceiverpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var pBar: ProgressBar

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p1?.action == "loaded") {
                val progress = p1.getIntExtra("percent", 0)
                pBar.progress = progress
            }
        }

    }
    private var clickCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pBar = findViewById(R.id.progressBar)
        findViewById<Button>(R.id.button).setOnClickListener {
            clickCounter++
            val intent = Intent(Receiver.ACTION_CLICKED)
            intent.putExtra(CLICK_COUNTER, clickCounter)
            sendBroadcast(intent)
        }


        val intentFilter = IntentFilter().apply {
//            addAction(Intent.ACTION_BATTERY_LOW)
//            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//            addAction(Receiver.ACTION_CLICKED)
            addAction("loaded")
        }
        registerReceiver(receiver, intentFilter)

        /**
         * стартуем сервис, иначе сервис не запустится. Не забудь сервис зарегистрировать в манифесте
         */
        Intent(this, MyService::class.java).apply {
            startService(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)

    }

    companion object {
        const val CLICK_COUNTER = "click_counter"
    }
}