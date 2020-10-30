package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.course_38.*

class Course_38 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_38)
        title = "回收视图"
        val mRecyclerView = this.recyclerview
        // 设置管理器
        val layoutManager = GridLayoutManager(this, 3)
        mRecyclerView.layoutManager = layoutManager
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true)

//                var mAdapter: RecyclerViewAdapter? = null
        val mDatas = ArrayList<String>()

        for (i in 0..60) {
            mDatas.add(i, (i + 1).toString())
        }
        val mAdapter = Course_38_RecyclerViewAdapter(this, mDatas)
        mRecyclerView.adapter = mAdapter

        var pailie = 1
        this.recyclerview_hengxiang.setOnClickListener {
            if(pailie ==1){
                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                pailie =2
            } else{
                layoutManager.orientation = LinearLayoutManager.VERTICAL
                pailie =1
            }

        }
    }
}