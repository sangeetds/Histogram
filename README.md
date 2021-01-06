# Histogram

A sample project to create histograms which is basically showing the no. of times an input number is present in a pre-determined bucket/interval.

You can run this project by running the `Driver.kt` file after running the command `gradle build` on command line. Please make sure you have Java, Gradle, and Kotlin installed and configured in your system. 
Also make sure that you have provided a sample text file with sample values, whose name must be changed/included in the `FileProperties.kt` file.

You can run the tests by running the command `gradle test` on the command line.

<h3>Assumptions made:-</h3> 
The numbers are integer starting from 1 to 10^9 (the numbers can be larger given the bucket size is not very small compared to largest number)

<h3>Areas for improvement</h3>
The numbers are stored rather than read at a time. This might give possibility to further processing on the number but at the cost of memory. The numbers could be read in a stream for a smaller operation.
