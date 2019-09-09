package com.example.wardrobe.recyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.wardrobe.GlideApp
import com.example.wardrobe.R
import com.example.wardrobe.models.Shirt

class ShirtListAdapter(var ctx: Context, var list: ArrayList<Shirt>):
    RecyclerView.Adapter<ShirtListAdapter.ShirtListHolderView>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtListHolderView {
       val layout = LayoutInflater.from(ctx).inflate(R.layout.single_item_layout2, parent, false)
        return ShirtListHolderView(layout)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: ShirtListHolderView, position: Int) {
        val currentShirt = list[position]
        holder.nameShirt.text = currentShirt.name
        holder.sizeShirt.text = currentShirt.size.toString()
        holder.colorShirt.text = currentShirt.color
//        holder.picShirt.imageAlpha= currentShirt.imagePath

        GlideApp.with(ctx)
            .load(R.drawable.ic_menu_share)
//            .load("http://via.placeholder.com/300.png")
            .into(holder.picShirt)
    }


    inner class ShirtListHolderView(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nameShirt = itemView.findViewById<TextView>(R.id.nameItem1)
        var sizeShirt = itemView.findViewById<TextView>(R.id.sizeItem1)
        var colorShirt = itemView.findViewById<TextView>(R.id.colorItem1)
        var picShirt = itemView.findViewById<ImageView>(R.id.picItem)

    }
}