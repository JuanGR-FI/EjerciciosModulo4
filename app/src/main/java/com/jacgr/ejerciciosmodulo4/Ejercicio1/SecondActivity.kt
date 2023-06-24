package com.jacgr.ejerciciosmodulo4.Ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.jacgr.ejerciciosmodulo4.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val weight = intent.getDoubleExtra("EXTRA_WEIGHT",0.0)
        val married = intent.getBooleanExtra("EXTRA_MARRIED", false)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvWeight = findViewById<TextView>(R.id.tvWeight)
        val tvMarried = findViewById<TextView>(R.id.tvMarried)

        tvName.text = "Name: ${name}"
        tvLastName.text = "Last Name: ${lastName}"
        tvAge.text = "Age: ${age}"
        tvWeight.text = "Weight: ${weight} kg"
        tvMarried.text = "Married: ${married}"

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            val returnIntent = Intent().apply {
                //putExtra("EXTRA_IS_OK", true)
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_LASTNAME", lastName)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_WEIGHT", weight)
                putExtra("EXTRA_MARRIED", married)

            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val returnIntent = Intent().apply {
                    //putExtra("EXTRA_IS_OK", true)
                    putExtra("EXTRA_NAME", "Juan")
                    putExtra("EXTRA_LASTNAME", "Cervantes")
                    putExtra("EXTRA_AGE", 23)
                    putExtra("EXTRA_WEIGHT", 75.0)
                    putExtra("EXTRA_MARRIED", true)
                }
                setResult(RESULT_OK, returnIntent)
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}