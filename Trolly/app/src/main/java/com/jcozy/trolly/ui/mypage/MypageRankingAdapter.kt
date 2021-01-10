package com.jcozy.trolly.ui.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.TotalData


class MypageRankingAdapter (private val context: Context) : RecyclerView.Adapter<MypageRankingViewHolder>()  {

    var data = mutableListOf<TotalData>()
    var count = 0

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
        holder.ranking.text = (count + 1).toString()
        count = count+1;
    }

}