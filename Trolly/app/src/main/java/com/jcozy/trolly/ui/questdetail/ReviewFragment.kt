package com.jcozy.trolly.ui.questdetail

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jcozy.trolly.R
import com.jcozy.trolly.network.RequestToServer
import com.jcozy.trolly.network.customEnqueue
import com.jcozy.trolly.network.responseData.MainTimeAttackData
import com.jcozy.trolly.network.responseData.QuestDetailReviewData
import kotlinx.android.synthetic.main.fragment_review.view.*

class ReviewFragment : Fragment() {

    val service = RequestToServer.service
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    val data = mutableListOf<QuestDetailReviewData>()

    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_review, container, false)

        sharedPref = context!!.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)
        editor = sharedPref.edit()

        intiView(view)
        return view
    }

    fun intiView(view: View){
        reviewAdapter =
            ReviewAdapter(view.context)
        view.rv_review.adapter = reviewAdapter
        loadReviewDatas()

    }

    private fun loadReviewDatas() {

        val header = mutableMapOf<String, String>()
        header["Content-Type"] = "application/json"
        header["TOKEN"] = sharedPref.getString("token", "token").toString()
        service.requestQuestDetailReview(header, "5ff92d4edec2631b41afff52").customEnqueue(
            onError = { Toast.makeText(context!!,"올바르지 않은 요청입니다.", Toast.LENGTH_SHORT)},
            onSuccess = {
                Log.d("모야?",it.message)
                Log.d("모야?2",it.data.toString())
                data.clear()
                data.addAll(it.data)
                reviewAdapter.datas = data
                reviewAdapter.notifyDataSetChanged()
            }
        )
        reviewAdapter.datas = data
        reviewAdapter.notifyDataSetChanged()
    }
}