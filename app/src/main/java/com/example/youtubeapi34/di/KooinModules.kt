package com.example.youtubeapi34.di

import com.example.youtubeapi34.remote.networkModule

val koinModules = listOf(
    repoModules,
    viewModules,
    networkModule
)