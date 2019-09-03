package com.example.notice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DeliveryPagerAdapter: FragmentPagerAdapter{

    // 객체 생성
    var data1 : Fragment = NoticeFragment()
    var data2 : Fragment = NoticeFragment()

    // 초기화 ArrayList에 Fragment로 설정된 레이아웃들을 저장
    var mData : ArrayList<Fragment> = arrayListOf(data1,data2)

    /*필수 생성자*/
    constructor(fm : FragmentManager) : super(fm){}

    override fun getItem(position: Int): Fragment {
        return mData.get(position)
    }

    override fun getCount(): Int {
        return mData.size
    }


}
