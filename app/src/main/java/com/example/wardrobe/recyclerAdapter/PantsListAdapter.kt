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
import com.example.wardrobe.models.Pants
import org.w3c.dom.Text

class PantsListAdapter(var ctx: Context, var list : ArrayList<Pants>):
    RecyclerView.Adapter<PantsListAdapter.PantsListHolderView> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PantsListHolderView {
        var layout = LayoutInflater.from(ctx).inflate(R.layout.single_item_layout2, parent, false)
        return PantsListHolderView(layout)

    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onBindViewHolder(holder: PantsListHolderView, position: Int) {
        val currentPants = list[position]
        holder.namePants.text = currentPants.name
        holder.sizePants.text= currentPants.size.toString()
        holder.colorPants.text = currentPants.color

        GlideApp.with(ctx).load(R.mipmap.ic_launcher_image).into(holder.picPants)

    }

    inner class PantsListHolderView(itemView: View): RecyclerView.ViewHolder(itemView){
        var namePants = itemView.findViewById<TextView>(R.id.nameItem1)
        var sizePants = itemView.findViewById<TextView>(R.id.sizeItem1)
        var colorPants = itemView.findViewById<TextView>(R.id.colorItem1)
        var picPants = itemView.findViewById<ImageView>(R.id.picItem)

    }
}