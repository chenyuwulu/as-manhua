package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Course_46 : AppCompatActivity() {

    private var mLifePb: ProgressBar? = null
    private var mAttackPb: ProgressBar? = null
    private var mSpeedPb: ProgressBar? = null
    private var mLifeTV: TextView? = null
    private var mAttackTV: TextView? = null
    private var mSpeedTV: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_46)
        title = "Activity回调"
        val mBuyBtn = findViewById<Button>(R.id.buy_btn)
        mLifeTV = findViewById(R.id.life_progress_tv)
        mAttackTV = findViewById(R.id.attack_progress_tv)
        mSpeedTV = findViewById(R.id.speed_progress_tv)
        mLifePb = findViewById(R.id.life_pb)
        mAttackPb = findViewById(R.id.attack_pb)
        mSpeedPb = findViewById(R.id.speed_pb)

        mLifePb?.max = 100
        mAttackPb?.max = 100
        mSpeedPb?.max = 100

        mBuyBtn.setOnClickListener {
            val intent = Intent(this,Course_46_shop::class.java)
            startActivityForResult(intent,1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (resultCode == 1) {
                if (requestCode == 1) {
                    val equipment = data.extras
                    //更新ProgressBar的值
                    val lifeProgress = mLifePb?.progress
                    val attackProgress = mAttackPb?.progress
                    val speedProgress = mSpeedPb?.progress

                    mLifePb?.progress = lifeProgress!! + equipment!!.getInt(Course_46_shop.DATA_KEY_LIFE)
                    mAttackPb?.progress = attackProgress!! + equipment.getInt(Course_46_shop.DATA_KEY_ATTACK)
                    mSpeedPb?.progress = speedProgress!! + equipment.getInt(Course_46_shop.DATA_KEY_SPEED)
                    mLifeTV?.text=mLifePb!!.progress.toString()
                    mAttackTV?.text=mAttackPb!!.progress.toString()
                    mSpeedTV?.text= mSpeedPb!!.progress.toString()
                }
            }
        }
    }
}