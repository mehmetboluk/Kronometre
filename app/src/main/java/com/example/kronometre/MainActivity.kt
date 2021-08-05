package com.example.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stopTime:Long = 0
        btnStart.setOnClickListener {
            kronometre.base = SystemClock.elapsedRealtime() + stopTime
            kronometre.start()
            btnStart.visibility = View.GONE
            btnStop.visibility = View.VISIBLE
            ivStart.setImageDrawable(getDrawable(R.drawable.pause))
        }
        btnStop.setOnClickListener {
            stopTime = kronometre.base-SystemClock.elapsedRealtime()
            kronometre.stop()
            btnStop.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            ivStart.setImageDrawable(getDrawable(R.drawable.start))
        }
        btnReset.setOnClickListener {
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.stop()
            stopTime = 0
            btnStop.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            ivStart.setImageDrawable(getDrawable(R.drawable.start))
        }
    }
}