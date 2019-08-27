package com.example.notice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class WeFragment: Fragment(){
    var mContext: Context? = null
    val TAG = "position ==========>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.job_tab, null)
       /* view.tabTopAdmin.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var pos = tab?.position
                Log.w(TAG, pos.toString())
                changeView(pos)
            }

        })*/
        // 처리
        return view
    }

    /*private fun changeView(pos: Int?) {
        when(pos){
            0 -> {
            }
            1 -> {
            }
            2 -> {

            }

        }

    }*/

}