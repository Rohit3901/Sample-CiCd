package com.example.assignmentcred.customViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentcred.R
import com.cred.assignment.stacklib.model.StackItemModel
import com.cred.assignment.stacklib.model.ViewItem
import com.cred.assignment.stacklib.ui.ViewCreator
import com.cred.assignment.stacklib.ui.ViewInteractionListener

class ViewType4: ViewCreator {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder4(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view4, parent, false)
        )
    }

    private inner class ViewHolder4(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item4Title: TextView = itemView.findViewById(R.id.item4_title)
        var item4Desc: TextView = itemView.findViewById(R.id.item4_desc)
        fun bind(
            value: StackItemModel,
            interactionListener: ViewInteractionListener?,
            position: Int) {
            item4Title.text = value.itemTitle
            item4Desc.text  =value.itemDescription
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
        }
    }

    override fun onSyncViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        data: ViewItem,
        interactionListener: ViewInteractionListener?
    ) {
        if (data !is StackItemModel) throw IllegalStateException("Please check your card creator map and list item to provide same position for type")
        (holder as ViewType4.ViewHolder4).bind(data, interactionListener, position)
    }
}