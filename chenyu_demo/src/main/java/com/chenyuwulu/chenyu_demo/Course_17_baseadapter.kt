package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


//优化前
//class Course_17_baseadapter(private val mContext: Context, private val mDatas: List<Course_17_baseadapter_data>, private val mResId: Int) : BaseAdapter() {
//
//    // 获得列表项的数量
//    override fun getCount(): Int {
//        return mDatas.size
//    }
//
//    // 获得当前列表项
//    override fun getItem(position: Int): Course_17_baseadapter_data? {
//        return mDatas[position]
//    }
//
//    // 获得当前列表项的ID
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    // 获得第position处的列表项组件
//    @SuppressLint("ViewHolder")
//    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
//        // 获取LayoutInflater对象
//        val inflater = LayoutInflater.from(mContext)
//        // 装载列表项视图
//        val itemView = inflater.inflate(mResId, null)
//
//        // 获取列表项组件
//        val iconImg = itemView.findViewById(R.id.icon_img) as ImageView
//        val titleTv = itemView.findViewById(R.id.title_tv) as TextView
//        val infoTv = itemView.findViewById(R.id.info_tv) as TextView
//
//        // 给列表项赋值
//        val data = getItem(position)
//        if (null != data) {
//            iconImg.setImageResource(data.icon)
//            titleTv.text = data.title
//            infoTv.text = data.info
//        }
//
//        return itemView
//    }
//}

//使用convertView优化
//class Course_17_baseadapter(context: Context, datas: List<Course_17_baseadapter_data>, resId: Int) :
//    BaseAdapter() {
//    private val mContext: Context = context// 上下文环境
//    private val mDatas: List<Course_17_baseadapter_data> = datas// 列表数据集合
//    private val mResId: Int = resId// 列表项布局文件ID
//
//    // 获得列表项的数量
//    override fun getCount(): Int {
//        return mDatas.size
//    }
//
//    // 获得当前列表项
//    override fun getItem(position: Int): Course_17_baseadapter_data {
//        return mDatas[position]
//    }
//
//    // 获得当前列表项的ID
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    // 获得第position处的列表项组件
//    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View? {
//        var convertView = convertView
//        if (null == convertView) {
//            // 获取LayoutInflater对象
//            val inflater = LayoutInflater.from(mContext)
//            // 装载列表项视图
//            convertView = inflater.inflate(mResId, null)
//        }
//
//        // 获取列表项组件
//        val iconImg = convertView!!.findViewById<View>(R.id.icon_img) as ImageView
//        val titleTv = convertView.findViewById<View>(R.id.title_tv) as TextView
//        val infoTv = convertView.findViewById<View>(R.id.info_tv) as TextView
//
//        // 给列表项赋值
//        val data: Course_17_baseadapter_data = getItem(position)
//        iconImg.setImageResource(data.icon)
//        titleTv.text = data.title
//        infoTv.text = data.info
//        return convertView
//    }
//
//}






//使用持有者模式优化
class Course_17_baseadapter(context: Context, datas: List<Course_17_baseadapter_data>, resId: Int) :
    BaseAdapter() {
    private val mContext: Context = context// 上下文环境
    private val mDatas: List<Course_17_baseadapter_data> = datas// 列表数据集合
    private val mResId: Int = resId// 列表项布局文件ID

    // 获得列表项的数量
    override fun getCount(): Int {
        return mDatas.size
    }

    // 获得当前列表项
    override fun getItem(position: Int): Course_17_baseadapter_data {
        return mDatas[position]
    }

    // 获得当前列表项的ID
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 获得第position处的列表项组件
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var convertView: View? = convertView
        var holder: ViewHolder? = null
        if (null == convertView) {
            // 获取LayoutInflater对象
            val inflater = LayoutInflater.from(mContext)
            // 装载列表项视图
            convertView = inflater.inflate(mResId, null)

            // 新建持有者ViewHolder
            holder = ViewHolder()
            // 获取列表项组件
            holder.iconImg = convertView.findViewById(R.id.icon_img) as ImageView
            holder.titleTv = convertView.findViewById(R.id.title_tv)
            holder.infoTv = convertView.findViewById(R.id.info_tv)

            // 将ViewHolder对象存储到convertView中
            convertView.tag = holder
        } else {
            // 从convertView取出ViewHolder对象
            holder = convertView.tag as ViewHolder?
        }

        // 给列表项组件设置内容
        val data: Course_17_baseadapter_data = getItem(position)
        holder?.iconImg?.setImageResource(data.icon)
        holder?.titleTv?.text = data.title
        holder?.infoTv?.text = data.info
        return convertView!!
    }

    // 持有者类
    private inner class ViewHolder {
        var iconImg: ImageView? = null// 图标
        var titleTv: TextView? = null// 标题
        var infoTv: TextView? = null// 内容
    }

}