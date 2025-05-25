package com.ucb.examen.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.examen.flex10.Home10UI
import com.ucb.examen.flex8.Home8UI
import com.ucb.examen.flex5.Home5UI
import com.ucb.examen.mapa.MapaUI


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home5Screen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    )
    {
        composable(Screen.Home8Screen.route)
        {
            Home8UI(
                onDereClick = {
                    navController.navigate(Screen.Home10Screen.route)
                },
                onIzqClick = {
                    navController.navigate(Screen.Home5Screen.route)
                },
                onMapaClick = {
                    navController.navigate(Screen.MapaScreen.createRoute("plan_flex_8"))
                }
            )
        }
        composable(Screen.Home5Screen.route)
        {
            Home5UI(
                onDereClick = {
                    navController.navigate(Screen.Home8Screen.route)
                },
                onIzqClick = {
                    navController.navigate(Screen.Home10Screen.route)
                },
                onMapaClick = {
                    navController.navigate(Screen.MapaScreen.createRoute("plan_flex_5"))
                }
            )
        }

        composable(Screen.Home10Screen.route)
        {
            Home10UI(
                onDereClick = {
                    navController.navigate(Screen.Home5Screen.route)
                },
                onIzqClick = {
                    navController.navigate(Screen.Home8Screen.route)
                },
                onMapaClick = {
                    navController.navigate(Screen.MapaScreen.createRoute("plan_flex_10"))
                }
            )
        }

        composable( route = "mapa/{plan}")
        { backStackEntry ->
            val plan = backStackEntry.arguments?.getString("plan") ?: "Plan Desconocido"
            MapaUI(
                onBackClick = { navController.popBackStack() },
                plan = plan
            )
        }


    }
}