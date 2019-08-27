package com.example.wardrobe.recyclerAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.wardrobe.R
import com.example.wardrobe.models.Shirt
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import kotlinx.android.synthetic.main.single_item_layout.view.*


class ShirtRecyclerAdapter(var ctx: Context, var list: ArrayList<Shirt>) :
    RecyclerView.Adapter<ShirtRecyclerAdapter.ShirtViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtViewHolder {
        val layout = LayoutInflater.from(ctx).inflate(R.layout.single_item_layout, parent, false)
        return ShirtViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShirtViewHolder, position: Int) {
        val currentShirt = list[position]
        holder.nameShirt.text = currentShirt.name
        holder.sizeShirt.text = currentShirt.size.toString()
        holder.colorShirt.text = currentShirt.color
        holder.picShirt.imageAlpha= currentShirt.imagePath

    }


    inner class ShirtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameShirt = itemView.findViewById<TextView>(R.id.nameShirt1)
        var sizeShirt = itemView.findViewById<TextView>(R.id.sizeShirt1)
        var colorShirt = itemView.findViewById<TextView>(R.id.colorShirt1)
        var picShirt = itemView.findViewById<ImageView>(R.id.picShirt)
    }
}


