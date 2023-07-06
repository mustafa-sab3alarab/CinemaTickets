package com.example.cinematickets.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cinematickets.AppDestination

fun NavGraphBuilder.homeRoute(navHostController : NavHostController){
    composable(AppDestination.HomeScreen.route) { HomeScreen(navHostController) }
}