package com.nashwa.apk_complect.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nashwa.apk_complect.R
import com.nashwa.apk_complect.model.ModelBuah
import com.nashwa.apk_complect.potodetailBuah

class BuahAdapter  (val itemList : ArrayList<ModelBuah>  ) :

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
            val context = holder.itemView.context
            val intent = Intent(context, potodetailBuah::class.java)
            intent.putExtra("imageResId", itemList[position].image)  // Mengirim gambar
            intent.putExtra("deskripsi", itemList[position].deskripsi)  // Mengirim deskripsi
            context.startActivity(intent)  // Memulai activity detail
        }
    }





}