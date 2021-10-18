package com.example.assignmentcred.customViews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.stacklib.model.StackItemModel
import com.cred.assignment.stacklib.model.ViewItem
import com.cred.assignment.stacklib.ui.ViewCreator
import com.cred.assignment.stacklib.ui.ViewInteractionListener
import com.example.assignmentcred.R

class ViewType1 : ViewCreator {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder1(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view1, parent, false)
        )
    }

    private inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item1Title: TextView = itemView.findViewById(R.id.item1_title)
        var item1Desc: TextView = itemView.findViewById(R.id.item1_desc)
        var item1Action: ImageView = itemView.findViewById(R.id.item1_action)

        fun bind(
            value: StackItemModel,
            interactionListener: ViewInteractionListener?,
            position: Int
        ) {
            item1Title.text = value.itemTitle
            item1Desc.text = value.itemDescription
            if (value.isItemExpanded) {
                item1Action.visibility = View.GONE
                item1Title.visibility = View.VISIBLE
                item1Desc.visibility = View.VISIBLE
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
            } else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.type1))
                item1Title.visibility = View.GONE
                item1Action.visibility = View.VISIBLE
            }

            item1Action.setOnClickListener {
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
        (holder as ViewHolder1).bind(data, interactionListener, position)
    }
}