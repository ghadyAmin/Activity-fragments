package com.example.mentoringsession

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mentoringsession.ui.theme.MentoringSessionTheme

class NewActivitySession : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_test_message)
        initializeFragment()
    }
    private fun initializeFragment(){
        val mFragment = TestMessageFragment(callback = { message ->
            showFragmentMessage(message)
        })

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, mFragment).commit()
    }
    fun showFragmentMessage(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}