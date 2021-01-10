package com.jcozy.trolly.ui.mypage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import com.jcozy.trolly.network.responseData.MypageData
import kotlinx.android.synthetic.main.activity_mypage.*
import kotlinx.android.synthetic.main.activity_mypage_ranking.*

class MypageActivity : AppCompatActivity(), View.OnClickListener {

    val service = RequestToServer.service
    lateinit var sharedPref : SharedPreferences
//    val mydata = mutableListOf<MypageData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        sharedPref = applicationContext!!.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

        setSupportActionBar(tb_mypage)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_before)

        view_mypage_level.setOnClickListener(this)
        view_mypage_rank.setOnClickListener(this)
        view_mypage_history.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.view_mypage_level -> {
                val intent = Intent(this.applicationContext, MypageLevelActivity::class.java)
                startActivity(intent)
            }
            R.id.view_mypage_rank -> {
                val intent = Intent(this.applicationContext, MypageRankingActivity::class.java)
                startActivity(intent)
            }
            R.id.view_mypage_history -> {
                val intent = Intent(this.applicationContext, HistoryActivity::class.java )
                startActivity(intent)
            }
        }
    }

    private fun loadMypage(){
        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestMypage(header).customEnqueue(
            onError = { Toast.makeText(this, "올바르지 않은 요청입니다.", Toast.LENGTH_SHORT)},
            onSuccess = {

                    tv_mypage_username.text = it.data.name
                    tv_user_info.text = it.data.email
                    Glide.with(applicationContext).load(it.data.profileImg).into(iv_mypage_userprofile)
                    tv_mypage_mylevel.text = "LEVEL " +  it.data.level
                    if(it.data.level == 1){
                        tv_mypage_mylevel_detail.text = "트렌드 꿈나무"
                    }else if(it.data.level == 2){
                        tv_mypage_mylevel_detail.text = "준비된 열정 만수르"
                    }else if(it.data.level ==3){
                        tv_mypage_mylevel_detail.text = "당신은 트렌드를 이끌어가는 선구자"
                    }
                    tv_mypage_myrank.text = "" + it.data.ranking + "위"
                    if(it.data.ranking == 1){
                        tv_ranking_explain.text = "누구도 넘 볼 수 없는 거대한 벽이군요!"
                    }
            },onFail = {
                Log.e("TEST_HERE", "안 된다!!!!!")
            }
        )
    }

    override fun onResume() {
        super.onResume()

        loadMypage()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}