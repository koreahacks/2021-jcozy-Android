package com.jcozy.trolly.timeattack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.R
import kotlinx.android.synthetic.main.activity_timeattack_parti.*

class TimeAttackPartiActivity : AppCompatActivity() {

    private lateinit var tapAdapter: TimeAttackPartiAdapter
    private val tapData = mutableListOf<TimeAttackPartiData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeattack_parti)

        initData()
    }

    fun initData(){
        tapAdapter = TimeAttackPartiAdapter(applicationContext, tapData)
        rv_timeattack_upload.adapter = tapAdapter
        loadUploadImg()
    }

    private fun loadUploadImg(){
        tapData.apply {
            add(TimeAttackPartiData(userprofile = "https://user-images.githubusercontent.com/23499504/104087113-c6e3e080-52a0-11eb-8d74-44214bb09b90.png", username = "귀염둥이 라이언", uploaded_img = "https://user-images.githubusercontent.com/23499504/104087181-2f32c200-52a1-11eb-90cd-08e68cdeeadd.jpg", uploaded_time = "방금 전"))
            add(TimeAttackPartiData(userprofile = "https://user-images.githubusercontent.com/23499504/104087113-c6e3e080-52a0-11eb-8d74-44214bb09b90.png", username = "게으른 튜브", uploaded_img = "https://user-images.githubusercontent.com/23499504/104087181-2f32c200-52a1-11eb-90cd-08e68cdeeadd.jpg", uploaded_time = "방금 전"))
        }
    }
}