package com.example.notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.top_nav.view.*

class NoticeFragment: Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.top_nav, null)
        val navTop = view.findViewById<View>(R.id.navTop) as BottomNavigationView
        navTop.inflateMenu(FAdapter.nav)
        // 처리
        return view
    }
}