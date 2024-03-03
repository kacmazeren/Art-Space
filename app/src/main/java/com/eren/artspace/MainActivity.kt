package com.eren.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eren.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpaceApp ()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentStep by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer),

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(25.dp)
        )
        {

            when (currentStep) {
                1 -> {
                    Image(
                        painter = painterResource(id = R.drawable.photo1),
                        contentDescription = "photo1",
                        modifier = Modifier
                    )
                }

                2 -> {
                    Image(
                        painter = painterResource(id = R.drawable.photo2),
                        contentDescription = "photo2"
                    )
                }

                3 -> {
                    Image(
                        painter = painterResource(id = R.drawable.photo3),
                        contentDescription = "photo3"
                    )

                }
            }
        }
        Row(
            modifier = Modifier
                  .padding(25.dp)
                .fillMaxWidth()
        ) {
            when (currentStep) {
                1 -> Column(
                    modifier = Modifier
                        .absolutePadding(20.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.photo1_photoghrapher),
                        modifier = Modifier
                    )
                    Text(text = stringResource(id = R.string.photo1_content),
                        modifier = Modifier)
                }

                2 -> Column(
                    modifier = Modifier
                        .absolutePadding(20.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.photo2_photoghrapher),
                        modifier = Modifier
                    )
                    Text(text = stringResource(id = R.string.photo2_content),
                        modifier = Modifier)
                }

                3 -> Column(
                    modifier = Modifier
                        .absolutePadding(20.dp)
                        .padding(5.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.photo3_photoghrapher),
                        modifier = Modifier
                    )
                    Text(text = stringResource(id = R.string.photo3_content),
                        modifier = Modifier)
                }
            }
        }
            Row(
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (currentStep<1)
                        currentStep = 3 else currentStep -= 1},
                    modifier = Modifier
                        .absolutePadding(20.dp)
                        .padding(5.dp),
                ) {
                    Text(text = "Previus")
                }
                Button(
                    onClick = {
                        if (currentStep>2)
                            currentStep = 1 else currentStep += 1
                         },
                    modifier = Modifier
                        .absolutePadding(110.dp)
                        .padding(5.dp)
                ) {
                    Text(text = "Next")
                }

            }
        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpaceAppPreview() {
    ArtSpaceTheme {
        // A surface container using the 'background' color from the theme
        ArtSpaceApp ()
    }
}