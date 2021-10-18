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

class ViewType3: ViewCreator {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder3(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view3, parent, false)
        )
    }

    private inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item3Title: TextView = itemView.findViewById(R.id.item3_title)
        var item3Desc: TextView = itemView.findViewById(R.id.item3_desc)
        var item3Action: ImageView = itemView.findViewById(R.id.item3_action)
        fun bind(
            value: StackItemModel,
            interactionListener: ViewInteractionListener?,
            position: Int) {
            item3Title.text = value.itemTitle
            item3Desc.text  =value.itemDescription
            if(value.isItemExpanded){
                item3Action.visibility = View.GONE
                item3Title.visibility = View.VISIBLE
                item3Desc.visibility = View.VISIBLE
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.type3))
                item3Title.visibility = View.GONE
                item3Action.visibility = View.VISIBLE
            }

            item3Action.setOnClickListener {
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
        (holder as ViewType3.ViewHolder3).bind(data, interactionListener, position)
    }
}