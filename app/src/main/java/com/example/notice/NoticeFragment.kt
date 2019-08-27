package com.example.notice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.notice_main.view.*

/*
* 실제 공지사항 데이터
*
*/
class NoticeFragment: Fragment(){
    var mContext: Context? = null
    var noticeList = arrayListOf<Notice>()
    private val TAG = "Kotlin Firebase : "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.notice_main, null)
        val noticeAdapter = NoticeListAdapter(view.context, noticeList)
        view.lvNotice.adapter = noticeAdapter

        val myRef = FAdapter.db.getReference("notice")

        view.fabNoticeWrite.setOnClickListener{
            val intent = Intent(context, NoticeWrite::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        view.lvNotice.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, NoticeContent::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("num", noticeList[position].no_num)
            startActivity(intent)

        }

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                noticeList.clear()
                var title:String
                var num:String
                var date:String
                var reason:String
                var user:String
                var flag:String
                /*var user_id:String = ""*/

                for( value in dataSnapshot.children){
                    num = value.key.toString()
                    title = value.child("title").value.toString()
                    reason = value.child("reason").value.toString()
                    user = value.child("user").value.toString()
                    date = value.child("date").value.toString()
                    flag = value.child("flag").value.toString()
                    /*user_id = value.child("user_id").value.toString()*/
                    if(!flag.equals("2"))
                        noticeList.add(Notice(title,reason,num,date,user))

                }
                noticeAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        // 처리
        return view
    }


}