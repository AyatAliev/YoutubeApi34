package com.example.youtubeapi34.di

import com.example.youtubeapi34.ui.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { PlayListViewModel(get()) }
}