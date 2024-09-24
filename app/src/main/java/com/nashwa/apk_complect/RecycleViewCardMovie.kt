package com.nashwa.apk_complect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.apk_complect.adapter.MovieAdapter
import com.nashwa.apk_complect.model.ModelMovie

class RecycleViewCardMovie : AppCompatActivity() {
    private var recycleview: RecyclerView? = null
    private var movieAdapter: MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_card_movie)

        recycleview = findViewById(R.id.rv_movie) as RecyclerView

        movieAdapter = MovieAdapter(this@RecycleViewCardMovie, movieList) { position ->
            // Menampilkan dialog gambar detail ketika item di-klik

        }

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recycleview!!.layoutManager = layoutManager
        recycleview!!.adapter = movieAdapter

        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList() {
        var movie = ModelMovie("Avatar", R.drawable.avatar, "27 November 2023",  getString(R.string.sinopsis1) )
        movieList.add(movie)

        movie = ModelMovie("Batman", R.drawable.batman, "26 Oktoberr 2023",  getString(R.string.sinopsis1))
        movieList.add(movie)
        movie = ModelMovie("End Game", R.drawable.end_game, "01 Januari 2024",  getString(R.string.sinopsis2))
        movieList.add(movie)
        movie = ModelMovie("Hulk", R.drawable.hulk, "06 Juli 2023",  getString(R.string.sinopsis3))
        movieList.add(movie)
        movie = ModelMovie("Inception", R.drawable.inception, "06 Juli 2023",  getString(R.string.sinopsis4))
        movieList.add(movie)
        movie = ModelMovie("Jumanji", R.drawable.jumanji, "01 Agustus 2023",  getString(R.string.sinopsis3))
        movieList.add(movie)
        movie = ModelMovie("Lucy", R.drawable.lucy, "08 Juli 2023",  getString(R.string.sinopsis5))
        movieList.add(movie)
        movie = ModelMovie("Jurassic World", R.drawable.jurassic_world, "06 Juli 2023",  getString(R.string.sinopsis3))
        movieList.add(movie)
        movie = ModelMovie("Spider Man", R.drawable.spider_man, "06 Juli 2023",  getString(R.string.sinopsis4))
        movieList.add(movie)
        movie = ModelMovie("Venom", R.drawable.venom, "16 Juni 2023",  getString(R.string.sinopsis5))
        movieList.add(movie)

        movieAdapter!!.notifyDataSetChanged()
    }


}
