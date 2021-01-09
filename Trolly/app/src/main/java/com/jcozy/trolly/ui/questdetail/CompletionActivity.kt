package com.jcozy.trolly.ui.questdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jcozy.trolly.R
import com.jcozy.trolly.StampDialog
import kotlinx.android.synthetic.main.activity_completion.*

class CompletionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completion)

        btn_x.setOnClickListener{
            finish()
        }

        btn_stamp.setOnClickListener {
            val stampDialog = StampDialog(this)
            stampDialog.start("몽블리", 2, 1, 3)
        }
    }
}