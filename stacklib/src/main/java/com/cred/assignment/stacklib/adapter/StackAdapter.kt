package com.cred.assignment.stacklib.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.stacklib.model.StackItemModel
import com.cred.assignment.stacklib.ui.ViewCreator
import com.cred.assignment.stacklib.ui.ViewInteractionListener

class StackAdapter(
    private val viewCreators: Map<Int, ViewCreator>,
    private val interactionListener: ViewInteractionListener?,
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var stackList =  mutableListOf<StackItemModel>()
    private val mMaxItems: Int = 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return (viewCreators[viewType]?: error("Card creator not found for card type $viewType"))
            .onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        val item = stackList[position]
        (viewCreators[viewType]?: throw IllegalStateException("view creator not found for type $viewType"))
            .onSyncViewHolder(
                holder = holder,
                position = position,
                data = item,
                interactionListener = interactionListener
            )
    }

    override fun getItemCount(): Int {
        return stackList.size
    }

    fun updateList(stackList: ArrayList<StackItemModel>){
        this.stackList = stackList
        notifyDataSetChanged()
    }

    fun addItemToList(item: StackItemModel) {
        if(stackList.size< mMaxItems) {
            if (stackList.size > 0) {
                stackList[stackList.size - 1].isItemExpanded = false
                notifyItemChanged(stackList.size - 1)
            }
            stackList.add(item.copy(isItemExpanded = true))
            notifyItemInserted(stackList.size-1)
        }
    }

    fun removeItemFromList() {
        if (stackList.size > 1) {
            stackList.removeAt(stackList.size - 1)
            notifyItemRemoved(stackList.size)
            stackList[stackList.size - 1].isItemExpanded = true
            notifyItemChanged(stackList.size - 1)
        }
    }

    fun removeSubsequentItemsFromList(position: Int) {
        if (stackList.size > 1) {
            val finalSize = stackList.size
            stackList.subList(position + 1, stackList.size).clear()
            notifyItemRangeRemoved(position + 1, finalSize - position)
            stackList[position].isItemExpanded = true
            notifyItemChanged(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return stackList[position].viewType
    }

    val isPositionLast: Boolean
        get() = stackList.size == mMaxItems


    val isPositionFirst: Boolean
        get() = stackList.size == 1
}