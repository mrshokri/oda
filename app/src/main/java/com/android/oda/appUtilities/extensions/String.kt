package com.android.oda.appUtilities.extensions

import java.math.RoundingMode
import java.text.DecimalFormat

fun String.asGrossFormatted(): String {
    return "kr " + replace(".", ",")
}

fun String.asTotalNumberFormatted(): String {
    return "$this varer"
}

fun String.asGrossFormattedPerUnit(): String {
    return "kr " + replace(".", ",") + "/kg"
}

fun Double.asPriceFormatted(): String {
    val df = DecimalFormat("#,###.##")
    df.roundingMode = RoundingMode.CEILING
    return "kr " + df.format(this).replace(",", " ")
}

