import java.io.File

class FileReader {
    fun readFile(fileName: String, separator: String): FileValues {
        val file = File(fileName)
        val bufferReader = file.bufferedReader()

        val values = bufferReader.readLine()!!.split(separator).map { it.toLong() }
        val bucket: Long

        return try {
            bucket = bufferReader.readLine().toLong()
            FileValues(values, bucket)
        } catch (exception: NullPointerException) {
            println("Missing values for bucket size. Using default value of 10.")
            FileValues(values)
        } finally {
            bufferReader.close()
        }
    }
}