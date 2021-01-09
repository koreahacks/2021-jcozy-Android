package com.jcozy.trolly.ui.mypage

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.jcozy.trolly.R
import com.jcozy.trolly.network.responseData.RankingData
import kotlinx.android.synthetic.main.activity_mypage_ranking.*


class MypageRankingActivity : AppCompatActivity() {

    lateinit var rankingAdapter: MypageRankingAdapter

    val data = mutableListOf<RankingData>()

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
        data.apply {
            add(
                RankingData(
                   profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
            add(
                RankingData(
                    profile = "https://cdn.pixabay.com/photo/2015/04/23/21/59/tree-736877__340.jpg",
                    name = "오구",
                    ranking = 1
                )
            )
        }

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