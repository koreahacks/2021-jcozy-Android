package com.jcozy.trolly.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.ItemDecoration
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.MainMainData
import com.jcozy.trolly.network.responseData.MainSubData
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mainTimeAttackAdapter : MainTimeAttackAdapter
    lateinit var mainmainAdapter : MainMainAdapter
    lateinit var mainSubAdapter : MainSubAdapter

    val data = mutableListOf<MainTimeAttackData>()
    val mainData = mutableListOf<MainMainData>()
    val subData = mutableListOf<MainSubData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainTimeAttackAdapter = MainTimeAttackAdapter(this)
        main_time_rc.adapter = mainTimeAttackAdapter
        main_time_rc.addItemDecoration(
            ItemDecoration(
                this,
                20,
                0,
                30,
                0
            )
        )
        mainmainAdapter = MainMainAdapter(this)
        main_main_rc.adapter = mainmainAdapter
        main_main_rc.addItemDecoration(
            ItemDecoration(
                this,
                0,
                0,
                16,
                20
            )
        )
        mainSubAdapter = MainSubAdapter(this)
        main_sub_rc.adapter = mainSubAdapter
        main_sub_rc.addItemDecoration(
            ItemDecoration(
                this,
                0,
                12,
                12,
                0
            )
        )
        loadMainTimeAttackData()
        loadMainMainData()
        loadMainSubData()

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

    private fun loadMainMainData(){
        mainData.apply {
            add(
                MainMainData(
                    mainmainIdx = 1,
                    mainImg = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "문학소녀처럼, 독서타임",
                    level = 3,
                    people = 10
                )
            )
            add(
                MainMainData(
                    mainmainIdx = 1,
                    mainImg = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "문학소녀처럼, 독서타임",
                    level = 3,
                    people = 10
                )
            )
        }
        mainmainAdapter.data = mainData
        mainmainAdapter.notifyDataSetChanged()
    }

    private fun loadMainSubData(){
        subData.apply{
            add(
                MainSubData(
                    subIdx = 1,
                    mainImg = "https://cdn.pixabay.com/photo/2016/12/30/17/27/cat-1941089__340.jpg",
                    name = "느낌있는 막춤 챌린지",
                    people = 11,
                    level = 2
                )
            )
            add(
                MainSubData(
                    subIdx = 1,
                    mainImg = "https://cdn.pixabay.com/photo/2016/12/30/17/27/cat-1941089__340.jpg",
                    name = "느낌있는 막춤 챌린지",
                    people = 11,
                    level = 2
                )
            )
        }

        mainSubAdapter.data = subData
        mainSubAdapter.notifyDataSetChanged()
    }


}

