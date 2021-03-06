package com.jcozy.trolly

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(context: Context,private val first_left : Int, private val left : Int, private val right: Int, private val bottom: Int) : RecyclerView.ItemDecoration() {

    var r_size = dpToPx(context, right)
    var b_size = dpToPx(context, bottom)
    var fl_size = dpToPx(context, first_left)
    var l_size = dpToPx(context, left)
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if(parent.getChildAdapterPosition(view) == 0)
            outRect.left = fl_size
        if (parent.getChildAdapterPosition(view) != parent.adapter!!.itemCount - 1) {
            outRect.right = r_size
        }
        if(parent.getChildAdapterPosition(view) == parent.adapter!!.itemCount - 1) {
            outRect.left = l_size
        }
        outRect.bottom = b_size
    }

    private fun dpToPx(context: Context, dp:Int):Int{
        return return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            context.resources.displayMetrics).toInt()
    }
}