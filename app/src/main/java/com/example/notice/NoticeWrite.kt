package com.example.notice

import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.notice_write.*
import java.util.*
import java.text.SimpleDateFormat


class NoticeWrite : AppCompatActivity() {
    private val KEY_NOTICE = "notice"
    private val TAG = "Kotlin Firebase : "
    var num:Int = 0
    var noticeRef : DatabaseReference = FAdapter.db.getReference(KEY_NOTICE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notice_write)

        val noticeNum : DatabaseReference = FAdapter.db.getReference("notice_num")

        btn_back.setOnClickListener{
            finish()
        }
        if(FAdapter.num.equals("0")){
            noticeNum.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val value = dataSnapshot?.value
                    num = value.toString().toInt()
                    noticeRef = FAdapter.db.getReference("notice/${(num+1)}")

                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })
        } else {
            num = FAdapter.num.toInt()
            tvWriteTitle.setText("공지사항 수정")
            btn_notice_compl.setText("수정")
            noticeRef = FAdapter.db.getReference("notice/$num")
            et_notice_title.setText(FAdapter.title)
            et_notice_con.setText(FAdapter.reason)
        }
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
                val dt = Date()
                val full_sdf = SimpleDateFormat("yyyy/MM/dd, a hh:mm")
                var now = full_sdf.format(dt).toString()

                var notice_title: String = et_notice_title.text.toString()
                var notice_con: String = et_notice_con.text.toString()
                noticeRef.child("title").setValue("$notice_title")
                noticeRef.child("reason").setValue("$notice_con")
                if(FAdapter.num.equals("0")){
                    noticeNum.setValue(++num)
                    noticeRef.child("date").setValue("$now")
                    noticeRef.child("user_id").setValue("bsc2079")
                    noticeRef.child("flag").setValue(0)
                    noticeRef.child("count").setValue(0)
                    noticeRef.child("user").setValue("프렌트리")
                    Toast.makeText(this, "게시글이 등록되었습니다", Toast.LENGTH_SHORT).show()
                } else {
                    noticeRef.child("udate").setValue("$now")
                    Toast.makeText(this, "게시글이 추가되었습니다", Toast.LENGTH_SHORT).show()
                }
                finish()
            }

        }

    }

    override fun onStop() {
        super.onStop()
        FAdapter.num = "0"
    }
}
