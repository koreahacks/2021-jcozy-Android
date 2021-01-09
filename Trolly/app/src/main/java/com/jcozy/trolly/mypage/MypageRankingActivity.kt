package com.jcozy.trolly.mypage

import android.content.Intent
import android.os.Bundle
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

        ic_mypage_before.setOnClickListener {
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
            finish()
        }

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
}