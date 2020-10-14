package com.hb.mycomposeuisample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewFromCompose()
    }

    @Composable
    private fun setContentViewFromCompose() {
        setContent {
            Stack(modifier = Modifier.fillMaxSize()) {
                Button(onClick = { Toast.makeText(this@MainActivity, "0", Toast.LENGTH_LONG).show() }, modifier = Modifier.gravity(Alignment.Center)) {
                    Text(text = "tvtv")
                }
            }
        }
    }

}
