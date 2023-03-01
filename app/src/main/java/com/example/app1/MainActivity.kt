package com.example.app1

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app1.ui.theme.App1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

                    RodendenskaSlika(stringResource(id=R.string.cestitka_text),
                        stringResource(R.string.od_koj)
                    )

                }
            }
        }
    }
}
@Composable
fun RodendenskaSlika(cestitka: String, od: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bday_app)

   Box{
       Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
       Rodendenska(
           cestitka = cestitka,
           od = od
       )
    }
}

@Composable
fun Rodendenska(cestitka: String, od: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = cestitka,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = od,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .align(alignment = Alignment.End)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun RodendenskaPreivew() {
    App1Theme {
        RodendenskaSlika(stringResource(id= R.string.cestitka_text), stringResource(id = R.string.od_koj) )
    }
}