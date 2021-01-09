package com.jcozy.trolly.ui.timeattack

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jcozy.trolly.R

class TimeAttackPartiAdapter(val context: Context, var data : MutableList<TimeAttackPartiData>) : RecyclerView.Adapter<TimeAttackPartiViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeAttackPartiViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_live_parti, parent, false)
        return TimeAttackPartiViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeAttackPartiViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}