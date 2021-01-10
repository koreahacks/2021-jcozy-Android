package com.jcozy.trolly.ui.main


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainMainData
import kotlin.properties.Delegates

class MainMainViewHolder(itemView: View, val itemClick:(MainMainData, View) -> Unit): RecyclerView.ViewHolder(itemView){


    var id by Delegates.notNull<String>()
    var image : ImageView = itemView.findViewById(R.id.main_img)
    var title : TextView = itemView.findViewById(R.id.tv_main_name)
    var level : TextView = itemView.findViewById(R.id.tv_main_lv)
    var participant : TextView = itemView.findViewById(R.id.tv_main_people)

    var red : ImageView = itemView.findViewById(R.id.ic_completed_red)
    var background : ImageView = itemView.findViewById(R.id.completed)
    var lv_img : ImageView = itemView.findViewById(R.id.img_main_lv)

    fun bind(myData : MainMainData){
        id = myData._id
        if(myData.completed == 0){
            background.visibility = View.GONE
            red.visibility = View.GONE
        }
        else{
            background.visibility = View.VISIBLE
            red.visibility = View.VISIBLE
        }
        Glide.with(itemView).load(myData.image).into(image)
        title.text = myData.title
        level.text = "Lv. " + myData.level.toString()
        if(myData.level == 1){
            lv_img.setImageResource(R.drawable.icon_level1)
        }
        else if(myData.level == 2){
            lv_img.setImageResource(R.drawable.icon_level2)
        }
        else{
            lv_img.setImageResource(R.drawable.icon_level3)
        }

        participant.text = myData.participant.toString() + "명 참여"

        itemView.setOnClickListener { itemClick(myData, itemView) }
    }

}