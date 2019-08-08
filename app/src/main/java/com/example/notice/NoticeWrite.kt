package com.example.notice

import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.notice_write.*
import java.util.*

class NoticeWrite : AppCompatActivity() {
    private val KEY_NOTICE = ""
    private val TAG = "Kotlin Firebase : "
    var num:Int = 0
    val database : FirebaseDatabase= FirebaseDatabase.getInstance()
    var noticeRef : DatabaseReference = database.getReference("notice/")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notice_write)

        val noticeNum : DatabaseReference = database.getReference("notice_num")

        btn_back.setOnClickListener{
            finish()
        }

        noticeNum.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot?.value
                num = value.toString().toInt()
                noticeRef = database.getReference("notice/${(num+1)}")

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        btn_notice_compl.setOnClickListener {
            var etCheck = et_notice_title.text.toString().trim()

            /* 제목 작성이 실패 했을때*/
            if(etCheck.equals("")) {
                var builder = AlertDialog.Builder(ContextThemeWrapper(this@NoticeWrite, R.style.Theme_AppCompat_Light_Dialog))
                builder.setTitle("게시물 작성 실패")
                builder.setMessage("제목이 빈 칸입니다")
                builder.setPositiveButton("확인"){ _,_-> }

                builder.show()
            } else {

                noticeNum.setValue(++num)
                var notice_title: String = et_notice_title.text.toString()
                var notice_con: String = et_notice_con.text.toString()
                val instance = Calendar.getInstance()
                val year = instance.get(Calendar.YEAR).toString()
                val month = (instance.get(Calendar.MONTH) + 1).toString()
                val date = instance.get(Calendar.DATE).toString()
                val hour = instance.get(Calendar.HOUR).toString()
                val minu = instance.get(Calendar.MINUTE).toString()
                val now = "$year/$month/$date $hour:$minu"
                noticeRef.child("user_id").setValue("bsc2079")
                noticeRef.child("user_id").setValue("bsc2079")
                noticeRef.child("count").setValue(0)
                noticeRef.child("user").setValue("이윤혁")
                noticeRef.child("title").setValue("$notice_title")
                noticeRef.child("reason").setValue("$notice_con")
                noticeRef.child("date").setValue("$now")

                Toast.makeText(this, "게시글이 등록되었습니다", Toast.LENGTH_SHORT).show()
                finish()
            }

        }

    }
}
