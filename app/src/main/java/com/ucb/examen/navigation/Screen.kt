package com.ucb.examen.navigation

sealed class Screen (val route: String) {
    object Home5Screen : Screen("plan5")
    object Home8Screen : Screen("plan8")
    object Home10Screen : Screen("plan10")
    object MapaScreen: Screen("mapa/{plan}")
    {
        fun createRoute(plan: String) = "mapa/$plan"
    }
}