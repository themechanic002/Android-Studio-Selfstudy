package com.example.mysharedpreference

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("인사", "안녕하세요")
        editor.putString("감사", "감사합니다")
        editor.putString("작별인사", "안녕히가세요")
        editor.commit()

        Log.d("아아", sharedPreferences.getString("감사", "데이터 없음").toString())
        

    }
}