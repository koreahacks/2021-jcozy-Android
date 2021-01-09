package com.jcozy.trolly.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainSubData

class MainSubAdapter(private val context: Context, val itemClick: (MainSubData, View) -> Unit) : RecyclerView.Adapter<MainSubViewHolder>() {

    var data = mutableListOf<MainSubData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSubViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_sub, parent, false)
        return MainSubViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainSubViewHolder, position: Int) {
        holder.bind(data[position])
    }

}