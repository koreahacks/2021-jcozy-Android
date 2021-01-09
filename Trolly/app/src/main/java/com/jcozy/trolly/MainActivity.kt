package com.jcozy.trolly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcozy.trolly.main.MainTimeAttackAdapter
import com.jcozy.trolly.network.MainTimeAttackData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainTimeAttackAdapter : MainTimeAttackAdapter
    val data = mutableListOf<MainTimeAttackData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTimeAttackAdapter = MainTimeAttackAdapter(this)
        main_time_rc.adapter = mainTimeAttackAdapter
        main_time_rc.addItemDecoration(ItemDecoration(this, 20,30, 0))
        loadMainTimeAttackData()

    }

    private fun loadMainTimeAttackData(){
        data.apply {
            add(
                MainTimeAttackData(
                    timeattackIdx = 1,
                    mainImg = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "쇼 미더 문",
                    time = "5:00PM - 6:00PM",
                    people = 10
                )
            )
            add(
                MainTimeAttackData(
                    timeattackIdx = 2,
                    mainImg = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "쇼 미더 문",
                    time = "5:00PM - 6:00PM",
                    people = 10
                )
            )
        }

        mainTimeAttackAdapter.data = data
        mainTimeAttackAdapter.notifyDataSetChanged()

    }
}