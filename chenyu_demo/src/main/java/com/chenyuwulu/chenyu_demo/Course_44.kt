package com.chenyuwulu.chenyu_demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.course_44.*


class Course_44 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.course_44)
        title = "intent"
        this.intent_Component.setOnClickListener {
            val intent = Intent(this, Course_2::class.java)
            startActivity(intent)
        }
        this.intent_Action.setOnClickListener {
            // 创建Intent对象
            val intent = Intent()
            intent.action = "com.chenyuwulu.chenyu_demo.intent_action"
            startActivity(intent)
        }
        this.intent_Category.setOnClickListener {
            val intent = Intent()
            intent.action = "com.chenyuwulu.chenyu_demo.intent_action"
            intent.addCategory("com.chenyuwulu.chenyu_demo.intent_category")
            startActivity(intent)
        }

        this.intent_data_fugai_type.setOnClickListener {
            val intent = Intent()
            intent.type = "abc/xyz"
            intent.data = Uri.parse("scheme://host:port/path")
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }
        this.intent_type_fugai_data.setOnClickListener {
            val intent = Intent()
            intent.data = Uri.parse("scheme://host:port/path")
            intent.type = "abc/xyz"
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }
        this.intent_data_and_type.setOnClickListener {
            val intent = Intent()
            intent.setDataAndType(Uri.parse("scheme://host:port/path"), "abc/xyz")
            Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show()
        }

        this.intent_callphone.setOnClickListener {
            val uri = Uri.parse("tel:10086")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }
        this.intent_message.setOnClickListener {
            val uri = Uri.parse("smsto:10086")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello")
            startActivity(intent)
        }
        this.intent_color_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra("sms_body", "Hello")
            val uri = Uri.parse("content://media/external/images/media/23")
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.type = "image/png"
            startActivity(intent)
        }
        this.intent_browser.setOnClickListener {
            val uri = Uri.parse("https://www.baidu.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        this.intent_mail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, "675687771@qq.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            intent.putExtra(Intent.EXTRA_TEXT, "Hello")
            intent.type = "text/plain"
            startActivity(intent)
        }
        this.intent_map.setOnClickListener {
            val uri = Uri.parse("geo:39.9,116.3")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        this.intent_shoot.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 0)
        }
    }
}