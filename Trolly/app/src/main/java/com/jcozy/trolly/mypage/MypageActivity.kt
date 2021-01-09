package com.jcozy.trolly.mypage

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.R
import com.jcozy.trolly.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_mypage.*

class MypageActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}