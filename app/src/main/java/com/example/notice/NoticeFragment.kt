package com.example.notice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    var noticeList = arrayListOf<NoticeDTO>()
    private val TAG = "Kotlin Firebase : "
    var count:Int = 7
    var footer:View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.notice_main, null)
        val noticeAdapter = RecyclerNoticeListAdapter(view.context, noticeList)
        footer = layoutInflater.inflate(R.layout.notice_footer, null, false)
        val myRef = FAdapter.db.getReference("notice")
        view.rcvNoticeList.adapter = noticeAdapter
        view.rcvNoticeList.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        view.rcvNoticeList.layoutManager = layoutManager
        view.fabNoticeWrite.setOnClickListener{
            val intent = Intent(context, NoticeWrite::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
        noticeAdapter.setItemClickListener(object : RecyclerNoticeListAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, NoticeContent::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("num", noticeList[position].no_num)
                startActivity(intent)
            }
        })

        view.rcvNoticeList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

            }
        })

        /*view.rcvNoticeList.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            if(noticeList.size != position) {
                val intent = Intent(context, NoticeContent::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("num", noticeList[position].no_num)
                startActivity(intent)
            }else if(noticeList.size == position){
                // footer 부분
                if(noticeList.size > count)
                    count = count + 5
                myRef.limitToFirst(count).addValueEventListener(object : ValueEventListener {
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
                        *//*var user_id:String = ""*//*

                        for( value in dataSnapshot.children){
                            num = value.key.toString()
                            title = value.child("title").value.toString()
                            reason = value.child("reason").value.toString()
                            user = value.child("user").value.toString()
                            date = value.child("date").value.toString()
                            flag = value.child("flag").value.toString()
                            *//*user_id = value.child("user_id").value.toString()*//*
                            if(!flag.equals("2"))
                                noticeList.add(NoticeDTO(title,reason,num,date,user))

                        }
                        Log.d("position", "${noticeList.size} , $count")
                        if(noticeList.size <= (count-1)) {
                            *//*view.lvNotice.removeFooterView(footer)*//*
                        }else {
                            *//*view.lvNotice.addFooterView(footer)*//*
                        }
                        noticeAdapter.notifyDataSetChanged()

                    }


                    override fun onCancelled(error: DatabaseError) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException())
                    }
                })

            }

        }*/

        myRef.limitToFirst(count).addValueEventListener(object : ValueEventListener {
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
                        noticeList.add(NoticeDTO(title,reason,num,date,user))

                }
                if(noticeList.size >= (count-1)) {
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

    private fun db(){}

}