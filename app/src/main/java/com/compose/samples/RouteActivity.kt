package com.compose.samples

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.compose.samples.ui.theme.ComposeSamplesTheme
import kotlin.reflect.KClass

class RouteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSamplesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        CommonText("Crane", androidx.compose.samples.crane.home.MainActivity::class)
                        CommonText("Jetcaster", com.example.jetcaster.ui.MainActivity::class)
                        CommonText("Jetchat", com.example.compose.jetchat.NavActivity::class)
                        CommonText("Jetnews", com.example.jetnews.ui.MainActivity::class)
                        CommonText("Jetsnack", com.example.jetsnack.ui.MainActivity::class)
                        CommonText("Jetsurvey", com.example.compose.jetsurvey.MainActivity::class)
                        CommonText("Owl", com.example.owl.ui.MainActivity::class)
                        CommonText("Rally", com.example.compose.rally.RallyActivity::class)
                        CommonText("MotionCompose", com.example.android.compose.motion.MainActivity::class)
                    }
                }
            }
        }
    }

    @Composable
    fun CommonText(text: String, kClass: KClass<*>) {
        Button(
            onClick = {
                startActivity(Intent(this, kClass.java))
            },
        ) {
            Text(
                text = text,
            )
        }
    }
}