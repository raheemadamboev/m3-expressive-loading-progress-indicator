package xyz.teamgravity.m3expressiveloadingprogressindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.teamgravity.m3expressiveloadingprogressindicator.ui.theme.M3ExpressiveLoadingProgressIndicatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M3ExpressiveLoadingProgressIndicatorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        val progress by rememberInfiniteTransition().animateFloat(
                            initialValue = 0F,
                            targetValue = 1F,
                            animationSpec = infiniteRepeatable(
                                animation = tween(
                                    durationMillis = 6_000
                                )
                            )
                        )

                        LoadingIndicator()
                        ContainedLoadingIndicator()
                        CircularProgressIndicator()
                        CircularWavyProgressIndicator()
                        LinearProgressIndicator()
                        LinearWavyProgressIndicator()
                        HorizontalDivider()
                        CircularProgressIndicator(
                            progress = { progress }
                        )
                        CircularWavyProgressIndicator(
                            progress = { progress }
                        )
                        LinearProgressIndicator(
                            progress = { progress }
                        )
                        LinearWavyProgressIndicator(
                            progress = { progress }
                        )
                    }
                }
            }
        }
    }
}