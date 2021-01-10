package com.jcozy.trolly.ui.questdetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.QuestDetailReviewData

class ReviewAdapter(private val context : Context) : RecyclerView.Adapter<ReviewViewHolder>() {
    var datas = mutableListOf<QuestDetailReviewData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
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

    fun bind(myData: QuestDetailReviewData){
        Glide.with(itemView).load(myData.img_url).into(mainImg)
    }
}