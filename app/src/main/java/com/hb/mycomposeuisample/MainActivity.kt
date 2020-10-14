package com.hb.mycomposeuisample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainMenu()
        }
    }


    @Composable
    fun MainMenu() {
        ScrollableColumn(Modifier.fillMaxSize()) {
            val textModifier = Modifier.gravity(Alignment.CenterHorizontally).padding(16.dp)
            Button(onClick = { startComposeActivity(ListActivity()) }, modifier = textModifier) {
                Text("Create a list with compose")
            }
            Button(onClick = { startComposeActivity(ConstraintLayoutActivity()) }, modifier = textModifier) {
                Text("Constraint Layout example")
            }
        }
    }

    private fun startComposeActivity(activity: Activity) {
        startActivity(Intent(this, activity::class.java))
    }
}
