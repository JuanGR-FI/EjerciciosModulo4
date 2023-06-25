package com.jacgr.ejerciciosmodulo4.Ejercicio2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos.PersonViewHolder
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Game
import com.jacgr.ejerciciosmodulo4.R

class GameAdapter(private var list: List<Game>) : RecyclerView.Adapter<GameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.render(list[position])
    }
}

class GameViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun render(game: Game) {

    }

}
