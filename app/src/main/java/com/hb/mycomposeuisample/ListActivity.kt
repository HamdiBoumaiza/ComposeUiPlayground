package com.hb.mycomposeuisample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Feed(listOf(Artist("one", R.drawable.rain_bg),
                    Artist("two", R.drawable.sunny_bg))
            ) {
                Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
            }
        }
    }


    @Composable
    fun Feed(
            feedItems: List<Artist>,
            onSelected: (Artist) -> Unit
    ) {
        ScrollableColumn(Modifier.fillMaxSize()) {
            feedItems.forEach {
                ArtistCard(it) { artist ->
                    onSelected(artist)
                }
            }
        }
    }

    @Composable
    fun ArtistCard(
            artist: Artist,
            onClick: (Artist) -> Unit
    ) {
        val padding = 16.dp
        Column(
                Modifier
                        .clickable(onClick = { onClick(artist) })
                        .padding(padding)
                        .fillMaxWidth()
        ) {
            val imageModifier = Modifier
                    .preferredHeight(200.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))

            Image(imageResource(id = artist.avatar),
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop)
            Spacer(Modifier.preferredHeight(16.dp))
            Text(artist.name.toUpperCase())
            val textModifier = Modifier.gravity(Alignment.CenterHorizontally)
            Text(modifier = textModifier, text = artist.name)

        }
    }

}


data class Artist(val name: String, val avatar: Int)