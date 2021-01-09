package com.jcozy.trolly.ui.timeattack

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.R
import com.jcozy.trolly.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_time_attack.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class TimeAttackActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_attack)


        setSupportActionBar(tb_timeattack)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_before)

        tb_timeattack.elevation = 5F
        view_realtime_participants.setOnClickListener(this)

//        tv_timer.text = countdownText

        //서버에서 보내주는 카운트다운
        //val leftSeconds = //종료시간 - 현재시간

        val countDownTimer = object : CountDownTimer(360000, 1000){
            override fun onTick(p0: Long) {
                tv_timer.text = getTime()
            }

            override fun onFinish() {
                tv_timer.text = "종료"
            }
        }
        countDownTimer.start()



    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.view_realtime_participants -> {
                val intent = Intent(applicationContext, TimeAttackPartiActivity::class.java)
                startActivity(intent)
            }
        }
    }




    fun getTime() : String {

        val date = Date()
        val calendar : Calendar = GregorianCalendar()
        calendar.time = date

        val cur_hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val cur_minute = calendar.get(Calendar.MINUTE)
        val cur_second = calendar.get(Calendar.SECOND)

        /*서버에서 종료시간 받아오기.*/
//        val test_time = "2021-01-10T20:00:00.000Z"
        val test_time = "2021-01-10T03:49:50.000Z"
        val test_end_hour = test_time.substring(11,13).toInt()
        val test_end_min = test_time.substring(14,16).toInt()
        val test_end_sec = test_time.substring(17,19).toInt()

        val end_millis = (test_end_hour * 3600 + test_end_min * 60 + test_end_sec)
        val cur_millis = (cur_hour * 3600 + cur_minute * 60 + cur_second)

        val diff = end_millis - cur_millis
        val hour = Math.floor((diff/3600).toDouble()).toInt()
        val min = (Math.floor((diff - (hour * 3600))/60.toDouble()).toInt())
        val sec = (Math.floor((diff - (hour * 3600) - (min * 60)).toDouble())).toInt()

        val test_countdownText : String = String.format("%02d : %02d : %02d", hour, min, sec)

        return test_countdownText
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