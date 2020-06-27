package com.developersbreach.viewanimations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardView = findViewById<MaterialCardView>(R.id.card_view_animate)
        cardView.setOnClickListener {
            startCircularFillingEffect(cardView, applicationContext)
        }
    }
}