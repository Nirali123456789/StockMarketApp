package com.plcoding.stockmarketapp.presentation.company_info

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.stockmarketapp.ui.theme.DarkBlue
import com.ramcosta.composedestinations.annotation.Destination
import com.plcoding.stockmarketapp.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
@Destination
fun CompanyInfoScreen(
    symbol: String,
    viewModel: CompanyInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "Company Info", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = stringResource(id = R.string.back),
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black)
            )
        }
    ) { innerPadding ->
        if (state.error == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(16.dp)
            ) {
                state.company?.let { company ->
                    Text(
                        text = company.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                        , color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = company.symbol,
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp,

                        modifier = Modifier.fillMaxWidth()
                        , color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Industry: ${company.industry}",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        overflow = TextOverflow.Ellipsis
                        , color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Country: ${company.country}",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        overflow = TextOverflow.Ellipsis
                        , color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = company.description,
                        fontSize = 12.sp,
                        modifier = Modifier.fillMaxWidth(),
                         color = Color.White
                    )
                    if (state.stockInfos.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Market Summary", color = Color.White)
                        Spacer(modifier = Modifier.height(32.dp))
                        StockChart(
                            infos = state.stockInfos,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)

                                .align(Alignment.CenterHorizontally)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            } else if (state.error != null) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error
                )
            }
        }
    }
}

