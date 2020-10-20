package com.chenyuwulu.chenyu_demo

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Toast

class Course_16_MyButton(context: Context?, attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatButton(context!!, attrs) {
    // 重写 onTouchEvent触碰事件的回调方法
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        // 消息提示
        Toast.makeText(context, "MyButton回调onTouchEvent方法", Toast.LENGTH_SHORT).show()

        // 返回true，表明该事件不会向外扩散
        return true
    }
}