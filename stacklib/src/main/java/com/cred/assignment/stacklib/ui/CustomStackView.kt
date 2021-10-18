package com.cred.assignment.stacklib.ui

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.stacklib.adapter.StackAdapter
import com.cred.assignment.stacklib.model.StackItemModel

class CustomStackView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RecyclerView(context, attrs), ViewInteractionListener {

    private lateinit var mAdapter: StackAdapter
    private lateinit var viewCreators: Map<Int, ViewCreator>

    fun init(
        viewCreators: Map<Int, ViewCreator>
    ) {
        this.viewCreators = viewCreators
        setUpRecyclerView()
        setUpAdapter()
    }

    private fun setUpRecyclerView() {
        layoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean = false
        }
    }

    private fun setUpAdapter() {
        mAdapter = StackAdapter(viewCreators, this)
        adapter = mAdapter
    }

    fun bind(item: StackItemModel) {
        mAdapter.addItemToList(item)
    }

    fun getPosition(): Int =
        mAdapter.itemCount

    fun isPositionFirst(): Boolean {
        return if (mAdapter.isPositionFirst) {
            true
        } else {
            mAdapter.removeItemFromList()
            false
        }
    }

    override fun onItemClicked(position: Int) {
        mAdapter.removeSubsequentItemsFromList(position)
    }


}