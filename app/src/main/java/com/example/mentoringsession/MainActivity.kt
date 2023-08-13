package com.example.mentoringsession

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mentoringsession.ui.theme.MentoringSessionTheme
import com.example.mentoringsession.ui.theme.NewActivity
import com.example.mentoringsession.ui.theme.ui.theme.CustomModel


class MainActivity : ComponentActivity() {
    companion object{const val result_code_model = 0}

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, NewActivity::class.java)


        setContent {
            MentoringSessionTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .clickable { },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var username = remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = username.value,
                        onValueChange = { username.value = it },
                        label = { Text(text = "Username") })
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(onClick = {
                        Toast.makeText(baseContext, username.value, Toast.LENGTH_LONG).show()

                        val intent = Intent(this@MainActivity, NewActivity::class.java)
                        intent.putExtra("username_key", username.value)
                        val customModel = CustomModel("12", username.value)
                        intent.putExtra("My_Custom_Model", customModel)
                        startActivity(intent)


                    }) {
                        Text(text = "Submit")


                    }


                }


            }
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == result_code_model) {
            val message = data!!.getStringExtra("result_Message")
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}

