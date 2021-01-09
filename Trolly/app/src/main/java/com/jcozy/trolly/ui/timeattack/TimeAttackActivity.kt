package com.jcozy.trolly.ui.timeattack

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.jcozy.trolly.CustomDialog
import com.jcozy.trolly.R
import kotlinx.android.synthetic.main.activity_time_attack.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class TimeAttackActivity : AppCompatActivity(), View.OnClickListener {

    val IMAGE_FROM_GALLERY = 0
    val IMAGE_FROM_CAMERA = 1
    lateinit var selectedImg : Uri
    lateinit var imageFilePath: String

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
//        val leftSeconds = //종료시간 - 현재시간
//        val countDownTimer = object : CountDownTimer(leftSeconds, 1000){
//            override fun onTick(p0: Long) {
//                tv_timer.text = getTime()
//            }
//
//            override fun onFinish() {
//                tv_timer.text = "종료"
//            }
//        }





    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.view_realtime_participants -> {
                val intent = Intent(applicationContext, TimeAttackPartiActivity::class.java)
                startActivity(intent)
            }
            /*R.id.btn_timeattack_challenge ->{
                val customDialog = CustomDialog(this)
                customDialog.setOnOKClickedListener {
                    if(it){
                        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        if (intent.resolveActivity(packageManager) != null) {
                            var photoFile: File? = null
                            try {
                                photoFile = createImageFile()
                            } catch (ex: IOException) {
                                // Error occurred while creating the File
                            }
                            if (photoFile != null) {
                                selectedImg = FileProvider.getUriForFile(this, packageName, photoFile)
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, selectedImg)
                                startActivityForResult(intent,IMAGE_FROM_CAMERA)
                            }
                        }
                    }
                    else{
                        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                        startActivityForResult(intent,IMAGE_FROM_GALLERY)
                    }
                }
                customDialog.start()
            }*/
            }
        }


    fun getTime() : String {

        val date = Date()
        val calendar : Calendar = GregorianCalendar()
        calendar.time = date
        /*val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)*/
        val cur_hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val cur_minute = calendar.get(Calendar.MINUTE)
        val cur_second = calendar.get(Calendar.SECOND)

        val curTime = System.currentTimeMillis()
        val simpleTimeFormat : SimpleDateFormat = SimpleDateFormat("hh:mm:ss")
        val str = simpleTimeFormat.format(Date(curTime))


        /*서버에서 종료시간 받아오기.*/
        val end_hour = calendar.get(Calendar.HOUR_OF_DAY)
        val end_minute = calendar.get(Calendar.MINUTE)
        val end_second = calendar.get(Calendar.SECOND)
        

        val startTime = GregorianCalendar(cur_hour,cur_minute,cur_second)
        val endTime = GregorianCalendar(end_hour, end_minute, end_second)

//        val diff_sec : long = System.currentTimeMillis()
//        val hour = Math.floor((diffSec/3600))
//        val min = Math.floor()




        val countdownText : String = String.format("%02d : %02d : %02d", TimeUnit.MILLISECONDS.toHours(60), TimeUnit.MILLISECONDS.toMinutes(60) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(60)), TimeUnit.MILLISECONDS.toSeconds(60) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(60)))


        return countdownText
    }


}