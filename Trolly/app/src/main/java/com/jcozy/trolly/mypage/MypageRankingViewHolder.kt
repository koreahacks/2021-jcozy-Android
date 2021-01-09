package com.jcozy.trolly.mypage

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.RankingData

class MypageRankingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var profile : ImageView = itemView.findViewById(R.id.iv_mypage_ranking_profile)
    var name : TextView = itemView.findViewById(R.id.tv_ranking_username)
    var ranking : TextView = itemView.findViewById(R.id.tv_ranking)

    fun bind(myData : RankingData){
        Glide.with(itemView).load(myData.profile).into(profile)
        name.text = myData.name
        ranking.text = myData.ranking.toString()
    }

}