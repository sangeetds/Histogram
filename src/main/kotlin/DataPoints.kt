import kotlin.math.ceil

class DataPoints(private val values: List<Long>) {
    val maxValue: Long = values.maxByOrNull { it } ?: 1

    fun segregate(bucketSize: Long): MutableList<Long> {
        val buckets = MutableList(ceil(this.maxValue / bucketSize.toDouble()).toInt()) { 0L }

        this.values.forEach { num ->
            val index = ((num - 1) / bucketSize).toInt()
            buckets[index]++
        }

        return buckets
    }
}