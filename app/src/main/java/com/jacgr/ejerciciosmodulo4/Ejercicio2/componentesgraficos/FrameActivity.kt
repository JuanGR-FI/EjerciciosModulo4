package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jacgr.ejerciciosmodulo4.R

class FrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame)

        val btnLinearLayout = findViewById<Button>(R.id.btnLinearLayout)

        btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearActivity::class.java)
            startActivity(intent)
        }

    }
}