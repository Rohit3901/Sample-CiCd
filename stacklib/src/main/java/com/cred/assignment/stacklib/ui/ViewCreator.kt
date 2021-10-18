package com.cred.assignment.stacklib.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.stacklib.model.ViewItem

interface ViewInteractionListener{
    fun onItemClicked(position: Int)
}

interface ViewCreator {
    fun onCreateViewHolder(
        parent: ViewGroup
    ): RecyclerView.ViewHolder

    fun onSyncViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        data: ViewItem,
        interactionListener: ViewInteractionListener?
    )
}