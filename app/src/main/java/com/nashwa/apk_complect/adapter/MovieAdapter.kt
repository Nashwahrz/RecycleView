package com.nashwa.apk_complect.adapter

import android.content.Context
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

class MovieAdapter(
    private val context: Context,
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_car, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.imageView.setImageResource(movie.image)

        // Menambahkan event klik
        holder.itemView.setOnClickListener {
            itemClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgMovie)
    }
}


