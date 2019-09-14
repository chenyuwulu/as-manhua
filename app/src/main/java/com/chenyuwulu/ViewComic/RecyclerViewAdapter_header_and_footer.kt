package com.chenyuwulu.ViewComic

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class RecyclerViewAdapter_header_and_footer(context: Context, datas: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mDatas: ArrayList<String>? = null
    private var mInflater: LayoutInflater? = null
    private var mOnItemClickListener: OnItemClickListener? = null
    private var mOnItemLongClickListener: OnItemLongClickListener? = null

    //内容长度
    val contentItemCount: Int
        get() = mDatas?.size ?: 0

    init {
        this.mDatas = datas
        this.mInflater = LayoutInflater.from(context)
    }

    //判断当前item是否是HeadView
    fun isHeaderView(position: Int): Boolean {
        return 0 == position
    }

    //判断当前item是否是FooterView
    fun isBottomView(position: Int): Boolean {
        return position == contentItemCount + 1
    }

    //判断当前item类型
    override fun getItemViewType(position: Int): Int {
        return if (0 == position) {
            //头部View
            ITEM_TYPE_HEADER
        } else if (contentItemCount + 1 == position) {
            //底部View
            ITEM_TYPE_BOTTOM
        } else {
            //内容View
            ITEM_TYPE_CONTENT
        }
    }

    // 创建新View，被LayoutManager所调用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var vewHolder: RecyclerView.ViewHolder? = null
        var view: View? = null
        if (ITEM_TYPE_HEADER == viewType) {
            view = mInflater!!.inflate(R.layout.we_sub_recyclerview_header, parent, false)
            vewHolder = HeaderViewHolder(view)
        } else if (ITEM_TYPE_BOTTOM == viewType) {
            view = mInflater!!.inflate(R.layout.we_sub_recyclerview_footer, parent, false)
            vewHolder = FooterViewHolder(view)
        } else {
            view = mInflater!!.inflate(R.layout.we_sub_recyclerview_header_and_footer_item, parent, false)
            vewHolder = ViewHolder(view)
        }

        return vewHolder
    }

    // 将数据与界面进行绑定的操作
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        if (holder is HeaderViewHolder) {

        } else if (holder is FooterViewHolder) {

        } else {
            val viewHolder = holder as ViewHolder
            val name = mDatas!![position - 1]
            viewHolder.titleTv!!.text = "Title $name"
            viewHolder.contenTv!!.text = "content $name"

            // 点击事件注册及分发
            if (null != mOnItemClickListener) {
                viewHolder.titleTv!!.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        mOnItemClickListener!!.onClick(viewHolder.titleTv, position)
                    }
                })
                viewHolder.contenTv!!.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        mOnItemClickListener!!.onClick(viewHolder.contenTv, position)
                    }
                })
            }
            // 长按事件注册及分发
            if (null != mOnItemLongClickListener) {
                viewHolder.titleTv!!.setOnLongClickListener(object : View.OnLongClickListener {
                    override fun onLongClick(v: View): Boolean {
                        return mOnItemLongClickListener!!.onLongClick(viewHolder.titleTv, position)
                    }
                })
                viewHolder.contenTv!!.setOnLongClickListener(object : View.OnLongClickListener {
                    override fun onLongClick(v: View): Boolean {
                        return mOnItemLongClickListener!!.onLongClick(viewHolder.contenTv, position)
                    }
                })
            }
        }
    }

    // 获取数据的数量
    override fun getItemCount(): Int {
        return contentItemCount + 2
    }

    // 设置点击事件
    fun setOnItemClickListener(l: OnItemClickListener) {
        this.mOnItemClickListener = l
    }

    // 设置长按事件
    fun setOnItemLongClickListener(l: OnItemLongClickListener) {
        this.mOnItemLongClickListener = l
    }

    // 在对应位置增加一个item
    fun addData(position: Int) {
        mDatas!!.add(position, "Insert $position")
        notifyItemInserted(position)

        if (position != itemCount) {
            notifyItemRangeChanged(position, itemCount)
        }
    }

    // 删除对应item
    fun removeData(position: Int) {
        mDatas!!.removeAt(position)
        notifyItemRemoved(position)

        if (position != itemCount) {
            notifyItemRangeChanged(position, itemCount)
        }
    }

    // 点击事件接口
    interface OnItemClickListener {
        fun onClick(parent: View?, position: Int)
    }

    // 长按事件接口
    interface OnItemLongClickListener {
        fun onLongClick(parent: View?, position: Int): Boolean
    }

    // 自定义的ViewHolder，持有每个Item的的所有界面组件
    open inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTv: TextView? = null
        var contenTv: TextView? = null

        init {

            titleTv = itemView.findViewById(R.id.title_tv)
            contenTv = itemView.findViewById(R.id.content_tv)
        }
    }

    //头部 ViewHolder
    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //底部 ViewHolder
    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        //item类型
        val ITEM_TYPE_HEADER = 0
        val ITEM_TYPE_CONTENT = 1
        val ITEM_TYPE_BOTTOM = 2
    }
}