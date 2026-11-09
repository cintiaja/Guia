package com.example.tour.ui.theme.Tour1

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tour.R
import com.example.tour.ui.theme.TourTheme

@Composable
fun TourImagenes(
) {
    val fotos = listOf(
        R.drawable.foto1,//android no permite que las fotos se llamen de laguna forma que empiece como nuemero
        R.drawable.foto2,
        R.drawable.foto3,
        R.drawable.foto4
    )

    val estadoPager =
        rememberPagerState(pageCount = { fotos.size })//se guarda la foto que estara mostrandose en el carrusel
    //el fotos.size cuanta cuantas fotos son

    HorizontalPager(
        state = estadoPager,
        modifier = Modifier
            .fillMaxWidth()//size ocupa todo el espacio la foto con width es que la foto no ocupe todo
            .height(250.dp)//puedes hacer eso en vez de poner todo largo
    ) { pagina ->
        Image(//es el contador de las fotos para que puedan pasar, es el orden.
            painter = painterResource(id = fotos[pagina]),//carga las fotos
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,//recorta para ahorrar el espacio
            //Fit hace  ue se muestre todo
            //crop hace que sea toda la pantalla
            contentDescription = "Foto ${pagina + 1}"//descricion de la foto
        )
    }
}