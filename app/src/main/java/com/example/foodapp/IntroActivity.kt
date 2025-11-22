package com.example.foodapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
@Preview
fun IntroScreenPreview(){
    IntroScreen(onGetStartedClick = {})
}

@Composable
fun IntroScreen(onGetStartedClick: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Color.White)
        ) {
            val (backgroundImage, logoImage, titleText, subtitleText, buttonBox) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.background_intro),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImage){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
                    .height(700.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "Food Delivery App",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF3D33A8),
                modifier = Modifier
                    .constrainAs(titleText){
                        bottom.linkTo(logoImage.top, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }

            )
        }
    }

}