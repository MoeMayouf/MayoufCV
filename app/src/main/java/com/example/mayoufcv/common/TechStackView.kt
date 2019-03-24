package com.example.mayoufcv.common

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.mayoufcv.R
import com.google.android.flexbox.FlexboxLayout
import com.google.android.flexbox.FlexboxLayout.*
import com.google.android.material.button.MaterialButton

class TechStackView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttribute: Int = 0)
    : FlexboxLayout(context, attrs, defStyleAttribute) {

    fun populateViews(data: List<String>) {
        data.forEach {
            val button = MaterialButton(context)
            button.text = it
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.tech_stack_text_size))
            val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(context.resources.getDimensionPixelSize(R.dimen.tech_stack_margin_horizontal),
                layoutParams.topMargin,
                context.resources.getDimensionPixelSize(R.dimen.tech_stack_margin_horizontal),
                layoutParams.bottomMargin)
            button.layoutParams = layoutParams
            addView(button)
        }
    }
}

@BindingAdapter("dataset")
fun setDataset(techStackView: TechStackView, data: List<String>) {
    techStackView.removeAllViews()
    techStackView.populateViews(data)
}