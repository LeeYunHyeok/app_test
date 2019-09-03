package com.example.notice

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.delivery_main.view.*

/*
*
*  직원 - 전달사항 화면 기능
*
**/
class DeliveryFragment: Fragment(){
    var mContext: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.delivery_main, null)
        var main_adapter = DeliveryPagerAdapter(childFragmentManager)
        /*pager Adapter 연결*/
        view.vpNotice.adapter = main_adapter

        view.btn_notice.setOnClickListener{
            view.btn_notice.setBackgroundResource(R.drawable.btn_bg_down)
            view.btn_notice.setTextColor(Color.parseColor("#ffffff"))
            view.btn_report.setBackgroundResource(R.drawable.btn_bg_up)
            view.btn_report.setTextColor(Color.parseColor("#707070"))
            view.vpNotice.currentItem = 0
        }

        view.btn_report.setOnClickListener{
            view.btn_notice.setBackgroundResource(R.drawable.btn_bg_up)
            view.btn_notice.setTextColor(Color.parseColor("#707070"))
            view.btn_report.setBackgroundResource(R.drawable.btn_bg_down)
            view.btn_report.setTextColor(Color.parseColor("#ffffff"))
            view.vpNotice.currentItem = 1
        }

        view.vpNotice.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            // page가 옮겨질때 상태 0: 정지, 1: 이동, 2: 선택완료
            override fun onPageScrollStateChanged(state: Int) {
            }

            //page 가 클릭되어 스크롤 되고 있을때
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            // page가 완전히 선택되었을때 위치
            override fun onPageSelected(position: Int) {
                Log.d("pagePositionSelect", "$position")
                if(position == 0){
                    view.btn_notice.setBackgroundResource(R.drawable.btn_bg_down)
                    view.btn_notice.setTextColor(Color.parseColor("#ffffff"))
                    view.btn_report.setBackgroundResource(R.drawable.btn_bg_up)
                    view.btn_report.setTextColor(Color.parseColor("#707070"))
                }

                if(position == 1){
                    view.btn_notice.setBackgroundResource(R.drawable.btn_bg_up)
                    view.btn_notice.setTextColor(Color.parseColor("#707070"))
                    view.btn_report.setBackgroundResource(R.drawable.btn_bg_down)
                    view.btn_report.setTextColor(Color.parseColor("#ffffff"))
                }

            }
        })
        return view
    }
}
