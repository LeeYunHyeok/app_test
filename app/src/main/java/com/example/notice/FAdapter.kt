package com.example.notice

import android.app.Activity
import com.google.firebase.database.FirebaseDatabase

class FAdapter {
    companion object{
        val db = FirebaseDatabase.getInstance()
        lateinit var num:String
        lateinit var act:NoticeContent
    }
}