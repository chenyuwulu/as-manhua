package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView

class Course_21_MyExpandableListViewAdapter(
    context: Context, groupList: List<String>,
    itemList: List<List<String>>
) : BaseExpandableListAdapter() {
    private var mContext: Context? = null
    private var mGroupList: List<String>? = null
    private var mItemList: List<List<String>>? = null

    init {
        this.mContext = context
        this.mGroupList = groupList
        this.mItemList = itemList
    }

    /**
     * 获取组的个数
     *
     * @return
     * @see android.widget.ExpandableListAdapter.getGroupCount
     */
    override fun getGroupCount(): Int {
        return mGroupList!!.size
    }

    /**
     * 获取指定组中的子元素个数
     *
     * @param groupPosition
     * @return
     * @see android.widget.ExpandableListAdapter.getChildrenCount
     */
    override fun getChildrenCount(groupPosition: Int): Int {
        return mItemList!![groupPosition].size
    }

    /**
     * 获取指定组中的数据
     *
     * @param groupPosition
     * @return
     * @see android.widget.ExpandableListAdapter.getGroup
     */
    override fun getGroup(groupPosition: Int): String {
        return mGroupList!![groupPosition]
    }

    /**
     * 获取指定组中的指定子元素数据。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     * @see android.widget.ExpandableListAdapter.getChild
     */
    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return mItemList!![groupPosition][childPosition]
    }

    /**
     * 获取指定组的ID，这个组ID必须是唯一的
     *
     * @param groupPosition
     * @return
     * @see android.widget.ExpandableListAdapter.getGroupId
     */
    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    /**
     * 获取指定组中的指定子元素ID
     *
     * @param groupPosition
     * @param childPosition
     * @return
     * @see android.widget.ExpandableListAdapter.getChildId
     */
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    /**
     * 获取显示指定组的视图对象
     *
     * @param groupPosition 组位置
     * @param isExpanded    该组是展开状态还是伸缩状态
     * @param convertView   重用已有的视图对象
     * @param parent        返回的视图对象始终依附于的视图组
     * @return
     * @see android.widget.ExpandableListAdapter.getGroupView
     */
    override fun getGroupView(
        groupPosition: Int, isExpanded: Boolean, convertView: View?,
        parent: ViewGroup
    ): View {
        var cts = convertView
        var groupHolder: GroupHolder?
        if (cts == null) {
            cts = LayoutInflater.from(mContext).inflate(R.layout.course_21_group, null)
            groupHolder = GroupHolder()
            groupHolder.groupNameTv = cts!!.findViewById(R.id.groupname_tv)
            groupHolder.groupImg = cts.findViewById(R.id.group_img) as ImageView
            cts.setTag(groupHolder)
        } else {
            groupHolder = cts.getTag() as GroupHolder?
        }

        if (isExpanded) {
            if (groupHolder != null) {
                groupHolder.groupImg!!.setImageResource(R.drawable.bh3_1)
            }
        } else {
            if (groupHolder != null) {
                groupHolder.groupImg!!.setImageResource(R.drawable.bh3_2)
            }
        }
        if (groupHolder != null) {
            groupHolder.groupNameTv!!.text = mGroupList!![groupPosition]
        }

        return cts
    }

    /**
     * 获取一个视图对象，显示指定组中的指定子元素数据。
     *
     * @param groupPosition 组位置
     * @param childPosition 子元素位置
     * @param isLastChild   子元素是否处于组中的最后一个
     * @param convertView   重用已有的视图(View)对象
     * @param parent        返回的视图(View)对象始终依附于的视图组
     * @return
     * @see android.widget.ExpandableListAdapter.getChildView
     */
    override fun getChildView(
        groupPosition: Int, childPosition: Int, isLastChild: Boolean,
        convertView: View?, parent: ViewGroup
    ): View {
        var cts = convertView
        val itemHolder: ItemHolder?
        if (cts == null) {
            cts = LayoutInflater.from(mContext).inflate(R.layout.course_21_item, null)
            itemHolder = ItemHolder()
            itemHolder.nameTv = cts!!.findViewById(R.id.itemname_tv)
            itemHolder.iconImg = cts.findViewById(R.id.icon_img) as ImageView
            cts.setTag(itemHolder)
        } else {
            itemHolder = cts.getTag() as ItemHolder?
        }
        if (itemHolder != null) {
            itemHolder.nameTv!!.text = mItemList!![groupPosition][childPosition]
        }
        if (itemHolder != null) {
            itemHolder.iconImg!!.setBackgroundResource(R.drawable.bh3_3)
        }

        return cts
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     *
     * @return
     * @see android.widget.ExpandableListAdapter.hasStableIds
     */
    override fun hasStableIds(): Boolean {
        return true
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param groupPosition
     * @param childPosition
     * @return
     * @see android.widget.ExpandableListAdapter.isChildSelectable
     */
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }


    internal inner class GroupHolder {
        var groupNameTv: TextView? = null
        var groupImg: ImageView? = null
    }

    internal inner class ItemHolder {
        var iconImg: ImageView? = null
        var nameTv: TextView? = null
    }
}