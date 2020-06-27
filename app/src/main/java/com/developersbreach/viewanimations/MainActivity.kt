package com.developersbreach.viewanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fillFadeExitCardView = findViewById<MaterialCardView>(R.id.card_filling_and_fade)
        val fillCardView = findViewById<MaterialCardView>(R.id.card_filling)
        val fadeExitCardView = findViewById<MaterialCardView>(R.id.card_fade_exit)

        fillFadeExitCardView.setOnClickListener {
            startCircularFillingEffect(fillFadeExitCardView, applicationContext)
            fadeOutViewAnimation(fillFadeExitCardView, applicationContext)
        }

        fillCardView.setOnClickListener {
            startCircularFillingEffect(fillCardView, applicationContext)
        }

        fadeExitCardView.setOnClickListener {
            fadeOutViewAnimation(fadeExitCardView, applicationContext)
        }
    }
}