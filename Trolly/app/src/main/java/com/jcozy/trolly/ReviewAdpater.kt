package com.jcozy.trolly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ReviewAdapter(private val context : Context) : RecyclerView.Adapter<ReviewViewHolder>() {
    var datas = mutableListOf<ReviewData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.item_review,parent,false)
        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}

class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mainImg : ImageView = itemView.findViewById(R.id.iv_review_pic)

    fun bind(myData: ReviewData){
        Glide.with(itemView).load(myData.img).into(mainImg)
    }
}