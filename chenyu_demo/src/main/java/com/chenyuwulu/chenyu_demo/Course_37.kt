package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_37.*

class Course_37 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_37)
        title = "选项卡"
        val mTabHost = this.mytabhost
        mTabHost.setup()
        val tab1 = mTabHost.newTabSpec("0")
        tab1.setIndicator("红色")
        tab1.setContent(R.id.widget_layout_red)
        mTabHost.addTab(tab1)
        mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator("绿色").setContent(R.id.widget_layout_green))
        mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator("蓝色").setContent(R.id.widget_layout_blue))
    }
}