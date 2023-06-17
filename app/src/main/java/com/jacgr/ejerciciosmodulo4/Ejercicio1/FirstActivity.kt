package com.jacgr.ejerciciosmodulo4.Ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.jacgr.ejerciciosmodulo4.R

class FirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == RESULT_OK){
            /*Toast.makeText(this,
                "resultCode = ${result.resultCode} EXTRA_IS_OK = ${result.data?.getBooleanExtra("EXTRA_IS_OK", false)}",
                Toast.LENGTH_LONG).show()*/
            Toast.makeText(this,
                "NAME = ${result.data?.getStringExtra("EXTRA_NAME")} LASTNAME = ${result.data?.getStringExtra("EXTRA_LASTNAME")} AGE = ${result.data?.getIntExtra("EXTRA_AGE",0)}",
                Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "resultCode = ${result.resultCode} - CANCELLED", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btnCall = findViewById<Button>(R.id.btnCall)

        btnCall.setOnClickListener {
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Juan Andres")
                putExtra("EXTRA_LASTNAME", "Cervantes Guati Rojo")
                putExtra("EXTRA_AGE", 33)
            }
            //startActivity(secondIntent)
            register.launch(secondIntent)
        }

    }
}