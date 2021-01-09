package com.jcozy.trolly.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.RankingData



class MypageRankingAdapter (private val context: Context) : RecyclerView.Adapter<MypageRankingViewHolder>()  {

    var data = mutableListOf<RankingData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypageRankingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ranking, parent, false)
        return MypageRankingViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MypageRankingViewHolder, position: Int) {
        holder.bind(data[position])
    }

}