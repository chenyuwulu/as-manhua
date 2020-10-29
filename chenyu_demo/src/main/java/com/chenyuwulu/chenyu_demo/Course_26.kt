package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import com.chenyuwulu.chenyu_demo.Course_26.ViewSwitchers.NUMBER_PER_SCREEN
import com.chenyuwulu.chenyu_demo.Course_26.ViewSwitchers.screenCount

class Course_26 : AppCompatActivity() {
    // 保存系统所有应用程序的List集合
    private val mItemDatas = ArrayList<Course_26_ViewSwitcherItemData>()
    object ViewSwitchers {
        var screenNo = -1
        // 定义一个常量，用于显示每屏显示的应用程序数
        val NUMBER_PER_SCREEN = 12
        // 记录当前正在显示第几屏的程序

        // 保存程序所占的总屏数
        var screenCount: Int = 0
    }
    private var mAdapter: Course_26_ViewSwitcherBaseAdapter? = null
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_26)
        title = "视图切换"
        val mViewSwitcher = findViewById<ViewSwitcher>(R.id.viewSwitcher)
        val mPrevBtn = findViewById<Button>(R.id.prev_btn)
        val mNextBtn  = findViewById<Button>(R.id.next_btn)
        mViewSwitcher.setFactory {
            // 加载R.layout.slide_gridview组件，实际上就是一个GridView组件
            return@setFactory this.layoutInflater.inflate(R.layout.course_26_slide_gridview, null)
        }
        // 创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (i in 0..39) {
            val item = Course_26_ViewSwitcherItemData("item$i", R.drawable.bh3)
            mItemDatas.add(item)
        }
        // 计算应用程序所占的总屏数
        // 如果应用程序的数量能整除NUMBER_PER_SCREEN，除法的结果就是总屏数
        // 如果不能整除，总屏数应该是除法的结果再加1
        screenCount = if (mItemDatas.size % NUMBER_PER_SCREEN === 0)
            mItemDatas.size / NUMBER_PER_SCREEN
        else
            mItemDatas.size / NUMBER_PER_SCREEN + 1

        mAdapter = Course_26_ViewSwitcherBaseAdapter(this, mItemDatas)

        mPrevBtn.setOnClickListener {
            if (ViewSwitchers.screenNo > 0) {
                ViewSwitchers.screenNo--
                // 为ViewSwitcher的组件显示过程设置动画
                mViewSwitcher.setInAnimation(this, android.R.anim.slide_in_left)
                // 为ViewSwitcher的组件隐藏过程设置动画
                mViewSwitcher.setOutAnimation(this, android.R.anim.slide_out_right)
                // 控制下一屏将要显示的GridView对应的 Adapter
                (mViewSwitcher.nextView as GridView).adapter = mAdapter
                // 单击左边按钮，显示上一屏，当然可以采用手势
                // 学习手势检测后，也可通过手势检测实现显示上一屏
                mViewSwitcher.showPrevious()
            }

        }
        mNextBtn.setOnClickListener {
            if (ViewSwitchers.screenNo < screenCount - 1) {
                ViewSwitchers.screenNo++
                // 为ViewSwitcher的组件显示过程设置动画
                mViewSwitcher.setInAnimation(this, R.anim.slide_in_right)
                // 为ViewSwitcher的组件隐藏过程设置动画
                mViewSwitcher.setOutAnimation(this, R.anim.slide_out_left)
                // 控制下一屏将要显示的GridView对应的Adapter
                (mViewSwitcher.nextView as GridView).adapter = mAdapter
                // 单击右边按钮，显示下一屏
                // 学习手势检测后，也可通过手势检测实现显示下一屏
                mViewSwitcher.showNext()
            }
        }
        if (ViewSwitchers.screenNo < screenCount - 1) {
            ViewSwitchers.screenNo++
            // 为ViewSwitcher的组件显示过程设置动画
            mViewSwitcher.setInAnimation(this, R.anim.slide_in_right)
            // 为ViewSwitcher的组件隐藏过程设置动画
            mViewSwitcher.setOutAnimation(this, R.anim.slide_out_left)
            // 控制下一屏将要显示的GridView对应的Adapter
            (mViewSwitcher.nextView as GridView).adapter = mAdapter
            // 单击右边按钮，显示下一屏
            // 学习手势检测后，也可通过手势检测实现显示下一屏
            mViewSwitcher.showNext()
        }
    }
}
