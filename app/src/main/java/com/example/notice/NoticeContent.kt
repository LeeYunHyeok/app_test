package com.example.notice

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.notice_content.*
import kotlinx.android.synthetic.main.notice_content_bottomsheet.*

class NoticeContent : AppCompatActivity() {
    // 늦은 초기화

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notice_content)
        FAdapter.num = intent.getStringExtra("num").toString()
        var num = FAdapter.num
        val myRef = FAdapter.db.getReference("notice/$num")

        btnConList.setOnClickListener {
            val bottomSheetDialogFragment = NoticeBottomSheet()
            bottomSheetDialogFragment.show(supportFragmentManager, bottomSheetDialogFragment.tag)
        }

        /*val btnNoticeUpdate = findViewById(R.id.btnNoticeUpdate) as Button
        btnNoticeUpdate.setOnClickListener {

        }*/

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var title:String = dataSnapshot.child("title").value.toString()
                var date:String = dataSnapshot.child("date").value.toString()
                var reason:String = dataSnapshot.child("reason").value.toString()
                var user:String = dataSnapshot.child("user").value.toString()
                /*var user_id:String = ""*/

                /*for( value in dataSnapshot.children){
                    num = value.key.toString()
                    title = value
                    reason = value
                    user = value.child("").value.toString()
                    date = value.child("").value.toString()
                    *//*user_id = value.child("user_id").value.toString()*//*

                }*/

                tvCon_title.setText("$title")
                tvCon_con.setText("$reason")
                tvCon_user.setText("$user")
                tvCon_num.setText("$num. ")
                tvCon_date.setText("$date")

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })

    }

}
