package com.jcozy.trolly.ui.mypage

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jcozy.trolly.R
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import com.jcozy.trolly.network.responseData.TotalData

import kotlinx.android.synthetic.main.activity_mypage_ranking.*
import kotlinx.android.synthetic.main.item_ranking.*


class MypageRankingActivity : AppCompatActivity() {

    val service = RequestToServer.service
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    lateinit var rankingAdapter: MypageRankingAdapter

    //val myData = mutableListOf<RankingData>()
    val data = mutableListOf<TotalData>()
    //lateinit var totalData : TotalData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_ranking)

        setSupportActionBar(Toolbar)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.icon_before)
        Toolbar.title = "나의 랭킹"

        rankingAdapter = MypageRankingAdapter(this)
        rc_ranking.adapter = rankingAdapter

        loadRanking()
    }

    private fun loadRanking(){
        data.apply{
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2013/07/13/14/00/duck-billed-platypus-161908__340.png",
                    name = "오구"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2016/02/19/11/36/microphone-1209816__340.jpg",
                    name = "아롱다롱"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2013/11/03/08/05/cheers-204742__340.jpg",
                    name = "알파카"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2016/02/19/11/23/siberian-tiger-1209680__340.jpg",
                    name = "코카톤 내가 짱먹겠다"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2017/12/17/21/44/coffee-3025022__340.jpg",
                    name = "포스쩌는 라이언"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2016/09/02/23/05/pumpkin-1640560__340.png",
                    name = "불도저쑨"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2018/07/31/22/08/lion-3576045__340.jpg",
                    name = "Dandelion"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2020/11/02/13/15/reindeer-5706627__340.png",
                    name = "anna1986"
                )
            )
            add(
                TotalData(
                    profileImg = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSEhUTExMVFhUXGBoaFhgXFxcd" +
                            "HRsXFxcXGBgXGhcYHSggHR0lHRYXITEhJSkrLi4uGB8zODMtNygtLisBCgoKDg0OGxAQGy0lICYtLS01LS0tLy0tLS0tLS0" +
                            "tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS8tLf/AABEIAKUBMgMBEQACEQEDEQH/xAAbAAACAwEBAQAAAAAAAA" +
                            "AAAAAEBQIDBgABB//EAEUQAAECAwYDBQUGBAQEBwAAAAECEQADIQQFEjFBUSJhcRMygZGhBkJSscEUYnLR4fAjM4KSorLC8UNTk" +
                            "9IVFjSjs+Lj/8QAGwEAAQUBAQAAAAAAAAAAAAAABAABAgMFBgf/xAA8EQABAwIDBAoCAQQABAcAAAABAAIDBBESITEFQVFhEyJxgZG" +
                            "hscHR8DLh8QYUI0IkM1JTFRZDcoKSsv/aAAwDAQACEQMRAD8AUyEO0aDiAucZHiIACPvKz9kAk95qxTC8SG40RtRCIWhu9LUSnyST0STn" +
                            "lkNYuc9jfyKFjgfJ+Db9yY3TZ+JTuCkBxUFy7PkcgaHeAax7SBay6b+nadzXvc64tYWzGvLu804AgCwXV3KHtUxsiQ2ZDZszVHP5QVTU4" +
                            "fm4ZLC2xtR1PZkR62p32/e/+UCa/XrGq1jWiwGS4eeR00hfJmTqVICHVYaOCsSIgVMAJrd11KmAkkpAGLIvh3wsTViyWcscqPny1QxWZbtW3" +
                            "T7LGDFNcE6D5+FK8rrMlYDlSSKKwtWrpzIej9DyiyGcSA3GaGqqLonDDmCtBdMkWWSZ6+8QyB9f3p1gOZ3TSdG3RHQxtgjxFZS2WgzFlSi5Je" +
                            "saTGBjbBZE0nSPuUOtYiQaqTZVPE7KGRVqTESpgBRXMhBqRspyzESAnDRwVySxdiaABupcbD3c6UgOeMuIsF0WxaumpmPMhsTbdqOA71NSSQyi" +
                            "G1AfLZ/0hm0zQblTqtvPkYWRtw333zt8+nmq58x3c0avSCcI0XPtyIICd3TfQCgZmNOJISpRFAoVxUJKUku5IDcOgjK6IAkCy7B8cjmNeWkduvh" +
                            "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",
                    name = "포뇨"
                )
            )
            add(
                TotalData(
                    profileImg = "https://cdn.pixabay.com/photo/2017/10/10/16/33/shaman-2837843__340.jpg",
                    name = "크크"
                )
            )
        }


        /*val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestRanking(header).customEnqueue(
            onError = { Toast.makeText(this,"올바르지 않은 요청입니다.", Toast.LENGTH_SHORT)},
            onSuccess = {
                tv_mypage_ranking_name.text = it.data.myName + " 님은"
                tv_mypage_ranking.text = it.data.myRank.toString() +"위"
                Glide.with(this).load(it.data.myImage).into(iv_mypage_ranking_profile)

            }
        )*/

        /*service.requestRanking(header).customEnqueue(
            onError = { Toast.makeText(this,"올바르지 않은 요청입니다.", Toast.LENGTH_SHORT)},
            onSuccess = {
                data.clear()
                data.addAll(it.data.top10)
                rankingAdapter.data = data
                rankingAdapter.notifyDataSetChanged()
            }
        )*/
        rankingAdapter.data = data
        rankingAdapter.notifyDataSetChanged()

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