package com.dam.practica3

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.practica3.ui.theme.Practica3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        MensajeCard1(msg = Mensaje1("Diego", "Prueba"))

                    }
                }
            }
        }
    }

    //MENSAJE 1
    data class Mensaje1(val author: String, val body: String)
    @Composable
    fun MensajeCard1(msg: Mensaje1) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.diego),
                contentDescription = "cantaor",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(all = 8.dp)
                    .size(60.dp)
                    .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = msg.author
                )
                Text(
                    text = msg.body
                )
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Mensaje1>){ // se crea una lista de mensajes con el nombre Message
        LazyColumn(){
            items(messages){
                    messages->
                MensajeCard1(messages)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MensajeCard1Preview() {
        Practica3Theme {
            MensajeCard1(msg = Mensaje1("Diego", "Prueba"))
        }
    }

    @Preview
    @Composable
    fun PreviewConversation(){
        Practica3Theme {
            Conversation(messages = SampleData.conversationSample)
        }
    }
}