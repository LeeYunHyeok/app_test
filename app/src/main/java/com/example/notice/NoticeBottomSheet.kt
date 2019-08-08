package com.example.notice

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.notice_content_bottomsheet.*

class NoticeBottomSheet: BottomSheetDialogFragment(){
    var mContext: Context? = null
    override fun setupDialog(dialog: Dialog?, style: Int) {
        val contentView = View.inflate(context, R.layout.notice_content_bottomsheet, null)
        dialog?.setContentView(contentView)

        val btnNoticeUpdate = contentView.findViewById(R.id.btnNoticeUpdate) as Button
        btnNoticeUpdate.setOnClickListener {
            
        }

        val btnNoticeDelete = contentView.findViewById(R.id.btnNoticeDelete) as Button
        btnNoticeDelete.setOnClickListener {

            var noticeRef = FAdapter.db.getReference("notice/${FAdapter.num}")

            var builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_Dialog))
            builder.setTitle("삭제")
            builder.setMessage("삭제 하시겠습니까?")
            builder.setPositiveButton("확인"){ _,_->
                noticeRef.child("flag").setValue(2)
                Toast.makeText(context, "게시글이 삭제되었습니다", Toast.LENGTH_SHORT).show()
                dismiss()
                mContext = context
                (mContext as Activity).finish()
            }
            builder.setNegativeButton("취소"){_,_->}
            builder.show()


        }
    }
}