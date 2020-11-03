package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.course_38.*

class Course_38 : AppCompatActivity() {
    val mDatas = ArrayList<String>()//循环的数组
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_38)
        title = "回收视图"
        for (i in 0..99) {
            mDatas.add(i, (i + 1).toString())
        }
        // 设置管理器
        val layoutManager_RecyclerViewAdapter = GridLayoutManager(this, 2)
        this.recyclerview.layoutManager = layoutManager_RecyclerViewAdapter
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        this.recyclerview.setHasFixedSize(true)
        val mAdapter_RecyclerViewAdapter = Course_38_RecyclerViewAdapter(this, mDatas)
        this.recyclerview.adapter = mAdapter_RecyclerViewAdapter
        var pailie = 1
        this.recyclerview_hengshu.setOnClickListener {
            if(pailie ==1){
                layoutManager_RecyclerViewAdapter.orientation = LinearLayoutManager.HORIZONTAL
                pailie =2
            } else{
                layoutManager_RecyclerViewAdapter.orientation = LinearLayoutManager.VERTICAL
                pailie =1
            }
        }



        //包含分割线的列表

        this.recyclerview_divider.layoutManager = LinearLayoutManager(this)
        // 自定义分割线
        this.recyclerview_divider.addItemDecoration(Course_38_RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider))
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        this.recyclerview_divider.setHasFixedSize(true)
        //以下不用了，因为用了绑定点击事件
        this.recyclerview_divider.adapter = Course_38_RecyclerViewAdapter_divider(this, mDatas)



        //设置点击事件

        this.recyclerview_click.layoutManager = LinearLayoutManager(this)
        // 自定义分割线
        this.recyclerview_click.addItemDecoration(Course_38_RecyclerViewItemDivider(this, R.drawable.recyclerview_item_divider))
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        this.recyclerview_click.setHasFixedSize(true)
        val mAdapter_RecyclerViewAdapter_click = Course_38_RecyclerViewAdapter_click(this, mDatas)
        mAdapter_RecyclerViewAdapter_click.setOnItemClickListener(object :Course_38_RecyclerViewAdapter_click.OnItemClickListener {
            override fun onClick(parent: View?, position: Int) {
                Toast.makeText(this@Course_38, "点击了第" + (position + 1) + "项", Toast.LENGTH_SHORT).show()
            }
        })
        mAdapter_RecyclerViewAdapter_click.setOnItemLongClickListener(object :Course_38_RecyclerViewAdapter_click.OnItemLongClickListener{
            override fun onLongClick(parent: View?, position: Int): Boolean {
                Toast.makeText(this@Course_38, "长压了第" + (position + 1) + "项", Toast.LENGTH_SHORT).show()
                return true
            }
        })
        this.recyclerview_click.adapter = mAdapter_RecyclerViewAdapter_click


        //设置动态绑定数据

        this.recyclerview_apply.layoutManager = LinearLayoutManager(this)
        this.recyclerview_apply.addItemDecoration(Course_38_RecyclerViewItemDivider(this,R.drawable.recyclerview_item_divider))
        this.recyclerview_apply.setHasFixedSize(true)
        val mAdapter_RecyclerViewAdapter_apply = Course_38_RecyclerViewAdapter_apply(this,mDatas)
        mAdapter_RecyclerViewAdapter_apply.setOnItemClickListener(object :Course_38_RecyclerViewAdapter_apply.OnItemClickListener {
            override fun onClick(parent: View?, position: Int) {
                mAdapter_RecyclerViewAdapter_apply.addData(position + 1)
            }
        })
        mAdapter_RecyclerViewAdapter_apply.setOnItemLongClickListener(object :Course_38_RecyclerViewAdapter_apply.OnItemLongClickListener{
            override fun onLongClick(parent: View?, position: Int): Boolean {
                mAdapter_RecyclerViewAdapter_apply.removeData(position)
                return true
            }
        })
        this.recyclerview_apply.adapter = mAdapter_RecyclerViewAdapter_apply
        this.recyclerview_apply.itemAnimator = DefaultItemAnimator()
    }


}
