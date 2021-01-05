import kotlin.math.ceil

class Histogram {

    fun createSections(bucketSize: Long,
                        dataPoints: DataPoints) : List<Triple<Long, Long, Long>> {
        val buckets = MutableList(ceil(dataPoints.maxValue / bucketSize.toDouble()).toInt()) { 0L }
        dataPoints.segregate(buckets = buckets, bucketSize = bucketSize)

        var initial = 0L

        return buckets.map { count ->
            initial += bucketSize
            Triple(initial - bucketSize + 1, initial, count)
        }
    }

}