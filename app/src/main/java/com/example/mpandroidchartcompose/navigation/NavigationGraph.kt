package com.example.mpandroidchartcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mpandroidchartcompose.ui.HomeScreen
import com.example.mpandroidchartcompose.ui.MyBarChat
import com.example.mpandroidchartcompose.ui.MyLineChart
import com.example.mpandroidchartcompose.ui.RealLineChart


@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        //預設顯示 HomeScreen
        startDestination = NavigationRoutes.HomeDestination.route,
        modifier = modifier
    ) {

        composable(route = NavigationRoutes.HomeDestination.route) {

            HomeScreen(

                navigateToBarChart = { navController.navigate(NavigationRoutes.BarDestination.route) },

                navigateToLineChart = { navController.navigate(NavigationRoutes.LineDestination.route) },

                navigateToRealLineChart = { navController.navigate(NavigationRoutes.RealLineDestination.route) }

            )

        }


        composable(route = NavigationRoutes.BarDestination.route) {

            MyBarChat(

                navigateBack = { navController.navigate(NavigationRoutes.HomeDestination.route) }

            )

        }

        composable(route = NavigationRoutes.LineDestination.route) {

            MyLineChart(

                navigateBack = { navController.navigate(NavigationRoutes.HomeDestination.route) }

            )

        }

        composable(route = NavigationRoutes.RealLineDestination.route) {

            RealLineChart(

                navigateBack = { navController.navigate(NavigationRoutes.HomeDestination.route) }

            )

        }



    }

}