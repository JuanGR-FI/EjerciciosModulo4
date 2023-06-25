package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jacgr.ejerciciosmodulo4.R

class LinearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear)

        val btnRelativeLayout = findViewById<Button>(R.id.btnRelativeLayout)

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeActivity::class.java)
            startActivity(intent)
        }

    }
}