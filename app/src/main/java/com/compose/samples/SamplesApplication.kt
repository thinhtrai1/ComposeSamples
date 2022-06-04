package com.compose.samples

import android.app.Application
import androidx.compose.samples.crane.util.UnsplashSizingInterceptor
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.annotation.ExperimentalCoilApi
import com.example.jetcaster.Graph
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SamplesApplication: Application(), ImageLoaderFactory {

    @OptIn(ExperimentalCoilApi::class)
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .componentRegistry {
                add(UnsplashSizingInterceptor)
            }
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}