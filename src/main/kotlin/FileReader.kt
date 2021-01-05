import java.io.File

class FileReader(var values: List<Long> = listOf(), var bucket: Long? = null) {
    fun readFile(fileName: String) {
        val file = File(fileName)
        val bufferReader = file.bufferedReader()

        values = bufferReader.readLine()!!.split(", ").map { it.toLong() }

        try {
            bucket = bufferReader.readLine().toLong()
        }
        catch (exception: NullPointerException) {
            println("Missing values for bucket size. Initialising empty values")
        }
        finally {
            bufferReader.close()
        }
    }
}