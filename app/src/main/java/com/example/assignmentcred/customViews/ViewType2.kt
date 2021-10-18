package com.example.assignmentcred.customViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentcred.R
import com.cred.assignment.stacklib.model.StackItemModel
import com.cred.assignment.stacklib.model.ViewItem
import com.cred.assignment.stacklib.ui.ViewCreator
import com.cred.assignment.stacklib.ui.ViewInteractionListener

class ViewType2: ViewCreator {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder2(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view2, parent, false)
        )
    }

    private inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item2Title: TextView = itemView.findViewById(R.id.item2_title)
        var item2Desc: TextView = itemView.findViewById(R.id.item2_desc)
        var item2Action: ImageView = itemView.findViewById(R.id.item2_action)
        fun bind(
            value: StackItemModel,
            interactionListener: ViewInteractionListener?,
            position: Int) {
            item2Title.text = value.itemTitle
            item2Desc.text  =value.itemDescription
            if(value.isItemExpanded){
                item2Action.visibility = View.GONE
                item2Title.visibility = View.VISIBLE
                item2Desc.visibility = View.VISIBLE
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.type2))
                item2Title.visibility = View.GONE
                item2Action.visibility = View.VISIBLE
            }

            item2Action.setOnClickListener {
                interactionListener?.onItemClicked(position)
            }
        }
    }

    override fun onSyncViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        data: ViewItem,
        interactionListener: ViewInteractionListener?
    ) {
        if (data !is StackItemModel) throw IllegalStateException("Please check your card creator map and list item to provide same position for type")
        (holder as ViewType2.ViewHolder2).bind(data, interactionListener, position)
    }
}