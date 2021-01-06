
class Histogram {

    fun createSections(bucketSize: Long,
                        dataPoints: DataPoints) : List<Interval> {
        val buckets = dataPoints.segregate(bucketSize = bucketSize)

        var initial = 0L
        return buckets.map { count ->
            initial += bucketSize
            Interval(start = initial - bucketSize + 1, end = initial, value = count)
        }
    }

}