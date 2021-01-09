package com.jcozy.trolly.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.R
import kotlin.properties.Delegates

class MainTimeAttackViewHolder(itemView: View/*, val itemClick:(MainTimeAttackData, View) -> Unit*/) : RecyclerView.ViewHolder(itemView){

    var timeattackIdx by Delegates.notNull<Int>()
    var mainImg : ImageView = itemView.findViewById(R.id.time_img)
    var name : TextView = itemView.findViewById(R.id.tv_time_name)
    var time : TextView = itemView.findViewById(R.id.tv_time_time)
    var people : TextView = itemView.findViewById(R.id.tv_time_people)

    fun bind(myData : MainTimeAttackData){
        timeattackIdx = myData.timeattackIdx
        Glide.with(itemView).load(myData.mainImg).into(mainImg)
        name.text = myData.name
        time.text = myData.time
        people.text = myData.people.toString() + "명 참여중"

       /* itemView.setOnClickListener { itemClick(myData, itemView) }*/
    }



}