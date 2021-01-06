import org.junit.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileReaderTest {
    private val fileReader = FileReader()

    @Test
    fun `Wrong File name throws exception`() {
        assertThrows<FileNotFoundException> {
            fileReader.readFile("abc.txt", ", ")
        }
    }

    @Test
    fun `Correct file gives non empty number list and not null bucket size`() {
        val fileValues = fileReader.readFile("numbers.txt", ", ")
        assertTrue(fileValues.values.isNotEmpty())
        assertNotNull(fileValues.bucket)
    }

    @Test
    fun `Empty File throws exception`() {
        assertThrows<NullPointerException> {
            fileReader.readFile("empty.txt", ", ")
        }
    }

    @Test
    fun `Empty file parameter gives bucket size as 10`() {
        val fileValues = fileReader.readFile("emptybucket.txt", ", ")
        assertEquals(10, fileValues.bucket)
    }
}