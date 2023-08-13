package com.example.mentoringsession.ui.theme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.mentoringsession.MainActivity
import com.example.mentoringsession.ui.theme.ui.theme.CustomModel
import com.example.mentoringsession.ui.theme.ui.theme.MentoringSessionTheme
import androidx.appcompat.app.AppCompatActivity
class NewActivity :  ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usernameValue =  intent.extras?.getParcelable<CustomModel>("My_Custom_Model")

        setContent {
            MentoringSessionTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainView(usernameValue?.username?:"default")
                }
            }
        }
    }

    private fun setResultBack() {
        val intent = Intent()
        intent.putExtra("result_Message", "This is my message ")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    @Composable
    fun MainView(revivedValue: String, modifier: Modifier = Modifier) {
        Column (modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .clickable { }){
            Text(text = revivedValue)
            Button(onClick = {
                 setResultBack()
            }) {
                Text(text = "Back")
            }
        }

    }







    @Preview(showBackground = true)
    @Composable
    fun MainViewPreview() {
        MentoringSessionTheme {
            MainView("hello")
        }
    }





}









