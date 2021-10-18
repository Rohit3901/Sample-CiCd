package com.cred.assignment.stacklib.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.cred.assignment.stacklib.databinding.StackPageBinding
import com.cred.assignment.stacklib.model.StackItemModel
import java.util.ArrayList

class StackPage @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
): LinearLayout(context, attrs) {

    private val binding = StackPageBinding.inflate(LayoutInflater.from(context), this,true)
    private var stackView: CustomStackView? = null
    private  var newList = emptyList<StackItemModel>()
    private val mMaxItems: Int = 4
    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.cta.setOnClickListener {
            val size = binding.stackList.getPosition()
            if(size< mMaxItems){
                stackView?.bind(newList[size])
            }
        }
    }

    fun bind(
        viewCreators: Map<Int, ViewCreator>,
        orientation: Int = RecyclerView.VERTICAL,
        navigationText: String,
        list: ArrayList<StackItemModel>,
    ) {
        this.newList = list
        initList(list.first(), viewCreators)
        binding.cta.text = navigationText
    }

    private fun initList(
        list: StackItemModel,
        viewCreators: Map<Int, ViewCreator>
    ) {

        stackView = binding.stackList
        stackView?.init(
            viewCreators = viewCreators
        )
        stackView?.bind(list)
    }

    fun onBackPress():Boolean =
        binding.stackList.isPositionFirst()

}