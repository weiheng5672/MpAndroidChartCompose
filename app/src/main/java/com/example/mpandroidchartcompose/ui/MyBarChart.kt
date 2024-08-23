package com.example.mpandroidchartcompose.ui

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.mpandroidchartcompose.InventoryTopAppBar
import com.example.mpandroidchartcompose.R
import com.example.mpandroidchartcompose.navigation.NavigationRoutes
import com.example.mpandroidchartcompose.ui.theme.MpAndroidChartComposeTheme
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBarChat(
    navigateBack: () -> Unit,
){
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(NavigationRoutes.BarDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }
    ) {
        innerPadding ->

        AndroidView(

            modifier = Modifier
                .padding(innerPadding) // Apply the inner padding from Scaffold
                .fillMaxSize(),

            factory = { context ->
                // 创建 BarChart 实例
                val barChart = BarChart(context)

                // 初始化 BarEntries 列表
                val values = listOf(5f, 4f, 3f, 2f, 1f, 5f, 4f, 3f, 2f, 1f)

                val barEntriesList = ArrayList<BarEntry>().apply {
                    values.forEachIndexed { index, value ->
                        add(BarEntry((index + 1).toFloat(), value))
                    }
                }

                // 创建 BarDataSet 和 BarData
                val barDataSet = BarDataSet(barEntriesList, "Bar Chart Data").apply {
                    valueTextColor = Color.RED
                    setColor(ContextCompat.getColor(context, R.color.purple_200))
                    valueTextSize = 25f
                }

                val barData = BarData(barDataSet)

                // 设置 BarChart 数据和属性
                barChart.apply {
                    data = barData
                    description.isEnabled = false
                    invalidate() // 刷新图表
                }

                barChart

            }
        )


    }

}




@Preview(showBackground = true)
@Composable
fun MyBarChatPreview() {
    MpAndroidChartComposeTheme {
        MyBarChat(
            navigateBack = {}
        )
    }
}
