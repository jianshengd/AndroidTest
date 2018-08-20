package com.example.jianshengd.kotline

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.my_view.view.*


/**
 * Created by Administrator on 2018/8/17
 */
class MyView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init{
        LayoutInflater.from(context).inflate(R.layout.my_view,this,true)
        myTextView.text="hello myView"
    }
}