package com.example.notice

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* 타이틀 x */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main)

        val bottomNavi = findViewById<View>(R.id.bottomNavi) as BottomNavigationView
        /* bottomnavigation 아이템 클릭 리스너 */
        bottomNavi.setOnNavigationItemSelectedListener(this)

    }

    // Bottom Navigation 버튼 클릭 이벤트
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        /*클릭한 Bottom Navigation 의 액션 처리*/
        when (p0.itemId) {
            R.id.bottomHome -> {

            }
            R.id.bottomStaff -> {
                /* framLayout에 fragment 띄우기*/
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragMain, StaffFragment())
                    .commit()
            }
            R.id.bottomSales -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragMain, WeFragment())
                    .commit()
            }
            R.id.bottomSchdule -> {
            }
            R.id.bottomAll -> {
            }
        }
        return true
    }

}