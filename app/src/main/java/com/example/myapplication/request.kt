package com.example.myapplication

import android.util.Log
import java.net.URL

class request(val url: String)
{
    public fun run():String
    {
        val jsonString: String = URL(url).readText()
        Log.i("Request",jsonString)

        return jsonString
    }
}