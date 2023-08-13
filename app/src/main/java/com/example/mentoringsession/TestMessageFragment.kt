package com.example.mentoringsession

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mentoringsession.R.*

class TestMessageFragment(val callback: (message: String)-> Unit): Fragment() {


    lateinit var mainView: View


    override fun onCreateView(inflatter: LayoutInflater, container: ViewGroup?
    ,savedInstanceState: Bundle?): View?{
val view =  inflatter.inflate(layout.fragment_test_message, container, false)

   return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mButton = mainView.findViewById<Button>(R.id.button_first)


        val mActivity = requireActivity() as NewActivitySession

   mButton.setOnClickListener{
       callback("message")
   }

    }
}