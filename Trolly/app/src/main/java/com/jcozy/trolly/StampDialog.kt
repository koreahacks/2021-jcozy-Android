package com.jcozy.trolly

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.ImageButton
import kotlinx.android.synthetic.main.popup_stamp.*

class StampDialog(context : Context){

    private val dlg = Dialog(context)
    private lateinit var btnX : ImageButton

    fun start(nickname: String, level: Int, main: Int, sub:Int) {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.popup_stamp)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //색 투명하게
        dlg.window?.setGravity(Gravity.CENTER)

        dlg.tv_nickname.text = nickname
        when(level){
            1 -> {
                dlg.iv_level.setImageResource(R.drawable.icon_level1)
                dlg.tv_sub.text = "$level/3"
                val remain = 5-main-sub
                dlg.tv_remain.text = "퀘스트 $remain" + "개만 더하면 레벨업!"
                dlg.iv_sub1.visibility = View.INVISIBLE
                dlg.iv_sub5.visibility = View.INVISIBLE
                when(sub){
                    1 -> {
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                    }
                    2 -> {
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                    }
                    3 -> {
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub4.setImageResource(R.drawable.icon_sub_q)
                    }
                }
            }
            2 -> {
                dlg.iv_level.setImageResource(R.drawable.icon_level2)
                dlg.tv_sub.text = "$level/4"
                val remain = 6-main-sub
                dlg.tv_remain.text = "퀘스트 $remain" + "개만 더하면 레벨업!"
                dlg.iv_sub5.visibility = View.INVISIBLE
                when(sub){
                    1 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                    }
                    2 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                    }
                    3 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                    }
                    4 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub4.setImageResource(R.drawable.icon_sub_q)
                    }
                }
            }
            3 -> { dlg.iv_level.setImageResource(R.drawable.icon_level3)
                dlg.tv_sub.text = "$level/5"
                val remain = 7-main-sub
                dlg.tv_remain.text = "퀘스트 $remain" + "개만 더하면 레벨업!"
                when(sub){
                    1 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                    }
                    2 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                    }
                    3 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                    }
                    4 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub4.setImageResource(R.drawable.icon_sub_q)
                    }
                    5 -> {
                        dlg.iv_sub1.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub2.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub3.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub4.setImageResource(R.drawable.icon_sub_q)
                        dlg.iv_sub5.setImageResource(R.drawable.icon_sub_q)
                    }
                }
            }
        }
        dlg.tv_level.text = "Level$level"
        dlg.tv_main.text = "$level/2"
        when(main){
            1-> dlg.iv_main1.setImageResource(R.drawable.icon_main)
            2-> {dlg.iv_main1.setImageResource(R.drawable.icon_main)
                dlg.iv_main2.setImageResource(R.drawable.icon_main)}
        }


        dlg.btn_x.setOnClickListener {
            dlg.dismiss()
        }

        dlg.show()
    }
}