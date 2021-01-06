import java.io.File

class FileReader {

    /**
     * Function to read values from the file.
     * @param fileName String, the name of the file to be read.
     * @param separator String, the regex against which the numbers will be split from values read.
     *
     * @return the data values and bucket size encapsulated in a Data Class FileValues.
     *
     * @throws java.io.FileNotFoundException when the file name is incorrect.
     * @throws NullPointerException when the file is empty.
     */
    fun readFile(fileName: String, separator: String): FileValues {
        val file = File(fileName)
        val bufferReader = file.bufferedReader()

        val values = bufferReader.readLine()!!.split(separator).map { it.toLong() }
        val bucket: Long

        return try {
            bucket = bufferReader.readLine().toLong()
            FileValues(values = values, bucket = bucket)
        } catch (exception: NullPointerException) {
            println("Missing values for bucket size. Using default value of 10.")
            FileValues(values = values)
        } finally {
            bufferReader.close()
        }
    }
}