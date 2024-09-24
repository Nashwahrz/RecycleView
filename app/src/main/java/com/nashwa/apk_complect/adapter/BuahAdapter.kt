package com.nashwa.apk_complect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.apk_complect.CustomImageRecycleView
import com.nashwa.apk_complect.DetailBuah
import com.nashwa.apk_complect.R
import com.nashwa.apk_complect.RecycleviewActivity
import com.nashwa.apk_complect.model.ModelBuah
import com.nashwa.apk_complect.potodetailBuah

class BuahAdapter  (
    val itemList : ArrayList<ModelBuah>,
     private val getActivity: CustomImageRecycleView // untuk bisa klik item, kita replace dengan getActivity
) :

      RecyclerView.Adapter<BuahAdapter.ModelViewHolder>() {

    class ModelViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        //deklarasi widget dari item layout
        lateinit var ItemImage : ImageView
        lateinit var ItemText : TextView

        init {
            ItemImage = itemView.findViewById(R.id.gambar) as ImageView
            ItemText = itemView.findViewById(R.id.nama) as TextView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_customeimage, parent, false)
        return ModelViewHolder(nView)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.ItemImage.setImageResource(itemList[position].image)
        holder.ItemText.setText(itemList[position].deskripsi)

        holder.itemView.setOnClickListener {
            //deklarasi intent
            val intent = Intent(getActivity, DetailBuah::class.java)
            //baru put extra variable yang ingin dilempar
            intent.putExtra("deskripsi", itemList[position].deskripsi)
            intent.putExtra("image", itemList[position].image)
            //passed ke detail
            getActivity.startActivity(intent)
        }
    }





}