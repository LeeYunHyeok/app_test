package com.example.notice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.staff_nav.view.*


class StaffFragment: Fragment(){
    var mContext: Context? = null
    val TAG = "position ==========>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        /* 레이아웃 inflate 시켜줌 : 실제 객체화*/
        val view = inflater.inflate(R.layout.staff_nav, null)
        view.tabTopStaff.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                /* tab을 클릭시 tab의 위치를 갖고 옴*/
                var pos = tab?.position
                Log.w(TAG, pos.toString())
                changeView(pos)
            }

        })
        // 처리
        return view
    }

    /* 상단 tab 메뉴 띄우기*/
    private fun changeView(pos: Int?) {
        /* 클릭한 tab의 액션 처리*/
        when(pos){
            0 -> {
            }
            1 -> {
            }
            2 -> {
                /*var main_adapter = DeliveryPagerAdapter(childFragmentManager)
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragShop, DeliveryFragment())
                    .commit()*/
            }
            3 -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragShop, DeliveryFragment())
                    .commit()
            }

        }

    }

}