package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Course_38_RecyclerViewItemDivider(context: Context, resId: Int) : RecyclerView.ItemDecoration() {
    private val mDrawable: Drawable = context.resources.getDrawable(resId)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + mDrawable.intrinsicHeight
            mDrawable.setBounds(left, top, right, bottom)
            mDrawable.draw(c)
        }
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(0, 0, 0, mDrawable.intrinsicWidth)
    }
}