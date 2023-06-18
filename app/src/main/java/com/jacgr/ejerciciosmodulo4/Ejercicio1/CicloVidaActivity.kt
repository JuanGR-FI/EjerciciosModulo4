package com.jacgr.ejerciciosmodulo4.Ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.jacgr.ejerciciosmodulo4.R

class CicloVidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnImpIntent = findViewById<Button>(R.id.btnImpIntent)

        btnImpIntent.setOnClickListener {
            val intent = Intent(this, IntentImplicitoActivity::class.java)
            startActivity(intent)
        }

        //Log.e("CICLODEVIDA", "onCreate")
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        //Log.e("CICLODEVIDA", "onStart")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        //Log.e("CICLODEVIDA", "onResume")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        //Log.e("CICLODEVIDA", "onPause")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        //Log.e("CICLODEVIDA", "onStop")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        //Log.e("CICLODEVIDA", "onRestart")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Log.e("CICLODEVIDA", "onDestroy")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

}