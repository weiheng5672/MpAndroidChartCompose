package com.example.mpandroidchartcompose

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.mpandroidchartcompose.ui.theme.MpAndroidChartComposeTheme
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


@Composable
fun MyBarChat(
    modifier: Modifier = Modifier
){
    AndroidView(

        modifier = modifier.fillMaxSize(),
        factory = { context ->
            // 创建 BarChart 实例
            val barChart = BarChart(context)

            // 初始化 BarEntries 列表
            val barEntriesList = ArrayList<BarEntry>().apply {
                add(BarEntry(1f, 5f))
                add(BarEntry(2f, 4f))
                add(BarEntry(3f, 3f))
                add(BarEntry(4f, 2f))
                add(BarEntry(5f, 1f))
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MpAndroidChartComposeTheme {
        MyBarChat()
    }
}
