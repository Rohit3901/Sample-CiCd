package com.example.assignmentcred.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignmentcred.databinding.ActivityMainBinding
import com.example.assignmentcred.customViews.ViewType1
import com.example.assignmentcred.customViews.ViewType2
import com.example.assignmentcred.customViews.ViewType3
import com.example.assignmentcred.customViews.ViewType4
import com.example.assignmentcred.model.ViewType
import com.example.assignmentcred.repository.DataProvider
import com.cred.assignment.stacklib.model.StackItemModel
import com.cred.assignment.stacklib.ui.ViewCreator
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initList(DataProvider.stackList)
    }

    private fun initList(
        stackList: ArrayList<StackItemModel>
    ) {
        binding.page.bind(
            viewCreators = getViewCreatorsMap(),
            navigationText = "NEXT",
            list = stackList
        )
    }

    private fun getViewCreatorsMap(): Map<Int, ViewCreator> =
        mutableMapOf(
            ViewType.ViewType1.type to ViewType1(),
            ViewType.ViewType2.type to ViewType2(),
            ViewType.ViewType3.type to ViewType3(),
            ViewType.ViewType4.type to ViewType4()
        )

    override fun onBackPressed() {
        binding.page.onBackPress()
    }
}