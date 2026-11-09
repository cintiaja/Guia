package com.example.tour.ui.theme.Tour1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Pantalla() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),   // fondo de toda la pantalla
        verticalArrangement = Arrangement.Center
    ) {
        TourImagenes()                          // el carrusel
        Spacer(modifier = Modifier.height(16.dp))
        ControlesAudio()                       // los botones de audio
    }
}

