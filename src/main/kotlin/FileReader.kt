import java.io.File

class FileReader(var values: List<Long> = listOf(), var bucket: Long = 0) {
    fun readFile() {
        val file = File(FileProperties.name)
        val bufferReader = file.bufferedReader()

        values = bufferReader
            .readLine()
            .split(", ")
            .map { it.toLong() }

        bucket = bufferReader.readLine().toLong()
    }
}