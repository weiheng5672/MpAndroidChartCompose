package com.example.mpandroidchartcompose

import com.github.mikephil.charting.data.Entry

val years = (1951..2023).toList().map { it.toFloat() }

val data = listOf(955316317,1076022820,
    1224826874,
    1402548324,
    1496666215,
    1769908228,
    2084424666,
    2416369727,
    2769844171,
    3135727261,
    3528129419,
    4065485183,
    4366678735,
    5185327196,
    5672212374,
    6480780352,
    7469753968,
    8762154199,
    10050753666,
    11963647557,
    13836002258,
    16080808891,
    17938474183,
    18880734237,
    21216825821,
    24744064017,
    27607246583,
    31864361567,
    35320579327,
    37947084699,
    37447713001,
    38155718006,
    42318624633,
    45826958088,
    47919101822,
    53812861713,
    59174751488,
    65227727033,
    69251809494,
    74344947489,
    80977405302,
    85290353628,
    92084684170,
    98561004240,
    105368000000,
    111140000000,
    118299000000,
    128130000000,
    131726000000,
    142413000000,
    143624000000,
    151193000000,
    159380000000,
    167478000000,
    175293000000,
    181593000000,
    187075000000,
    186931000000,
    179239000000,
    193313000000,
    198637000000,
    198391000000,
    201945000000,
    205956000000,
    206491000000,
    212531000000,
    217213000000,
    219108000000,
    218727000000,
    224813000000,
    235341000000,
    236763000000,
    233038000000,).map { it.toFloat() }


val pairs = years.zip(data)

val lineEntriesList = pairs.map { (x,y) -> Entry(x,y) }

object DataUtils {
    /**
     * Returns list of points
     * @param listSize: Size of total number of points needed.
     * @param start: X values to start from. ex: 50 to 100
     * @param maxRange: Max range of Y values
     */
    fun getLineChartData(listSize: Int, start: Int = 0, maxRange: Int): List<Entry> {
        val list = arrayListOf<Entry>()
        for (index in 0 until listSize) {
            list.add(
                Entry(
                    index.toFloat(),
                    (start until maxRange).random().toFloat()
                )
            )
        }
        return list
    }


}




























