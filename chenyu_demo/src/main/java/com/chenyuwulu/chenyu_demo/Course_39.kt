package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.course_39.*

class Course_39 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_39)
        title = "快速实现引导页"
        val mPageList = ArrayList<View>()
        val inflater = layoutInflater
        mPageList.add(inflater.inflate(R.layout.course_39_pager1,null,false))
        mPageList.add(inflater.inflate(R.layout.course_39_pager2,null,false))
        mPageList.add(inflater.inflate(R.layout.course_39_pager3,null,false))
        val mAdapter = Course_39_ViewPagerAdapter(mPageList)
        this.view_pager.adapter = mAdapter
        this.view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageSelected(p0: Int) {
                Toast.makeText(
                    this@Course_39, "第" + (p0 + 1) + "页",
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