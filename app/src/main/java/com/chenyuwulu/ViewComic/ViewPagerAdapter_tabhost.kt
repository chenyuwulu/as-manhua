package com.chenyuwulu.ViewComic


import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import android.view.View


class ViewPagerAdapter_tabhost(pageLists: ArrayList<View>, titleLists: ArrayList<String>) : PagerAdapter() {
    private var mPageLists: ArrayList<View>? = null
    private var mTitleLists: ArrayList<String>? = null

    init {
        this.mPageLists = pageLists
        this.mTitleLists = titleLists
    }

    override fun getCount(): Int {
        return mPageLists?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val pageView = mPageLists!![position]
        container.addView(pageView)
        return pageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // 将当前位置的View移除
        container.removeView(mPageLists!![position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (null == mTitleLists && position < mTitleLists!!.size)
            null
        else
            mTitleLists!![position]
    }
}