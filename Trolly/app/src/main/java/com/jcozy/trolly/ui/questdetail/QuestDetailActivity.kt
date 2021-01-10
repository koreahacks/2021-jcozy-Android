package com.jcozy.trolly.ui.questdetail

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.jcozy.trolly.CustomDialog
import com.jcozy.trolly.R
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import com.jcozy.trolly.network.responseData.QuestDetailData
import kotlinx.android.synthetic.main.activity_quest_detail.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class QuestDetailActivity : AppCompatActivity() {

    val IMAGE_FROM_GALLERY = 0
    val IMAGE_FROM_CAMERA = 1
    lateinit var selectedImg : Uri
    lateinit var imageFilePath: String
    val service = RequestToServer.service
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var QuestDetailData : QuestDetailData
    lateinit var title : String
    lateinit var explanation : String
    val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest_detail)

        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.iconbefore)
        supportActionBar!!.setDisplayShowCustomEnabled(true)  // custom하기 위해
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)   // 뒤로가기 버튼
        toolbar.elevation = 0F

//        title = ""
//        explanation = ""
        tablayout.addTab(tablayout.newTab().setText("설명"),0)
        tablayout.addTab(tablayout.newTab().setText("후기"),1)

        sharedPref = this.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        editor = sharedPref.edit()
        initView()

        bundle.putString("title", title)
        bundle.putString("how_to", explanation)
        ExplanationFragment().arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.tab_viewpager, ExplanationFragment()).commit()

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


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && checkSelfPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Log.d("권한", "권한 설정 완료")
            } else {
                Log.d("권한", "권한 설정 요청")
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    1
                )
            }
        }


        button_confirm.setOnClickListener {
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
        }
        Log.d("밖", title)
    }

    private fun initView(){
        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        val token = sharedPref.getString("token","token").toString()
        header["TOKEN"] = token
        service.requestQuestDetail(header,"5ff931e1a1c0110964b74d7c").customEnqueue(
            onError = { Toast.makeText(this, "올바르지 않은 요청입니다.", Toast.LENGTH_SHORT) },
            onSuccess = {
                Log.d("뭔데",it.message)
                tv_title.text = it.data.title
                tv_way.text = it.data.how_to
                Glide.with(this).load(it.data.image).into(iv_main)
                title = it.data.title
                explanation = it.data.description
//                Log.d("안",title)
            }
        )
//        Log.d("안2",title)
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "confirmation_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",  /* suffix */
            storageDir /* directory */
        )
        imageFilePath = image.absolutePath
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==RESULT_OK) {
            when (requestCode) {
                IMAGE_FROM_CAMERA -> {
                    val bitmap = data?.extras?.get("data")
                    Glide.with(this).load(selectedImg).into(iv_main)
                }
                IMAGE_FROM_GALLERY -> {
                    selectedImg = data!!.data!!
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImg)
                    Log.d("링크", selectedImg.toString())
                    val intent = Intent(this, ChallengeActivity::class.java)
                    //intent.putExtra("imgUri", selectedImg.toString())
                    intent.data = selectedImg
                    startActivity(intent)
                }
            }
        }
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