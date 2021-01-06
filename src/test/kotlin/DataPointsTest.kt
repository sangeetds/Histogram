import org.junit.Test
import kotlin.test.assertEquals

class DataPointsTest {

    @Test
    fun `Empty List gives max value as 1`() {
        val dataPoints = DataPoints(values = listOf())
        assertEquals(1, dataPoints.maxValue)
    }

    @Test
    fun `List with max value 10 gives max value as 10`() {
        val dataPoints = DataPoints(values = listOf(1, 4, 7, 10))
        assertEquals(10, dataPoints.maxValue)
    }

    @Test
    fun `Bucket Size of 10 with 7 equidistributed numbers gives 7 equal size buckets`() {
        val dataPoints = DataPoints(values = listOf(1, 11, 22, 33, 44, 55, 66))
        val bucket = 10L

        assertEquals(listOf<Long>(1, 1, 1, 1, 1, 1, 1), dataPoints.segregate(bucketSize = bucket))
    }
}