import kotlin.math.ceil

/**
 * Class for holding the numbers for which the histograms is build.
 */
class DataPoints(private val values: List<Long>) {
    val maxValue: Long = values.maxByOrNull { it } ?: 1

    /**
     * The function segregates each data point to it's respective bucket on the basis of the given
     * bucket size.
     * @param bucketSize Long,
     * @return the interval list for which the histogram is made.
     */
    fun segregate(bucketSize: Long): List<Long> {
        val buckets = MutableList(ceil(this.maxValue / bucketSize.toDouble()).toInt()) { 0L }

        this.values.forEach { num ->
            val index = ((num - 1) / bucketSize).toInt()
            buckets[index]++
        }

        return buckets
    }
}