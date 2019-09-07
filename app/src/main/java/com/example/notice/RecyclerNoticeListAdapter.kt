package com.example.notice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerNoticeListAdapter(val context: Context, val noticeList: ArrayList<NoticeDTO>) : RecyclerView.Adapter<RecyclerNoticeListAdapter.Holder>() {
    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1
    private val TYPE_FOOTER = 2

    //클릭 인터페이스 정의
    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    //클릭리스너 선언
    private lateinit var itemClickListner: ItemClickListener

    //클릭리스너 등록 매소드
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_notice, p0, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        var view = holder

        //view에 onClickListner를 달고, 그 안에서 직접 만든 itemClickListener를 연결시킨다
        view.itemView.setOnClickListener{
            itemClickListner.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.bind(noticeList[p1])
    }


    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        private val tv_no_num = itemView?.findViewById<TextView>(R.id.tv_no_num)
        private val tv_no_title = itemView?.findViewById<TextView>(R.id.tv_no_title)
        private val tv_no_person = itemView?.findViewById<TextView>(R.id.tv_no_person)
        private val tv_no_date = itemView?.findViewById<TextView>(R.id.tv_no_date)

        fun bind(notice: NoticeDTO) {
            tv_no_num?.text = notice.no_num.toString()
            tv_no_title?.text = notice.no_title.toString()
            tv_no_person?.text = notice.no_person.toString()
            tv_no_date?.text = notice.no_date.toString()
        }

    }

}


/*BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        *//* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. *//*
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_notice, null)

        val tv_no_num = view.findViewById<TextView>(R.id.tv_no_num)
        val tv_no_title = view.findViewById<TextView>(R.id.tv_no_title)
        val tv_no_person = view.findViewById<TextView>(R.id.tv_no_person)
        val tv_no_date = view.findViewById<TextView>(R.id.tv_no_date)

        val notices = noticeList[position]
        *//*val resourceId = context.resources.getIdentifier(notices.photo, "drawable", context.packageName)*//*
        tv_no_num.text = "${notices.no_num}. "
        tv_no_title.text = notices.no_title
        tv_no_person.text = notices.no_person
        tv_no_date.text = notices.no_date

        *//*tv_no_title.setOnClickListener {
            val intent = Intent(context, NoticeContent::class.java)
            intent.putExtra("num", tv_no_num.text)
            context.startActivity(intent)
        }*//*

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
*/