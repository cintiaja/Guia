package com.example.tour.ui.theme.Tour1

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.tour.R

@Composable
fun ControlesAudio() {
    val contexto =
        LocalContext.current//el contexto es la app en donde estamos, para que corra ahi por que si no no puede

    val reproductor = remember {//para que recuerde pues la cancion cada que pues se actualiza
        MediaPlayer.create(contexto, R.raw.corazon_de_morelos)
            .apply {//el nombre del audio siempre v en minusculas
                setOnCompletionListener { seekTo(0) }//con todo esto le dice que si se acaba el audio por si solo se repita :)
            }
    }

    var estado by remember { mutableStateOf("detenido") }//aqui inicia los votones de reproduccion

    DisposableEffect(Unit) {
        onDispose { reproductor.release() }//cuando la pantalla se cierra hay que cerrarlo o bueno acabarlo por que ocupa mucha memoria

    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Audio: $estado")//recuerda que el $ es como llamar

        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.height(8.dp)) {
            Button(onClick = {
                reproductor.start()
                estado = "reproduciendo"
            }) {
                Text("Play")
            }
            Button(onClick = {
                reproductor.pause()
                estado = "pausada"
            }) {
                Text("Pausa")
            }
            Button(onClick = {
                reproductor.pause()
                estado = "detenido"
            }) {
                Text("Stop")
            }
        }


    }
}
