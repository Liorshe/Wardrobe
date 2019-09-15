package com.example.wardrobe.recyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wardrobe.R
import com.example.wardrobe.models.Shoes

class ShoesListAdapter(var ctx: Context, var list: ArrayList<Shoes>):
    RecyclerView.Adapter<ShoesListAdapter.ShoesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val layout = LayoutInflater.from(ctx).inflate(R.layout.single_item_layout2, parent, false)
        return ShoesViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val currentShoes = list[position]
        holder.nameShoes.text = currentShoes.name
        holder.sizeShoes.text = currentShoes.size.toString()
        holder.colorShoes.text = currentShoes.color

        Glide.with(ctx).load("https://atlas-content-cdn.pixelsquid.com/stock-images/running-shoes-QJGJa6D-600.jpg").into(holder.picShoes)
    }

    inner class ShoesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nameShoes= itemView.findViewById<TextView>(R.id.nameItem1)
        var sizeShoes = itemView.findViewById<TextView>(R.id.sizeItem1)
        var colorShoes = itemView.findViewById<TextView>(R.id.colorItem1)
        var picShoes = itemView.findViewById<ImageView>(R.id.picItem)




    }

}