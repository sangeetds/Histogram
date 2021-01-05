class DataPoints(val values: List<Long>) {
    val maxValue: Long = values.maxByOrNull { it } ?: 1

    fun segregate(buckets: MutableList<Long>, bucketSize: Long) {
        this.values.forEach { num ->
            val index = ((num - 1) / bucketSize).toInt()
            buckets[index]++
        }
    }
}