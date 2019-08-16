package com.example.notice

import android.app.Activity
import com.google.firebase.database.FirebaseDatabase

class FAdapter {
    companion object{
        val db = FirebaseDatabase.getInstance()
        var num:String = "0"
        lateinit var title:String
        lateinit var reason:String
        lateinit var file:String
    }
}