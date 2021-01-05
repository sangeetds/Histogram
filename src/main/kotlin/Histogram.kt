import kotlin.math.ceil

class Histogram(
    private val bucketSize: Long,
    private val dataPoints: DataPoints
    ) {

    private val buckets: LongArray = LongArray(ceil(dataPoints.maxValue / bucketSize.toDouble()).toInt())

    fun createSections() : List<Triple<Long, Long, Long>> {
        dataPoints.segregate()

        var initial = 0L

        return buckets.map { count ->
            initial += bucketSize
            Triple(initial - bucketSize + 1, initial, count)
        }
    }

    private fun DataPoints.segregate() {
        this.values.forEach { num ->
            val index = ((num - 1) / bucketSize).toInt()
            buckets[index]++
        }
    }


}