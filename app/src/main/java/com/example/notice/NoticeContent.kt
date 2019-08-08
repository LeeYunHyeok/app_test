package com.example.notice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NoticeContent : AppCompatActivity() {

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notice_content)
        /*val intent = intent

        var num:Int = intent.getIntExtra("num")

        var noticeRef : DatabaseReference = database.getReference("notice/")*/
    }


}
