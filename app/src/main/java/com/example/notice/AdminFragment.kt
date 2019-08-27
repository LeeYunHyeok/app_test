package com.example.notice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.shop_nav.*
import kotlinx.android.synthetic.main.shop_nav.view.*


class AdminFragment: Fragment(){
    var mContext: Context? = null
    val TAG = "position ==========>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shop_nav, null)
        view.tabTopAdmin.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                var pos = tab?.position
                Log.w(TAG, pos.toString())
                changeView(pos)
            }

        })
        // 처리
        return view
    }

    private fun changeView(pos: Int?) {
        when(pos){
            0 -> {
            }
            1 -> {
            }
            2 -> {
                var main_adapter = DeliveryPagerAdapter(childFragmentManager)
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragShop, DeliveryFragment())
                    .commit()
            }
            3 -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragShop, DeliveryFragment())
                    .commit()
            }

        }

    }

}