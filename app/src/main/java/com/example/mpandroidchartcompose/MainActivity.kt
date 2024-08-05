package com.example.mpandroidchartcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mpandroidchartcompose.ui.theme.MpAndroidChartComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MpAndroidChartComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MyChartApp()
                }
            }
        }
    }

}
