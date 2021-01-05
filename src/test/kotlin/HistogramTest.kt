import org.junit.jupiter.api.TestInstance
import org.junit.Test
import kotlin.test.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class HistogramTest {

    @Test
    fun `Bucket Size of 10 with 7 equidistributed numbers gives 7 buckets`() {
        val hist = Histogram(bucketSize = 10, dataPoints = DataPoints(values = listOf(1, 11, 22, 33, 44, 55, 66, 77)))

        assertEquals(listOf(
            Triple(1L, 10L, 1L),
            Triple(11L, 20L, 1L),
            Triple(21L, 30L, 1L),
            Triple(31L, 40L, 1L),
            Triple(41L, 50L, 1L),
            Triple(51L, 60L, 1L),
            Triple(61L, 70L, 1L),
            Triple(71L, 80L, 1L)
        ), hist.createSections())
    }
}