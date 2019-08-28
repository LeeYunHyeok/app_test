package com.example.notice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.delivery_main.view.*


class DeliveryFragment: Fragment(){
    var mContext: Context? = null
    val TAG = "position ==========>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.delivery_main, null)
        var main_adapter = DeliveryPagerAdapter(childFragmentManager)
        view.vpNotice.adapter = main_adapter
        view.
        // 처리
        return view
    }

}