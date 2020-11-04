package com.chenyuwulu.chenyu_demo

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class Course_39_ViewPagerAdapter(pageList: ArrayList<View>) : PagerAdapter() {
    private var mPageList: ArrayList<View>? = null

    init {
        this.mPageList = pageList
    }

    override fun getCount(): Int {
        return mPageList!!.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val pageView = mPageList!![position]
        container.addView(pageView)
        return pageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // 将当前位置的View移除
        container.removeView(mPageList!![position])
    }
}