package com.moviles.homework.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.moviles.homework.R
import com.moviles.homework.model.Image
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_img.view.*

class Adapter () : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var items: ArrayList<Image>

    override fun getItemCount(): Int {
        return if (::items.isInitialized){
            items.size
        }else{
            0
        }
    }

    fun setImg(items: List<Image>){
        this.items = items as ArrayList<Image>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_img, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.descripcion.text="${model.descripcion}"
        holder.color.text="|${model.color}"

        Picasso.get()
            .load(model.url)
            .into(holder.imgImage)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
      val imgImage: ImageView = view.iv_img
      val descripcion: TextView = view.tv_descripcion
      val color : TextView = view.tv_color

    }
}



