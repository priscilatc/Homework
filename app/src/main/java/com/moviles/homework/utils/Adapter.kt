package com.moviles.homework.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.homework.R
import com.moviles.homework.model.Dog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_dog.*
import kotlinx.android.synthetic.main.item_dog.view.*

class Adapter () : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var items: ArrayList<Dog>

    override fun getItemCount(): Int {
        return if (::items.isInitialized){
            items.size
        }else{
            0
        }
    }

    fun setImg(items: List<Dog>){
        this.items = items as ArrayList<Dog>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.sizeInfo.text="${model.width} x ${model.height}"
        Picasso.get()
            .load(model.url)
            .into(holder.dogImage)
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
      val dogImage: ImageView = view.iv_dog
      val sizeInfo: TextView = view.tv_info

    }
}

