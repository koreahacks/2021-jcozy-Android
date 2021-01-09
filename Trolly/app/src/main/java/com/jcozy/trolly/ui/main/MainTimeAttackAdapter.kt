package com.jcozy.trolly.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.R

class MainTimeAttackAdapter(private val context: Context/*, val itemClick: (MainTimeAttackData, View) -> Unit*/) : RecyclerView.Adapter<MainTimeAttackViewHolder>() {

    var data = mutableListOf<MainTimeAttackData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTimeAttackViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_timeattack, parent, false)
        return MainTimeAttackViewHolder(
            view/*,
            itemClick*/
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainTimeAttackViewHolder, position: Int) {
       holder.bind(data[position])
    }

}