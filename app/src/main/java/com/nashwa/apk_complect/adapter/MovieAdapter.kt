package com.nashwa.apk_complect.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.apk_complect.R
import com.nashwa.apk_complect.RecycleViewCardMovie
import com.nashwa.apk_complect.RecycleviewActivity
import com.nashwa.apk_complect.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: RecycleViewCardMovie, //bisa diklik
    private val movieList: List<ModelMovie>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val txtMovie : TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView : CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_car, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = movieList[position].title
        holder.imgMovie.setImageResource(movieList[position].image)

        holder.cardView.setOnClickListener(){
            Toast.makeText(
                getActivity, movieList[position].title,
                Toast.LENGTH_SHORT
            ).show()
        }
    }


}


