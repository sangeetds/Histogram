fun main() {
    val fileReader = FileReader()
    val fileValues = fileReader.readFile(
        fileName = FileProperties.name,
        separator = FileProperties.separator)

    val dataPoints = DataPoints(values = fileValues.values)
    val gram = Histogram()

    val list = gram.createSections(
        bucketSize = fileValues.bucket,
        dataPoints = dataPoints)

    list.forEach { (intervalStart, intervalEnd, value) ->
        println("$intervalStart to $intervalEnd: $value")
    }
}