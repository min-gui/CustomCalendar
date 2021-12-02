package com.example.calendertest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class HorizontalFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_horizontal,container,false)
        val textView = view.findViewById<TextView>(R.id.tv_text)

        textView.text="test"


        return view
    }
}