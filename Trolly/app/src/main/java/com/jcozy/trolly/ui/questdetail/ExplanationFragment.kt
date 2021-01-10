package com.jcozy.trolly.ui.questdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jcozy.trolly.R
import kotlinx.android.synthetic.main.fragment_explanation.*

class ExplanationFragment : Fragment() {

//    lateinit var title: String
//    lateinit var how_to: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explanation, container, false)

        val extra = arguments
        val title = extra!!.getString("intro_title").toString()
        Log.d("title", title)
        val how_to = (extra!!.getString("explaination")).toString()

        tv_intro1.text = title
        tv_explaination.text = how_to

    }

    override fun onResume() {
        super.onResume()
    }

}