package com.jcozy.trolly.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.R

class MypageActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)


    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.view_mypage_level -> {
                val intent = Intent(applicationContext, MypageLevelActivity::class.java)
                startActivity(intent)
            }
            R.id.view_mypage_rank -> {
                val intent = Intent(applicationContext, MypageRankingActivity::class.java)
                startActivity(intent)
            }
            R.id.view_mypage_history -> {
                val intent = Intent(applicationContext, HistoryActivity::class.java )
                startActivity(intent)
            }
        }
    }
}