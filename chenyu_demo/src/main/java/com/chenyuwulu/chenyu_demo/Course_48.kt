package com.chenyuwulu.chenyu_demo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Course_48 :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_48)
        title = "Fragment"
        //这里不是用静态加载，直接使用动态加载

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val firstFragment = Course_48_FirstFragment()
        fragmentTransaction.add(R.id.fragment_play,firstFragment)
        fragmentTransaction.commit()





//        val mAddBtn = findViewById<Button>(R.id.add_btn)
//        val mRemoveBtn  = findViewById<Button>(R.id.remove_btn)
//        val mReplaceBtn  = findViewById<Button>(R.id.replace_btn)
//        val mSecondFragment = Course_48_add_delete_second()
//        val mThirdFragment = Course_48_add_delete_third()
//        mAddBtn.setOnClickListener {
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            // 向容器内加入Fragment
//            if (!mSecondFragment.isAdded) {
//                fragmentTransaction.add(R.id.fragment_container1, mSecondFragment)
//            }
//            if (!mThirdFragment.isAdded) {
//                fragmentTransaction.add(R.id.fragment_container2, mThirdFragment)
//            }
//            fragmentTransaction.commit()
//        }
//        mRemoveBtn.setOnClickListener {
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.remove(mSecondFragment)
//            fragmentTransaction.commit()
//        }
//        mReplaceBtn.setOnClickListener {
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            if (!mSecondFragment.isAdded) {
//                fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment)
//            }
//            fragmentTransaction.commit()
//        }




        val mAttachBtn  = findViewById<Button>(R.id.attach_btn)
        val mDetachBtn  = findViewById<Button>(R.id.detach_btn)
        val mDemoFragment = Course_48_display_show_hide()
        val fragmentManager_display = supportFragmentManager
        val fragmentTransaction_display = fragmentManager_display.beginTransaction()
        fragmentTransaction_display.add(R.id.fragment_container_display,mDemoFragment)
        fragmentTransaction_display.commit()
        mAttachBtn.setOnClickListener {
            val fragmentManager_mAttachBtn = supportFragmentManager
            val fragmentTransaction_mAttachBtn = fragmentManager_mAttachBtn.beginTransaction()
            if (mDemoFragment.isDetached) {
                fragmentTransaction_mAttachBtn.attach(mDemoFragment)
            }
            fragmentTransaction_mAttachBtn.commit()
        }
        mDetachBtn.setOnClickListener {
            val fragmentManager_mAttachBtn = supportFragmentManager
            val fragmentTransaction_mAttachBtn = fragmentManager_mAttachBtn.beginTransaction()
            if (!mDemoFragment.isDetached) {
                fragmentTransaction_mAttachBtn.detach(mDemoFragment)
            }
            fragmentTransaction_mAttachBtn.commit()
        }



        val mAddBtn = findViewById<Button>(R.id.add_btn)
        val mRemoveBtn  = findViewById<Button>(R.id.remove_btn)
        val mReplaceBtn  = findViewById<Button>(R.id.replace_btn)
        val mSecondFragment = Course_48_add_delete_second()
        val mThirdFragment = Course_48_add_delete_third()

        mAddBtn.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // 向容器内加入Fragment
            if (!mSecondFragment.isAdded) {
                fragmentTransaction.add(R.id.fragment_container1, mSecondFragment)
            }
            if (!mThirdFragment.isAdded) {
                fragmentTransaction.add(R.id.fragment_container2, mThirdFragment)
            }
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        mRemoveBtn.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(mSecondFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        mReplaceBtn.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            if (!mSecondFragment.isAdded) {
                fragmentTransaction.replace(R.id.fragment_container2, mSecondFragment)
            }
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}