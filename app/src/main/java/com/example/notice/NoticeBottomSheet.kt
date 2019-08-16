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
        mContext = context
        val btnNoticeUpdate = contentView.findViewById(R.id.btnNoticeUpdate) as Button
        btnNoticeUpdate.setOnClickListener {
            val intent = Intent(context,NoticeWrite::class.java)
            startActivity(intent)
            dismiss()
            (mContext as Activity).finish()
        }

        val btnNoticeDelete = contentView.findViewById(R.id.btnNoticeDelete) as Button
        btnNoticeDelete.setOnClickListener {

            var noticeRef = FAdapter.db.getReference("notice/${FAdapter.num}")

            var builder = AlertDialog.Builder(ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_Dialog))
            builder.setTitle("삭제하겠습니까?")
            builder.setMessage("삭제되는 공지사항은 저장되지 않습니다")
            builder.setPositiveButton("취소"){ _,_->}
            builder.setNegativeButton("삭제"){_,_->
                noticeRef.child("flag").setValue(2)
                Toast.makeText(context, "게시글이 삭제되었습니다", Toast.LENGTH_SHORT).show()
                dismiss()
                (mContext as Activity).finish()
            }
            builder.show()


        }
    }
}