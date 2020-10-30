package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_36.*

class Course_36 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_36)
        title = "搜索框"
        val mSearchView = this.searchView
        val mListView = this.listView
        val mDatas                = arrayOf("aaa", "bbb", "ccc", "airsaid")
        mListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mDatas)
        mListView.isTextFilterEnabled = true

        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                if (!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText)
                }else{
                    mListView.clearTextFilter()
                }
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

        })
    }
}