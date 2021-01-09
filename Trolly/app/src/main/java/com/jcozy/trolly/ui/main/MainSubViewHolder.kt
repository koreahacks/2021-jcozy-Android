package com.jcozy.trolly.ui.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainMainData
import com.jcozy.trolly.network.responseData.MainSubData
import kotlin.properties.Delegates

class MainSubViewHolder(itemView: View, val itemClick:(MainSubData, View) -> Unit): RecyclerView.ViewHolder(itemView) {


    var id by Delegates.notNull<String>()
    var mainImg : ImageView = itemView.findViewById(R.id.img_sub)
    var name : TextView = itemView.findViewById(R.id.tv_sub_title)
    var level : TextView = itemView.findViewById(R.id.tv_sub_lv)
    var people : TextView = itemView.findViewById(R.id.tv_sub_people)

    fun bind(myData : MainSubData){
        id = myData._id
        Glide.with(itemView).load(myData.image).into(mainImg)
        name.text = myData.title
        level.text = "Lv. " + myData.level.toString()
        people.text = myData.participant.toString() + "명 참여"
        itemView.setOnClickListener { itemClick(myData, itemView) }
    }


}