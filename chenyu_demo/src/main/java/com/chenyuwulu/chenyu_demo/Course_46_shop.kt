package com.chenyuwulu.chenyu_demo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Course_46_shop : AppCompatActivity(), View.OnClickListener {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_46_result_shop)

        val mLifeTV = findViewById<TextView>(R.id.life_tv)
        val mNameTV = findViewById<TextView>(R.id.name_tv)
        val mSpeedTV = findViewById<TextView>(R.id.speed_tv)
        val mAttackTV = findViewById<TextView>(R.id.attack_tv)

        mNameTV.text = NAME
        mLifeTV.text = "生命值+$LIFE_VALUE"
        mSpeedTV.text = "敏捷度+$SPEED_VALUE"
        mAttackTV.text = "攻击力+$ATTACK_VALUE"


        findViewById<View>(R.id.buy_rl).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buy_rl -> {
                val intent = Intent()

                val data = Bundle()
                data.putString(DATA_KEY_NAME, NAME)
                data.putInt(DATA_KEY_LIFE, LIFE_VALUE)
                data.putInt(DATA_KEY_SPEED, SPEED_VALUE)
                data.putInt(DATA_KEY_ATTACK, ATTACK_VALUE)
                intent.putExtras(data)

                setResult(1, intent)
                finish()
            }
        }
    }

    companion object {
        const val DATA_KEY_NAME = "name"
        const val DATA_KEY_LIFE = "life"
        const val DATA_KEY_SPEED = "speed"
        const val DATA_KEY_ATTACK = "attack"

        private const val NAME = "小宝"
        private const val LIFE_VALUE = 20
        private const val SPEED_VALUE = 30
        private const val ATTACK_VALUE = 10
    }
}