package com.plcoding.stockmarketapp.presentation.company_listings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListCard(name: String, symbol: String, exchange: String) {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
//            Text(
//                text = name,
//                style = MaterialTheme.typography.body1,
//                color = Color.Black,
//            )
//            Text(
//                text = exchanhe,
//                style = MaterialTheme.typography.body2,
//                color = Color.Yellow
//            )


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 2.dp, horizontal = 2.dp)
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.White,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.padding(2.dp)
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = exchange,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(5.dp),

                        color = Color.White,
                        textAlign = TextAlign.End,
                    )
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "(${symbol})",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(top = 0.dp, start = 5.dp, end = 0.dp, bottom = 5.dp),
                    color = Color.Gray
                )
            }

        }

    }
}