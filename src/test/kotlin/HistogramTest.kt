import org.junit.jupiter.api.TestInstance
import org.junit.Test
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HistogramTest {
    private val hist = Histogram()

    @Test
    fun `Bucket Size of 10 with 7 equidistributed numbers gives 7 buckets`() {
        assertEquals(listOf(
            Interval(1L, 10L, 1L),
            Interval(11L, 20L, 1L),
            Interval(21L, 30L, 1L),
            Interval(31L, 40L, 1L),
            Interval(41L, 50L, 1L),
            Interval(51L, 60L, 1L),
            Interval(61L, 70L, 1L)
        ), hist.createSections(bucketSize = 10,
            dataPoints = DataPoints(values = listOf(1, 11, 22, 33, 44, 55, 66))))
    }

    @Test
    fun `Bucket Size of 20 with 7 equidistributed numbers gives 4 buckets`() {
        assertEquals(listOf(
            Interval(1L, 20L, 2L),
            Interval(21L, 40L, 2L),
            Interval(41L, 60L, 2L),
            Interval(61L, 80L, 1L),
        ), hist.createSections(bucketSize = 20,
            dataPoints = DataPoints(values = listOf(1, 11, 22, 33, 44, 55, 66))))
    }
}