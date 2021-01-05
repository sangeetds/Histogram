fun main() {
    val fileReader = FileReader()
    fileReader.readFile(fileName = FileProperties.name)

    val dataPoints = DataPoints(values = fileReader.values)
    val gram = Histogram()

    val list = gram.createSections(bucketSize = fileReader.bucket ?: 10, dataPoints = dataPoints)

    list.forEach { (first, second, third) ->
        println("$first to $second: $third")
    }
}