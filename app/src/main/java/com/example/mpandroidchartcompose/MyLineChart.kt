package com.example.mpandroidchartcompose

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.example.mpandroidchartcompose.ui.theme.MpAndroidChartComposeTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun MyLineChart(
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            val lineChart = LineChart(context)

            // 初始化 LineEntries 列表
            val lineEntriesList = ArrayList<Entry>().apply {
                add(Entry(1f, 5f))
                add(Entry(2f, 4f))
                add(Entry(3f, 3f))
                add(Entry(4f, 2f))
                add(Entry(5f, 1f))
                add(Entry(6f, 5f))
                add(Entry(7f, 4f))
                add(Entry(8f, 3f))
                add(Entry(9f, 2f))
                add(Entry(10f, 1f))
            }

            // 创建 LineDataSet 和 LineData
            val lineDataSet = LineDataSet(lineEntriesList, "Line Chart Data").apply {
                color = ContextCompat.getColor(context, R.color.purple_200)
                valueTextColor = Color.RED
                valueTextSize = 25f
                lineWidth = 2.5f
                setDrawCircles(true)
                setDrawCircleHole(false)
                circleRadius = 5f
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
                invalidate() // 刷新图表
            }

            lineChart
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyLineChartPreview() {
    MpAndroidChartComposeTheme {
        MyLineChart()
    }
}