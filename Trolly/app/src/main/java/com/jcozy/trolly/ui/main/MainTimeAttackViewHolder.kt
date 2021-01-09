package com.jcozy.trolly.ui.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.R
import kotlin.properties.Delegates

class MainTimeAttackViewHolder(itemView: View, val itemClick:(MainTimeAttackData, View) -> Unit) : RecyclerView.ViewHolder(itemView){

    var id by Delegates.notNull<String>()
    var mainImg : ImageView = itemView.findViewById(R.id.time_img)
    var name : TextView = itemView.findViewById(R.id.tv_time_name)
    var time : TextView = itemView.findViewById(R.id.tv_time_time)
    var people : TextView = itemView.findViewById(R.id.tv_time_people)

    fun bind(myData : MainTimeAttackData){
        id = myData._id
        Glide.with(itemView).load(myData.image).into(mainImg)
        name.text = myData.title

        val test_start_hour = myData.start.substring(11,13)
        val test_start_min = myData.start.substring(14,16)

        val test_end_hour = myData.end.substring(11,13)
        val test_end_min = myData.end.substring(14,16)

        time.text = test_start_hour + " : " + test_start_min + " - " + test_end_hour + " : "+ test_end_min
        people.text = myData.participant.toString() + "명 참여"

        itemView.setOnClickListener { itemClick(myData, itemView) }
    }



}