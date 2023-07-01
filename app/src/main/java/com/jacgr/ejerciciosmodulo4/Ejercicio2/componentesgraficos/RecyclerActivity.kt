package com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jacgr.ejerciciosmodulo4.Ejercicio2.adapters.GameAdapter
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Game
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Person
import com.jacgr.ejerciciosmodulo4.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPeople = findViewById<RecyclerView>(R.id.rvPeopleList)

        /*val personAdapter = PersonAdapter(arrayListOf(
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
        rvPeople.layoutManager = LinearLayoutManager(this)*/

        val gameAdapter = GameAdapter(arrayListOf(
            Game("Halo Infinite", 1195.99f, "Disparos"),
            Game("Mario Kart 8", 1399.99f, "Vehículos"),
            Game("Super Smash Bros. Ultimate", 1399.99f, "Peleas"),
            Game("Cuphead", 999.99f, "Acción, Arcade"),
            Game("Minecraft", 799.99f, "Aventura"),
            Game("Crash Bandicoot 4", 940.00f, "Aventura"),
            Game("Grand Theft Auto V", 599.99f, "Disparos"),
            Game("Spider-Man 2", 1599.99f, "Acción"),
            Game("Dead Island 2", 1480.99f, "Survival Horror"),
            Game("God of War Ragnarok", 960.00f, "Acción")
        ))

        gameAdapter.onItemSelected = {game ->
            Toast.makeText(this, "${game.name}", Toast.LENGTH_SHORT).show()
        }

        rvPeople.adapter = gameAdapter
        rvPeople.layoutManager = LinearLayoutManager(this)

    }
}