package com.jcozy.trolly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_review.*
import kotlinx.android.synthetic.main.fragment_review.view.*

class ReviewFragment : Fragment() {

    private lateinit var reviewAdapter: ReviewAdapter
    private val reviewData = mutableListOf<ReviewData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_review, container, false)

        intiView(view)
        return view
    }

    fun intiView(view: View){
        reviewAdapter = ReviewAdapter(view.context)
        view.rv_review.adapter = reviewAdapter
        loadReviewDatas()

    }

    private fun loadReviewDatas() {
        reviewData.apply {
            add (ReviewData(img = "https://images.unsplash.com/photo-1570515137767-8ac25a5b10fa?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1821&q=80"))
            add (ReviewData(img = "https://images.unsplash.com/photo-1571645639045-a3d43f4cafc5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=658&q=80"))
            add (ReviewData(img = "https://images.unsplash.com/photo-1595737335975-2160c924caf2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"))
            add (ReviewData(img = "https://images.unsplash.com/photo-1599025847646-58d2a1808824?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1189&q=80"))
            add (ReviewData(img = "https://images.unsplash.com/photo-1562601579-599dec564e06?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"))
        }
        reviewAdapter.datas = reviewData
        reviewAdapter.notifyDataSetChanged()
    }
}