package com.chenyuwulu.chenyu_demo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.course_40.*

class Course_40 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_40)
        title = "ViewPager实现TabHost"
        val mPageList = ArrayList<View>()
        val inflater = layoutInflater
        mPageList.add(inflater.inflate(R.layout.course_39_pager1,null,false))
        mPageList.add(inflater.inflate(R.layout.course_39_pager2,null,false))
        mPageList.add(inflater.inflate(R.layout.course_39_pager3,null,false))
        val mTitleLists = ArrayList<String>()
        mTitleLists.add("第一项")
        mTitleLists.add("第二项")
        mTitleLists.add("第三项")

        val mAdapter = Course_40_ViewPagerAdapter_tabhost(mPageList,mTitleLists)
        this.view_pager_tabhost.adapter = mAdapter

        this.view_pager_tabstrip.tabIndicatorColor = Color.BLUE
        this.view_pager_tabhost.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageSelected(p0: Int) {
                Toast.makeText(
                    this@Course_40, "第" + (p0 + 1) + "页",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageScrollStateChanged(p0: Int) {

            }

        })
    }
}