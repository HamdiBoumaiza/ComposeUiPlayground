package com.hb.mycomposeuisample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class ConstraintLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutContent()
        }
    }

    @Composable
    fun ConstraintLayoutContent() {
        ConstraintLayout {
            // Create references for the composables to constrain
            val (button, text) = createRefs()

            Button(
                    onClick = { /* Do something */ },
                    // Assign reference "button" to the Button composable
                    // and constrain it to the top of the ConstraintLayout
                    modifier = Modifier.constrainAs(button) {
                        top.linkTo(parent.top, margin = 16.dp)
                    }
            ) {
                Text("Button")
            }

            // Assign reference "text" to the Text composable
            // and constrain it to the bottom of the Button composable
            Text("Text", Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            })
        }
    }
}
