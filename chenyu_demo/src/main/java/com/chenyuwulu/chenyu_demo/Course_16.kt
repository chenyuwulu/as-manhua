package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_16.*


class Course_16 : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_16)
        title = "Android事件展示"

        this.button.setOnClickListener {
            Toast.makeText(this, "收到了点击事件", Toast.LENGTH_SHORT).show()
        }
        this.button1.setOnClickListener(BtnClickListener)
        this.mybutton.setOnTouchListener(OnTouchListener { _, _ ->
            Toast.makeText(
                this,
                "Activity收到onTouch事件监听", Toast.LENGTH_SHORT
            ).show()
            // 返回false，表明该事件会继续向外扩散
            false
        })
        // 获取系统的Configuration对象
        val cfg = resources.configuration

        // 获取系统的配置信息
        val status = StringBuffer()
        status.append("屏幕密度：" + cfg.densityDpi + "\n")
        status.append("字体缩放因子：" + cfg.fontScale + "\n")
        status.append("硬键盘是否可见：" + cfg.hardKeyboardHidden + "\n")
        status.append("键盘类型：" + cfg.keyboard + "\n")
        status.append("当前键盘是否可用：" + cfg.keyboardHidden + "\n")
        status.append("语言环境：" + cfg.locale + "\n")
        status.append("移动信号的国家码：" + cfg.mcc + "\n")
        status.append("移动信号的网络码：" + cfg.mnc + "\n")
        status.append("方向导航设备的类型：" + cfg.navigation + "\n")
        status.append("方向导航设备是否可用：" + cfg.navigationHidden + "\n")
        status.append("系统屏幕的方向：" + cfg.orientation + "\n")
        status.append("屏幕可用高：" + cfg.screenHeightDp + "\n")
        status.append("屏幕可用宽：" + cfg.screenWidthDp + "\n")
        status.append("系统触摸屏的触摸方式：" + cfg.touchscreen + "\n")
        status.append("screenLayout：" + cfg.screenLayout + "\n")
        status.append("smallestScreenWidthDp：" + cfg.smallestScreenWidthDp + "\n")
        status.append("uiMode：" + cfg.uiMode + "\n")

        // 配置信息输出
        this.configuration_tv.text = status.toString()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        // 消息提示
        Toast.makeText(
            this,
            "Activity回调onTouchEvent方法", Toast.LENGTH_SHORT
        ).show()
        // 返回false，表明未完成处理该事件，该事件会继续向外扩散
        return true
    }
    private val BtnClickListener = View.OnClickListener {
        Toast.makeText(this, "外部私有", Toast.LENGTH_SHORT).show()
    }
    fun clickHandler(source: View?) {
        // 实现事件处理
        Toast.makeText(this, "直接绑定方法", Toast.LENGTH_SHORT).show()
    }



}