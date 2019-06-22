package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class RecyclerViewAdapter(context: Context, datas: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var mDatas: ArrayList<String>? = null
    private var mInflater: LayoutInflater? = null

    init {
        this.mDatas = datas
        this.mInflater = LayoutInflater.from(context)
    }

    // 创建新View，被LayoutManager所调用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater!!.inflate(R.layout.we_sub_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    // 将数据与界面进行绑定的操作
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = mDatas!![position]
        holder.titleTv!!.text = "Title $name"
        holder.contenTv!!.text = "content $name"
    }

    // 获取数据的数量
    override fun getItemCount(): Int {
        return mDatas?.size ?: 0
    }

    // 自定义的ViewHolder，持有每个Item的的所有界面组件
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTv: TextView? = null
        var contenTv: TextView? = null

        init {

            titleTv = itemView.findViewById(R.id.title_tv)
            contenTv = itemView.findViewById(R.id.content_tv)
        }
    }
}