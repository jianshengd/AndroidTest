package com.example.jianshengd.kotline

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.kotlin_main.*
class KotlinActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kotlin_main)
        clearFindViewByIdCache();
        textView.text="hello Kotlin"
//        var fragmentManager:FragmentManager=getFragmentManager()
//        var transaction : FragmentTransaction =fragmentManager.beginTransaction()
//        transaction.add(
//                R.id.fragment, BlankFragment.newInstance("1","2")).co
    }
}
