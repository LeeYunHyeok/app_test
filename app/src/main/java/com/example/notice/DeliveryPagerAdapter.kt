package com.example.notice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DeliveryPagerAdapter: FragmentPagerAdapter{

    // 객체 생성
    var data1 : Fragment = NoticeFragment()
    var data2 : Fragment = NoticeFragment()
    /*var data2 : Fragment = OneToOne_Chatting()*/


    // 초기화
    var mData : ArrayList<Fragment> = arrayListOf(data1,data2)


    constructor(fm : FragmentManager) : super(fm){

    }


    override fun getItem(position: Int): Fragment {
        return mData.get(position)
    }

    override fun getCount(): Int {
        return mData.size
    }


}
