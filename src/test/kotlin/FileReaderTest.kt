import org.junit.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileReaderTest {
    private val fileReader = FileReader()

    @Test
    fun `Wrong File name throws exception`() {
        assertThrows<FileNotFoundException> {
            fileReader.readFile("abc.txt")
        }
    }

    @Test
    fun `Correct file gives non empty number list and not null bucket size`() {
        fileReader.readFile("numbers.txt")
        assertTrue(fileReader.values.isNotEmpty())
        assertNotNull(fileReader.bucket)
    }

    @Test
    fun `Empty File throws exception`() {
        assertThrows<NullPointerException> {
            fileReader.readFile("empty.txt")
        }
    }

    @Test
    fun `Empty file parameter gives null bucket size`() {
        fileReader.readFile("emptybucket.txt")
        assertNull(fileReader.bucket)
    }
}