package com.chenyuwulu.chenyu_demo.we_sub

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chenyuwulu.chenyu_demo.R
import com.tencent.connect.UserInfo
import com.tencent.tauth.IUiListener
import com.tencent.tauth.Tencent
import com.tencent.tauth.UiError
import org.json.JSONException
import org.json.JSONObject

class qq_login : AppCompatActivity() {

    private val TAG = "qq_login"
    var mTencent: Tencent? = null
    private var mUserInfo: UserInfo? = null
//    private var mIUiListener: BaseUiListener? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.we_sub_qq_login)
        val mAppid = "1109647204"
        val image = findViewById<ImageView>(R.id.iv_icon)
        val tencent_login = findViewById<Button>(R.id.tencent_login)
        val tv_result = findViewById<TextView>(R.id.tv_result)
        mTencent = Tencent.createInstance(mAppid, this)
        tencent_login.setOnClickListener{
            val mIUiListener = BaseUiListener()
            //all表示获取所有权限
            mTencent!!.login(this, "all", mIUiListener)
        }
    }
    inner class BaseUiListener : IUiListener {

        override fun onComplete(response: Any) {
            Toast.makeText(this@qq_login, "授权成功", Toast.LENGTH_SHORT).show()
            Log.e(TAG, "response:$response")
            val obj = response as JSONObject
            try {
                val openID = obj.getString("openid")
                val accessToken = obj.getString("access_token")
                val expires = obj.getString("expires_in")
                mTencent!!.openId = openID
                mTencent!!.setAccessToken(accessToken, expires)
                val qqToken = mTencent!!.qqToken
                mUserInfo = UserInfo(applicationContext, qqToken)
                mUserInfo!!.getUserInfo(object : IUiListener {
                    override fun onComplete(response: Any) {
                        //是一个json串response.tostring，直接使用gson解析就好
                        Log.e(TAG, "登录成功$response")
                        //登录成功后进行Gson解析即可获得你需要的QQ头像和昵称
                        // Nickname  昵称
                        //Figureurl_qq_1 //头像
                    }

                    override fun onError(uiError: UiError) {
                        Log.e(TAG, "登录失败$uiError")
                    }

                    override fun onCancel() {
                        Log.e(TAG, "登录取消")

                    }
                })
            } catch (e: JSONException) {
                e.printStackTrace()
            }

        }

        override fun onError(uiError: UiError) {
            Toast.makeText(this@qq_login, "授权失败", Toast.LENGTH_SHORT).show()

        }

        override fun onCancel() {
            Toast.makeText(this@qq_login, "授权取消", Toast.LENGTH_SHORT).show()

        }

    }
}