package com.jcozy.trolly.timeattack

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import kotlinx.android.synthetic.main.item_live_parti.view.*

class TimeAttackPartiViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    var userprofile = itemView.findViewById<ImageView>(R.id.iv_parti_userprofile)
    var username = itemView.findViewById<TextView>(R.id.tv_parti_username)
    var image = itemView.findViewById<ImageView>(R.id.iv_live_parti)
    var uploadedTime = itemView.findViewById<TextView>(R.id.tv_uploadtime_parti)

    fun bind(myData: TimeAttackPartiData) {
        Glide.with(itemView).load(myData.userprofile).into(userprofile)
        username.text = myData.username
        Glide.with(itemView).load(myData.uploaded_img).into(image)
        uploadedTime.text = myData.uploaded_time
    }
}