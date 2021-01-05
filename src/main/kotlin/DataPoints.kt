class DataPoints(val values: List<Long>) {
    val maxValue: Long = values.maxByOrNull { it } ?: 1
}