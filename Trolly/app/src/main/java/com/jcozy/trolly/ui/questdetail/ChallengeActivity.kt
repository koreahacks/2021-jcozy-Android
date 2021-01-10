package com.jcozy.trolly.ui.questdetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import kotlinx.android.synthetic.main.activity_challenge.*
import kotlinx.android.synthetic.main.activity_mypage_ranking.Toolbar
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class ChallengeActivity : AppCompatActivity() {

    lateinit var selectedImg : Uri
    val service = RequestToServer.service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge)

        setSupportActionBar(Toolbar)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_before)

        selectedImg = intent.data!!
        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImg)
        Glide.with(this).load(bitmap).into(iv_img)
        val c = this.contentResolver.query(Uri.parse(selectedImg.toString()), null, null, null, null)
        c!!.moveToNext()
        val absolutePath = c!!.getString(c!!.getColumnIndex(MediaStore.MediaColumns.DATA))
        val file = File(absolutePath)


        btn_challenge.setOnClickListener {
            Log.d("ddd","dfsdfsdf")
            val header = mutableMapOf<String, String?>()
            val sharedPref = this.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
            header["token"] = sharedPref.getString("token", "token")
            val rqFile = RequestBody.create(MediaType.parse("image/jpeg"), file)
            var photo : MultipartBody.Part = MultipartBody.Part.createFormData("profile", file.getName(), rqFile)
            service.requestQuestDetailReviewUpload(header,photo,"5ff92d4edec2631b41afff52").customEnqueue(
                onError = { Log.d("error >>>> ", "통신에러")},
                onSuccess = {
                    if (it.success){
                        Log.d("성공", it.message + " / ")
                    }else{
                        Log.d("status >>>> ", it.success.toString() + " / " + it.status.toString() + " / " + it.message)
                    }
                }
            )
            val intent = Intent(this, CompletionActivity::class.java)
            startActivity(intent)
            finish()
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