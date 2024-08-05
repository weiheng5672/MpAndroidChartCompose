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
    // BarEntry 是 MPAndroidChart 庫中的一個類
    // 用來表示條形圖中的單個條形數據點
    // 每個 BarEntry 代表條形圖上的一個條形
    // 並包含條形的 x 軸和 y 軸數據
    lateinit var barEntriesList: ArrayList<BarEntry>

    // BarDataSet 是條形圖數據的核心部分
    // 它包含了要顯示的數據，並提供了豐富的樣式配置選項
    // 使得條形圖可以根據需求進行個性化設置
    lateinit var barDataSet: BarDataSet

    // BarData 是 BarDataSet 的容器
    // 允許將多個數據集（BarDataSet）組織在一起
    // 從而在同一個條形圖上顯示多個數據集
    // 這樣可以實現多系列數據的比較和展示
    lateinit var barData: BarData

    // BarChart 是 MPAndroidChart 庫中的一個類
    // 用於在 Android 應用中繪製條形圖（Bar Chart）
    // 我們準備好資料後，將其設置給 BarChart
    // BarChart 會根據提供的數據自動生成圖表
    lateinit var barChart: BarChart


    fun getBarChartData() {

        // 初始化 barEntriesList
        barEntriesList = ArrayList()

        // 添加數據到 barEntriesList
        // x: 條形在 x 軸上的位置
        // y: 條形的值（即條形的高度）
        barEntriesList.add(BarEntry(1f, 5f))
        barEntriesList.add(BarEntry(2f, 4f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 2f))
        barEntriesList.add(BarEntry(5f, 1f))

    }

    AndroidView(

        modifier = modifier.fillMaxSize(),

        factory = { context ->

            barChart = BarChart(context)

            // 準備圖表的數據
            getBarChartData()

            // 初始化 BarDataSet 對象
            // 傳入 barEntriesList 作為數據，"Bar Chart Data" 為數據集的標籤
            barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")

            // 用 BarDataSet 創建 BarData
            // BarData 用於將數據集組織在一起
            barData = BarData(barDataSet)

            // 設置 BarChart 的數據
            // 將準備好的數據傳遞給 barChart
            barChart.data = barData

            // 以下設定圖表的細節

            // 設置數據點值的文本顏色
            barDataSet.valueTextColor = Color.RED

            // 設置條形圖的顏色
            // 使用 ContextCompat.getColor 獲取顏色資源
            barDataSet.setColor(ContextCompat.getColor(context, R.color.purple_200))

            // 設置數據點值的字型大小
            barDataSet.valueTextSize = 25f

            // 關閉圖表的描述文本
            // 如果不需要圖表的描述信息，可以禁用描述
            barChart.description.isEnabled = false

            // Refresh and return the chart
            barChart.invalidate()
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