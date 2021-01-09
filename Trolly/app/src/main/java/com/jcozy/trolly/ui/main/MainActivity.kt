package com.jcozy.trolly.ui.main

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.bumptech.glide.Glide
import com.jcozy.trolly.ItemDecoration
import com.jcozy.trolly.R
import com.jcozy.trolly.StampDialog
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import com.jcozy.trolly.network.responseData.AdData
import com.jcozy.trolly.ui.mypage.MypageActivity
import com.jcozy.trolly.network.responseData.MainMainData
import com.jcozy.trolly.network.responseData.MainSubData
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.ui.questdetail.QuestDetailActivity
import com.jcozy.trolly.ui.timeattack.TimeAttackActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main_sub.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mainTimeAttackAdapter : MainTimeAttackAdapter
    lateinit var mainmainAdapter : MainMainAdapter
    lateinit var mainSubAdapter : MainSubAdapter

    val service = RequestToServer.service
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor


    val data = mutableListOf<MainTimeAttackData>()
    val mainData = mutableListOf<MainMainData>()
    val subData = mutableListOf<MainSubData>()
    lateinit var myData : AdData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ic_mypage.setOnClickListener(this)
        layout_adv.setOnClickListener(this)

        mainTimeAttackAdapter = MainTimeAttackAdapter(this){ MainTimeAttackData, View ->
            val intent = Intent(this, TimeAttackActivity::class.java)
            startActivity(intent)
        }
        sharedPref = this.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        editor = sharedPref.edit()
        editor.putString("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZmZhMDgxNzU0YWM3ZjRkM2NmMzgwNjEiLCJpYXQiOjE2MTAyMjE1OTIsImlzcyI6Im91ci1zb3B0In0.1PgxkZCH3e0rj72v_rq9hr2cuCqOV-xff3HCn9AcdRY")
        editor.apply()
        editor.commit()

        main_time_rc.adapter = mainTimeAttackAdapter
        main_time_rc.offscreenPageLimit = 4
        main_time_rc.clipChildren = false
        main_time_rc.addItemDecoration(ItemDecoration(this, 0, 0, 10, 0))
        mainmainAdapter = MainMainAdapter(this){ MainMainData, View ->
            val intent = Intent(this, QuestDetailActivity::class.java)
            startActivity(intent)
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer { view, position ->

            when {
                position <= -1.0F -> {
                    view.translationX = view.width * position
                    view.scaleX = 0.6f
                    view.scaleY = 0.6f
                    view.alpha = 0.4F
                }
                position > -1.0F && position < 0.0F -> {
                    view.translationX = view.width * -position
                    view.scaleX = 1.0f - (Math.abs(position) / 4)
                    view.scaleY = 1.0f - (Math.abs(position) / 4)
                    view.alpha = 1.0F - (Math.abs(position) / 2)
                }
                else -> {
                    view.scaleX = 1.0f
                    view.scaleY = 1.0f
                    view.alpha = 1.0F
                }
            }
        }
        main_time_rc.setPageTransformer(compositePageTransformer)
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
        mainSubAdapter = MainSubAdapter(this){ MainSubData, View ->
            val intent = Intent(this, QuestDetailActivity::class.java)
            startActivity(intent)
        }
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
        loadAd()

        ic_stamp.setOnClickListener {
            val stampDialog = StampDialog(this)
            stampDialog.start("몽블리", 2, 1, 3)
        }

    }


    private fun loadMainTimeAttackData(){

        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestTimeAttack(header).customEnqueue(
            onError = {Toast.makeText(this,"올바르지 않은 요청입니다.",Toast.LENGTH_SHORT)},
            onSuccess = {
                data.clear()
                data.addAll(it.data)
                mainTimeAttackAdapter.data = data
                mainTimeAttackAdapter.notifyDataSetChanged()
            }
        )

    }

    private fun loadMainMainData(){

        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestMainQuest(header).customEnqueue(
            onError = {Toast.makeText(this,"올바르지 않은 요청입니다.",Toast.LENGTH_SHORT)},
            onSuccess = {
                mainData.clear()
                mainData.addAll(it.data)
                mainmainAdapter.data = mainData
                mainmainAdapter.notifyDataSetChanged()
            }
        )

    }

    private fun loadMainSubData(){

        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestSubQuest(header).customEnqueue(
            onError = {Toast.makeText(this,"올바르지 않은 요청입니다.",Toast.LENGTH_SHORT)},
            onSuccess = {
                subData.clear()
                subData.addAll(it.data)
                mainSubAdapter.data = subData
                mainSubAdapter.notifyDataSetChanged()
            }
        )

        mainSubAdapter.data = subData
        mainSubAdapter.notifyDataSetChanged()
    }

    private fun loadAd(){

        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestAd(header).customEnqueue(
            onError = {Toast.makeText(this,"올바르지 않은 요청입니다.",Toast.LENGTH_SHORT)},
            onSuccess = {
                if(it.message == "광고 조회 실패") {
                    layout_adv.visibility = View.GONE
                }
                else{
                    myData = it.data.elementAt(0)
                    Glide.with(this).load(myData.image).into(main_sub_img)
                    tv_main_sub_cate.text = myData.title
                    tv_main_sub_name.text = myData.sub_title
                    tv_main_sub_people.text = myData.participant.toString() +"명 참여"
                    tv_main_sub_lv.text = "Lv. " + myData.level.toString()
                    if(myData.level == 1){
                        img_main_sub_lv.setImageResource(R.drawable.icon_level1)
                    }
                    else if(myData.level == 2){
                        img_main_sub_lv.setImageResource(R.drawable.icon_level2)
                    }
                    else{
                        img_main_sub_lv.setImageResource(R.drawable.icon_level3)
                    }


                }
            }
        )
    }
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ic_mypage -> {
                val intent = Intent(applicationContext, MypageActivity::class.java)
                startActivity(intent)
            }
            R.id.layout_adv -> {
                val intent = Intent(applicationContext, QuestDetailActivity::class.java)
                startActivity(intent)
            }
        }
    }


}