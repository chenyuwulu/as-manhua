package com.chenyuwulu.ViewComic

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast



class MyButton(context: Context, attrs: AttributeSet) : Button(context, attrs) {

    // 重写 onTouchEvent触碰事件的回调方法
   override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)
        // 消息提示
        Toast.makeText(getContext(), "MyButton回调onTouchEvent方法", Toast.LENGTH_SHORT).show()

        // 返回true，表明该事件不会向外扩散
        return true
    }
}