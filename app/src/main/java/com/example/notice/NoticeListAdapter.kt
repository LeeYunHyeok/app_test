package com.example.notice

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NoticeListAdapter(val context: Context, val noticeList: ArrayList<Notice>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_notice, null)

        val tv_no_num = view.findViewById<TextView>(R.id.tv_no_num)
        val tv_no_title = view.findViewById<TextView>(R.id.tv_no_title)
        val tv_no_person = view.findViewById<TextView>(R.id.tv_no_person)
        val tv_no_date = view.findViewById<TextView>(R.id.tv_no_date)

        val notices = noticeList[position]
        /*val resourceId = context.resources.getIdentifier(notices.photo, "drawable", context.packageName)*/
        tv_no_num.text = "${notices.no_num}. "
        tv_no_title.text = notices.no_title
        tv_no_person.text = notices.no_person
        tv_no_date.text = notices.no_date

        /*tv_no_title.setOnClickListener {
            val intent = Intent(context, NoticeContent::class.java)
            intent.putExtra("num", tv_no_num.text)
            context.startActivity(intent)
        }*/

        return view
    }

    override fun getItem(position: Int): Any {
        return noticeList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return noticeList.size
    }

}