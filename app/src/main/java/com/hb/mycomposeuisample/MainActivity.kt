package com.hb.mycomposeuisample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
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
            val textModifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
            setButton(getString(R.string.create_list),
                    { startComposeActivity(ListActivity()) },
                    textModifier
            )
            setButton(getString(R.string.constraint_example),
                    { startComposeActivity(ConstraintLayoutActivity()) },
                    textModifier
            )
            setButton(getString(R.string.rows_example),
                    { startComposeActivity(RowLayoutActivity()) },
                    textModifier
            )
            setButton(getString(R.string.stacks_example),
                    { startComposeActivity(StackLayoutActivity()) },
                    textModifier
            )
        }
    }

    @Composable
    private fun setButton(text: String,
                          onClick: () -> Unit,
                          modifier: Modifier) {
        Button(
                onClick = { onClick() },
                modifier = modifier,
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.Black
        ) {
            Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    color = Color.White,
            )
        }
    }

    private fun startComposeActivity(activity: Activity) {
        startActivity(Intent(this, activity::class.java))
    }
}
