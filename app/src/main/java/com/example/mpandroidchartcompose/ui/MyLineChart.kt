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
import com.example.mpandroidchartcompose.lineEntriesList
import com.example.mpandroidchartcompose.navigation.NavigationRoutes
import com.example.mpandroidchartcompose.ui.theme.MpAndroidChartComposeTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLineChart(
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            InventoryTopAppBar(
                title = stringResource(NavigationRoutes.LineDestination.titleRes),
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
                val lineChart = LineChart(context)

                // 初始化 LineEntries 列表
                val lineEntriesList = lineEntriesList


                // 创建 LineDataSet 和 LineData
                val lineDataSet = LineDataSet(lineEntriesList, "Line Chart Data").apply {
                    color = ContextCompat.getColor(context, R.color.purple_200)
                    lineWidth = 2.5f
                    setDrawCircles(true)
                    setDrawCircleHole(false)
                    setDrawValues(false)
                }

                val lineData = LineData(lineDataSet)

                // 设置 LineChart 数据和属性
                lineChart.apply {
                    data = lineData
                    description.isEnabled = false
                    legend.isEnabled = false
                    axisLeft.isEnabled = true
                    axisRight.isEnabled = false
                    xAxis.isEnabled = true
                    xAxis.setDrawLabels(true)
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.valueFormatter = CustomYearValueFormatter()
                    axisLeft.valueFormatter = CustomEnergyValueFormatter()
                    invalidate() // 刷新图表
                }

                lineChart
            }
        )

    }
}

class CustomEnergyValueFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        // 自定义格式化逻辑，例如将值除以 1,000,000,000 并添加 "G" 单位
        return "${value / 1_000_000_000}G"
    }
}

class CustomYearValueFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        // 不使用千位分隔符，直接将数字转为整数格式显示
        return value.toInt().toString()
    }
}

@Preview(showBackground = true)
@Composable
fun MyLineChartPreview() {
    MpAndroidChartComposeTheme {
        MyLineChart(
            navigateBack = {}
        )
    }
}