package com.example.mpandroidchartcompose.navigation

import com.example.mpandroidchartcompose.R

sealed class NavigationRoutes(
    val route: String,
    val titleRes: Int
) {

    data object HomeDestination : NavigationRoutes(
        route = "home",
        titleRes = R.string.home_title
    )

    data object BarDestination : NavigationRoutes(
        route = "bar",
        titleRes = R.string.bar_chart_title
    )

    data object LineDestination : NavigationRoutes(
        route = "line",
        titleRes = R.string.line_chart_title
    )


}