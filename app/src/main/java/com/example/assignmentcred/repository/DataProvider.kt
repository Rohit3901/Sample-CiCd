package com.example.assignmentcred.repository

import com.example.assignmentcred.model.ViewType
import com.cred.assignment.stacklib.model.StackItemModel

object DataProvider {
    val stackList: ArrayList<StackItemModel> =
        ArrayList<StackItemModel>().apply {
            add(
                StackItemModel(
                    viewType = ViewType.ViewType1.type,
                    itemTitle = "What's your name?",
                    itemDescription = "Saket Mayank",
                    isItemExpanded = true
                ))
                add( StackItemModel(
                    viewType = ViewType.ViewType2.type,
                    itemTitle = "What's your profession?",
                    itemDescription = "Software Developer",
                    isItemExpanded = true
                ))
                add( StackItemModel(
                    viewType = ViewType.ViewType3.type,
                    itemTitle = "How many years of experience do you have?",
                    itemDescription = "3 years",
                    isItemExpanded = true
                ))
                add( StackItemModel(
                    viewType = ViewType.ViewType4.type,
                    itemTitle = "Which languages do you know?",
                    itemDescription = "English,Hindi",
                    isItemExpanded = true
                ))
        }
}