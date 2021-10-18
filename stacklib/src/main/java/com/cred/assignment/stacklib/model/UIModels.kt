package com.cred.assignment.stacklib.model

sealed class ViewItem(@Transient open val viewType: Int)

data class StackItemModel(
    override val viewType: Int,
    val itemTitle: String,
    val itemDescription: String,
    var isItemExpanded: Boolean
): ViewItem(viewType)
