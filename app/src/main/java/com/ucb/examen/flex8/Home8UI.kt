package com.ucb.examen.flex8

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.ucb.examen.R
import com.ucb.examen.flex5.Home5UI

@Composable
fun Home8UI(onDereClick: () -> Unit, onIzqClick: () -> Unit, onMapaClick: () -> Unit) {
    val context = LocalContext.current
    val primaryColor = Color(0xFF1976D2)
    val accentColor = Color(0xFF43A047)
    val backgroundColor = Color(0xFFF0F4F8)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Nuestros planes móviles",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Cobertura excelente, beneficios únicos,\ny un compromiso con el planeta.",
            fontSize = 16.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = onIzqClick, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Izquierda",
                            tint = primaryColor
                        )
                    }

                    Text(
                        text = "Plan FLEX 8",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryColor
                    )

                    IconButton(onClick = onDereClick, modifier = Modifier.size(36.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Derecha",
                            tint = primaryColor
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        append("Antes ")
                        withStyle(
                            SpanStyle(
                                textDecoration = TextDecoration.LineThrough,
                                color = Color.Gray
                            )
                        ) {
                            append("$370")
                        }
                        append(" /mes")
                    },
                    fontSize = 16.sp
                )

                Text(
                    text = "$299 /mes",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = accentColor
                )

                Text(
                    text = "8GB",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                val beneficios = listOf(
                    "Llamadas y SMS ilimitados",
                    "Hotspot incluido",
                    "Redes Sociales sin límite",
                    "Personaliza tu plan",
                    "Compensación de CO2"
                )

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    beneficios.forEach {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("✔", color = accentColor, fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(it, fontSize = 14.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.redes),
                    contentDescription = null,
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onMapaClick,
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Quiero este plan",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                IconButton(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW)
                        val url =
                            "https://api.whatsapp.com/send?phone=+59169466163&text=" + Uri.encode("Hola, UCB mobile, preciso su ayuda")
                        intent.data = Uri.parse(url)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.End)
                        .offset(x = 5.dp ,y = (-60).dp)
                        .background(Color.White, CircleShape)
                        .border(1.dp, Color.LightGray, CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.iconowhat),
                        contentDescription = "WhatsApp",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Home8UIPreview() {
    Home8UI(
        onDereClick = {},
        onIzqClick = {},
        onMapaClick = {}
    )
}