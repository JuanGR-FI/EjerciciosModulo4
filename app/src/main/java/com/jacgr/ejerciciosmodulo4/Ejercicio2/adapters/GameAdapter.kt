package com.jacgr.ejerciciosmodulo4.Ejercicio2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jacgr.ejerciciosmodulo4.Ejercicio2.componentesgraficos.PersonViewHolder
import com.jacgr.ejerciciosmodulo4.Ejercicio2.models.Game
import com.jacgr.ejerciciosmodulo4.R
import com.squareup.picasso.Picasso

class GameAdapter(private var list: List<Game>) : RecyclerView.Adapter<GameViewHolder>() {

    var onItemSelected : ((Game) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}

class GameViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvName = view.findViewById<TextView>(R.id.tvGameName)
    val tvPrice = view.findViewById<TextView>(R.id.tvGamePrice)
    val tvCategory = view.findViewById<TextView>(R.id.tvGameCategory)
    val ivGame = view.findViewById<ImageView>(R.id.ivGame)

    val root = view.findViewById<ConstraintLayout>(R.id.root)
    fun render(game: Game, onItemSelected: ((Game) -> Unit)?) {
        tvName.text = game.name
        tvPrice.text = "$" + game.price.toString()
        tvCategory.text = game.category

        root.setOnClickListener {
            onItemSelected?.invoke(game)
        }

        Picasso.get()
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV6D8fJZWgcW5SpV0ZnF8XTOmCcY1C1wCRPU9LJ-MzQFMPqiPkPw87OMcIQe7IM3WQVnw&usqp=CAU")
            .error(R.drawable.ic_people)
            .placeholder(R.drawable.img_android)
            .into(ivGame)
    }

}
