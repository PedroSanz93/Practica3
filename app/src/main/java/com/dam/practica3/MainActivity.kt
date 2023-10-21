package com.dam.practica3

import SampleData1
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                        Conversation(SampleData1.conversationSample1)
                    }
                }
            }
        }
    }

    //MENSAJE 1
    data class Mensaje1(val author: String, val body: String)
    @Composable
    fun MensajeCard1(msg: Mensaje1) {
        if (msg.author == "Diego") {

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)

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
                        .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)

                )
                Spacer(modifier = Modifier.width(1.dp))

                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    border = BorderStroke(1.5.dp, color = MaterialTheme.colorScheme.tertiary),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(10.dp)
                        .animateContentSize()
                ) {
                    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                        Text(
                            text = msg.author,
                            modifier = Modifier.padding(2.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = msg.body,
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            modifier = Modifier.padding(2.dp)

                        )
                    }
                }
            }
        }
        else if(msg.author == "Raimundo"){
            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(if(isExpanded)MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Surface(color =  MaterialTheme.colorScheme.tertiary,
                    border = BorderStroke(1.dp, color= MaterialTheme.colorScheme.primary),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(10.dp)

                ){
                    Column (modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                        Text(
                            text = msg.author,
                            modifier = Modifier
                                .padding(2.dp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = msg.body,
                            modifier = Modifier
                                .padding(2.dp),
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun MensajeCard2(msg: Mensaje1) {


    }
    @Composable
    fun Conversation(messages: List<Mensaje1>){
        LazyColumn(){
            items(messages){
                    messages->
                MensajeCard1(messages)
                MensajeCard2(messages)
            }
        }
    }

    /*
    @Preview(showBackground = true)
    @Composable
    fun MensajeCard1Preview() {
        Practica3Theme {
            MensajeCard1(msg = Mensaje1("Diego", "Que pasa chavales como estais, yo aqui viendo la tele"))
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun MensajeCard2Preview() {
        Practica3Theme {
            MensajeCard2(msg = Mensaje1("Raimundo","Yo no tengo tele la he venido primo"))
        }
    }
*/

    @Preview
    @Composable
        fun PreviewConversation(){
            Practica3Theme {
                Conversation(messages = SampleData1.conversationSample1)
            }
        }

}


