package com.chenyuwulu.ViewComic

import android.annotation.SuppressLint
import android.content.Context
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class RecyclerViewAdapter_apply(context: Context, datas: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter_apply.ViewHolder>() {
    private var mDatas: ArrayList<String>? = datas
    private var mInflater: LayoutInflater? = null
    private var mOnItemClickListener: OnItemClickListener? = null
    private var mOnItemLongClickListener: OnItemLongClickListener? = null

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    // 创建新View，被LayoutManager所调用
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater!!.inflate(R.layout.we_sub_recyclerview_apply_item, parent, false)
        return ViewHolder(view)
    }

    // 将数据与界面进行绑定的操作
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val name = mDatas!![position]
        holder.titleTv!!.text = "Title $name"
        holder.contenTv!!.text = "content $name"

        // 点击事件注册及分发
        if (null != mOnItemClickListener) {
            holder.titleTv!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    mOnItemClickListener!!.onClick(holder.titleTv, position)
                }
            })
            holder.contenTv!!.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    mOnItemClickListener!!.onClick(holder.contenTv, position)
                }
            })
        }
        // 长按事件注册及分发
        if (null != mOnItemLongClickListener) {
            holder.titleTv!!.setOnLongClickListener(object : View.OnLongClickListener {
                override fun onLongClick(v: View): Boolean {
                    return mOnItemLongClickListener!!.onLongClick(holder.titleTv, position)
                }
            })
            holder.contenTv!!.setOnLongClickListener(object : View.OnLongClickListener {
                override fun onLongClick(v: View): Boolean {
                    return mOnItemLongClickListener!!.onLongClick(holder.contenTv, position)
                }
            })
        }
    }

    // 获取数据的数量
    override fun getItemCount(): Int {
        return mDatas?.size ?: 0
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

        if(position != itemCount) {
            notifyItemRangeChanged(position, itemCount)
        }

    }

    // 删除对应item
    fun removeData(position: Int) {
        mDatas!!.removeAt(position)
        notifyItemRemoved(position)
        if(position != itemCount) {
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
}