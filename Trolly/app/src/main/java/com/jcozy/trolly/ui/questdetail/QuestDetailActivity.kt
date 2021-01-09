package com.jcozy.trolly.ui.questdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.jcozy.trolly.CustomDialog
import com.jcozy.trolly.R
import kotlinx.android.synthetic.main.activity_quest_detail.*

class QuestDetailActivity : AppCompatActivity() {

    val IMAGE_FROM_GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_detail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.iconbefore)
        supportActionBar!!.setDisplayShowCustomEnabled(true)  // custom하기 위해
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)   // 뒤로가기 버튼
        toolbar.elevation = 0F

        tablayout.addTab(tablayout.newTab().setText("설명"),0)
        tablayout.addTab(tablayout.newTab().setText("후기"),1)

        val bundle = Bundle()
        ExplanationFragment().arguments = bundle
        supportFragmentManager.beginTransaction().add(
            R.id.tab_viewpager,
            ExplanationFragment()
        ).commit()

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var selected = when (tab!!.position) {
                    0 -> ExplanationFragment()
                    else -> ReviewFragment()
                }
                selected.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.tab_viewpager, selected).commit()
            }
        })

        initView()


        button_confirm.setOnClickListener {
            val customDialog = CustomDialog(this)
            customDialog.setOnOKClickedListener {
                if(it){
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(Intent.ACTION_PICK)
                    intent.type = MediaStore.Images.Media.CONTENT_TYPE
                    startActivity(intent)
                }
            }
            customDialog.start()
        }

    }

    fun initView(){
        Glide.with(this).load("https://cf.ltkcdn.net/dance/images/orig/218447-1999x1500-Modern-Jazz-dancer.jpg").into(iv_main)
    }
}