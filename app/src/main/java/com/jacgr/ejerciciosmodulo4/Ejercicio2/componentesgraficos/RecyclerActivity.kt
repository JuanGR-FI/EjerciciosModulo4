package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Person
import com.jacgr.ejerciciosmodulo4.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPeople = findViewById<RecyclerView>(R.id.rvPeopleList)

        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Juan"),
            Person("2", "Ana"),
            Person("3", "Paco"),
            Person("4", "Zaira"),
            Person("5", "Oscar"),
            Person("6", "Andres"),
            Person("7", "Katherine"),
            Person("8", "Gustavo"),
            Person("9", "Daniela"),
            Person("10", "Brayan")
        ))

        rvPeople.adapter = personAdapter
        rvPeople.layoutManager = LinearLayoutManager(this)

    }
}