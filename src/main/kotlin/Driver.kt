fun main() {
    val fileReader = FileReader()
    fileReader.readFile()
    val dataPoints = DataPoints(fileReader.values)
    val gram = Histogram(fileReader.bucket, dataPoints)

    val list = gram.createSections()

    list.forEach { (first, second, third) ->
        println("$first to $second: $third")
    }
}