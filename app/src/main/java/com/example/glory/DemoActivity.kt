package com.example.glory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.glory.navigation.AppNavGraph
import com.example.glory.ui.theme.GloryTheme

class DemoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GloryTheme {
                AppNavGraph()
            }
        }
    }
}
