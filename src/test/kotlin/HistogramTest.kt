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

    @Test
    fun `Large bucket size with points at either end of spectrum gives 1 buckets`() {
        assertEquals(listOf(
            Interval(1L, 100L, 7L),
        ), hist.createSections(bucketSize = 100,
            dataPoints = DataPoints(values = listOf(1, 2, 3, 33, 88, 95, 86))))
    }

    @Test
    fun `Small bucket size with points at either end of spectrum gives 2 major buckets`() {
        assertEquals(listOf(
            Interval(1L, 5L, 3L),
            Interval(6L, 10L, 0L),
            Interval(11L, 15L, 0L),
            Interval(16L, 20L, 0L),
            Interval(21L, 25L, 0L),
            Interval(26L, 30L, 0L),
            Interval(31L, 35L, 0L),
            Interval(36L, 40L, 0L),
            Interval(41L, 45L, 0L),
            Interval(46L, 50L, 0L),
            Interval(51L, 55L, 0L),
            Interval(56L, 60L, 0L),
            Interval(61L, 65L, 0L),
            Interval(66L, 70L, 0L),
            Interval(71L, 75L, 0L),
            Interval(76L, 80L, 0L),
            Interval(81L, 85L, 0L),
            Interval(86L, 90L, 0L),
            Interval(91L, 95L, 0L),
            Interval(96L, 100L, 3L),
        ), hist.createSections(bucketSize = 5,
            dataPoints = DataPoints(values = listOf(1, 2, 3, 98, 97, 96))))
    }
}