package com.example.youtubeapi34.di

import com.example.youtubeapi34.repostiroy.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single { Repository(get()) }
}