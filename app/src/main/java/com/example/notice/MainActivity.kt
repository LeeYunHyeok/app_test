package com.example.notice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.top_nav.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var noticeList = arrayListOf<Notice>()
    private val TAG = "Kotlin Firebase : "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, NoticeFragment())
            .commit()

        val bottom_navi = findViewById<View>(R.id.bottom_navi) as BottomNavigationView
        bottom_navi.setOnNavigationItemSelectedListener(this)
/*

        val noticeAdapter = NoticeListAdapter(this, noticeList)
        lv_notice.adapter = noticeAdapter

        val myRef = FAdapter.db.getReference("notice")

        fab_write.setOnClickListener{
            val intent = Intent(this, NoticeWrite::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        lv_notice.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, NoticeContent::class.java)
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
                        noticeList.add(Notice(title,reason,num,date,user))

                }
                noticeAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })*/

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.bottom_home ->{
                FAdapter.nav = R.menu.home_manu
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, NoticeFragment())
                    .commit()
                /*val fragmentA = FragmentA()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragmentA).commit()*/
            }
            R.id.bottom_admin -> {
                FAdapter.nav = R.menu.admin_manu
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, NoticeFragment())
                    .commit()
            }
            R.id.bottom_recruitment -> {
                FAdapter.nav = R.menu.recruitment_manu
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, NoticeFragment())
                    .commit()
            }
            R.id.bottom_setting -> {
                FAdapter.nav = R.menu.setting_manu
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, NoticeFragment())
                    .commit()
            }
        }
        return true
    }

}