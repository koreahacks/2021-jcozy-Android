package com.jcozy.trolly.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.ItemDecoration
import com.jcozy.trolly.R
import com.jcozy.trolly.StampDialog
import com.jcozy.trolly.mypage.MypageActivity
import com.jcozy.trolly.ui.main.MainMainAdapter
import com.jcozy.trolly.ui.main.MainSubAdapter
import com.jcozy.trolly.network.responseData.MainMainData
import com.jcozy.trolly.network.responseData.MainSubData
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.ui.main.MainTimeAttackAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mainTimeAttackAdapter : MainTimeAttackAdapter
    lateinit var mainmainAdapter : MainMainAdapter
    lateinit var mainSubAdapter : MainSubAdapter

    val data = mutableListOf<MainTimeAttackData>()
    val mainData = mutableListOf<MainMainData>()
    val subData = mutableListOf<MainSubData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ic_mypage.setOnClickListener(this)

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
                0,
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

        ic_stamp.setOnClickListener {
            val stampDialog = StampDialog(this)
            stampDialog.start("몽블리", 2, 1, 3)
        }

    }


    private fun loadMainTimeAttackData(){
        data.apply {
            add(
                MainTimeAttackData(
                    timeattackIdx = 1,
                    mainImg = "https://images.unsplash.com/photo-1479186479563-2af7090284c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1055&q=80",
                    name = "쇼 미더 문",
                    time = "5:00PM - 6:00PM",
                    people = 10
                )
            )
            add(
                MainTimeAttackData(
                    timeattackIdx = 2,
                    mainImg = "https://images.unsplash.com/photo-1479186479563-2af7090284c6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1055&q=80",
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
                    mainImg = "https://images.unsplash.com/photo-1549122728-f519709caa9c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1850&q=80",
                    name = "문학소녀처럼, 독서타임",
                    level = 3,
                    people = 10
                )
            )
            add(
                MainMainData(
                    mainmainIdx = 1,
                    mainImg = "https://images.unsplash.com/photo-1549122728-f519709caa9c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1850&q=80",
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

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ic_mypage -> {
                val intent = Intent(applicationContext, MypageActivity::class.java)
                startActivity(intent)
            }
        }
    }


}