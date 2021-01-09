package com.jcozy.trolly.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainMainData

class MainMainAdapter (private val context: Context, val itemClick: (MainMainData, View) -> Unit) : RecyclerView.Adapter<MainMainViewHolder>() {

    var data = mutableListOf<MainMainData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_mainquest, parent, false)
        return MainMainViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainMainViewHolder, position: Int) {
        holder.bind(data[position])
    }

}