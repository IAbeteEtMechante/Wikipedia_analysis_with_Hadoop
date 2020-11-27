
<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop">
    <img src="images/wikipedia_logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Data Analysis of Wikipedia using Hadoop</h3>

  <p align="center">
    Using Hadoop and MapReduce to analyse textual Big Data 
    <br />
    <a href="https://iabeteetmechante.github.io/Javadoc_Wikipedia_project/"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://iabeteetmechante.github.io/Javadoc_Wikipedia_project/">View Demo</a>
    ·
    <a href="https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop/issues">Report Bug</a>
    ·
    <a href="https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop/issues">Request Feature</a>
  </p>
</p>

<br>
<br>

This is our project in Java for the course M3-Java at Harbour Space. We are currently studying Data Science, so we thought it would be interesting to apply what we have learned in Java to crunch some Big Data using MapReduce.

Authors: 
<li>Duc Pham</li>
<li>Patricia Poral</li>
<li>Pierre Schwob</li>
<br>

![Wikipedia_analysis_with_Hadoop](https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop/workflows/Wikipedia_analysis_with_Hadoop/badge.svg)

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Design](#design)
* [Testing](#testing)
* [Results and Analysis](#results-and-analysis)
* [Possible Evolutions](#possible-evolutions)
* [Documentation](#documentation)
* [Workload Allocation](#workload-allocation)
  * [Project Milestone 1](#project-milestone-1)
  * [From Milestone 1 to Demo Day](#from-milestone-1-to-demo-day)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)


<!-- ABOUT THE PROJECT -->
## About The Project

Wikipedia is probably the biggest amount of Text data available out there, that's why it is used to train huge NLP models like GPT3.
We are interested to use our newly acquired knowledge of Java in M3-Java at Harbour Space, to get some interesting insight about WikiPedia. Because of the huge amount of data to work with, we try to implement a MapReduce approach on top of Hadoop.

Plan of work:
* Get some data from Wikipedia, using various APIs or download from https://dumps.wikimedia.org/
* Make an HDFS Hadoop network with our machines
* Transfer that data to our machine
* Use MapReduce to get insight about that data
* Build more analysis on top of those MapReduce results
* Optional : grow that Hadoop network on the cloud (Digital Ocean)

### Built With
Here are the major frameworks that we built our project with.
* [AQS Pageviews](https://wikitech.wikimedia.org/wiki/Analytics/AQS/Pageviews)
* [Hadoop](https://hadoop.com)
* [GSON](https://gson.com) (not yet, but it is one of our goals)


<!-- GETTING STARTED -->
## Getting Started


### How to use our repo

1. Clone the repo
2. Intall Hadoop
3. Use WikipediaCrawler.java to get some data from WikiPedia
4. Put those data files on your Hadoop HDFS (if you have multinodes, use them!)
5. Create .jar files from our .java code (optional, because you can also use our .jar files directly if you want to)
6. Use the .jars files to analyse the data on HDFS with Hadoop

### How to install Hadoop
We recommend to start with the single node implementation (Standalone) on Hadoop version 1. 
This is recommended for practicing Hadoop commands and test our .jar files, before using them on a multi node network.

This is a multistep process that we will not describe in detail here.
You can follow instructions here:

[Hadoop installation](https://phoenixnap.com/kb/install-hadoop-ubuntu)



<!-- USAGE EXAMPLES -->
## Usage

### How to build .jar files from our .java files
You can build .jar files from our .java files, either with gradle, or with our dedicated bash script

#### Use gradle
To be completed

#### Use our bash script
You could use directly use our .jar files if you want, but it is interesting to be able to create your own .jar files directly.
For that, we made a bash script (makeJarFiles.sh) that can build the .jar files from the .java files.
Here is how to use that script:

* First you need to create a directory, and put all the .java files you want inside it
```sh
mkdir yourAwesomeDirectoryName
cd yourAwesomeDirectoryName
cp /path/to/java/files/*.java .
```

* Then you want to put the bash script inside it, and give it execution rights
```sh
cp /path/to/bashscript/makeJarFiles.sh .
chmod +x makeJarFiles.sh
```
* You also want to modify the script content and change /usr/local/hadoop to your own hadoop installation location.
We put vim as an example, but feel free to use the text editor of your preference.
```sh
vim makeJarFiles.sh
```
Once you opened with the editor and made the change to your hadoop path, you can are ready to use the script:

```sh
./makeJarFiles.sh
```

It will create a Job.jar file inside your directory. Feel free to rename it. A good choice of name would be the name of the main class in your .java files, beause you will need to remember it to run the .jar file in the next step.



### Use the .jar files to run jobs on Hadoop
To understand how to use the .jar files created from our java code, let's consider that you want to count the number of words in a file.
You can use our out/artifacts/Job/WordCount.jar file and type this on the command line on Ubuntu/MacOS:
```sh
hadoop jar /path/to/WordCount.jar WordCount /data/input.txt /output
```
where:
* "path/to/WordCount.jar" is the full path to your copy of WordCount.jar
* "WordCount" is the name of the main class in that .jar
* "/data/input.txt" is the path to the text file you want to count the number of words of
* "/output" is the directory where you want to store the result. Be careful that this directory must be new. You must create a new directory every time 
    you run a new Hadoop job.
    
_For more examples, please refer to the [Documentation](https://iabeteetmechante.github.io/Javadoc_Wikipedia_project/)_

<!-- DESIGN -->
## Design

### MapReduce
Modularity is important for the design of our project, and it will be important to create modular Map and Reduce jobs so that we can reuse them between jobs.
We have attempted to start doing that by decoupling Map and Reduce in the WordCount.java (and creating the package wordcount to explain those map and reduce jobs), but this is still very much a work in progress.
Eventually, we think we should have classes for Map jobs, classes for Reduce jobs, and classes for Driver code to combine some Map jobs with some other Reduce jobs.

### Current Design
This is the current organization of our classes. It will evolve according to the comment above in the MapReduce section:

[![UML Diagram][UML]](https://example.com)

<!-- TESTING -->
## Testing

### JUnit tests
For every .java file there is a corresponding JUnit testfile to check that the behaviour corresponds to what is expected.
However there are many things that we cannot test with JUnit tests on that project. Therefore we use many other methods of testing. Most of it will be done in the second part of this project.

### Data Staging tests
We need to make sure we pull the correct data to our MapReduce jobs.
* Validate data from Wikipedia APIs: we can test it by comparing some results with Google Trends
* Compare that data to the one we get into Hadoop HDFS: we can check that the data is the same as the one we get from the API.
* Verify that the data goes into the correct location in HDFS: random check on Hadoop HDFS.

### MapReduce tests
We need to test that the MapReduce process works properly. This is partly done with our JUnit testing(data aggregation or segregation rules are implemented on the data,  key value pairs are generated...), but we also need to validate the data after the MapReduce process on Hadoop.

###  Hadoop tests
A described above in the Usage section, we can also run our .jar files on our Hadoop Standalone installations, and run some tests using bash scripts on it. 

For example, the simple implementation of WordCount explained in the Usage section, takes a file input like this one:

![Input][hadoop-input]

And gives this output, which is simply the count of number of occurences of each word in the input:

![Output][hadoop-output]

Here is how it looks like in Hadoop 1 Web User Interface, as you can see on this picture of the result of our first test of the WordCount MapReduce job:

![Product Name Screen Shot][hadoop-screenshot]

### Performance tests
Not only do we want to check that our MapReduce jobs work properly, but because we are dealing with Big Data and we are trying to launch our project on a Network, it is important to also run some performance tests. It involves measuring the speed of our jobs, and also testing with bigger volumes of data.

<!-- RESULTS AND ANALYSIS-->
## Results and Analysis

### Results
Wikipedia is a multilingual open-collaborative online encyclopedia, and as of 27 November 2020, there are 6,197,347 articles in the English Wikipedia. Given that Wikipedia data sets are too large and complex to deal with, it is vital to have a structured data to provide accurate analysis. Using different MapReduce algorithm implemented in Java, we were able to derive structured data and make inferences.

Below are the graphs constructed and analysis inferred from the results of MapReduce programs.

#### Covid Related Wikipedia Articles

![Line Chart][linechart]

#### Wikipedia Articles

![Line Chart][linechartsumpageviews]

#### Top 25 Most Viewed Articles

![Bar Chart][barchart]

<!-- POSSIBLE EVOLUTIONS -->
## Possible Evolutions
### Text analysis
#### Analyse the number of pages per language and compare it to the number of speaker of this language
Using our network of multi-threaded computers, we can crawl data on articles from specific language from https://dumps.wikimedia.org/backup-index.html, then do the necessary aggregations.


#### Analyze trending topics
Retrieving the articles with highest views during a specific timeframe, and aggregate them into topics.

### Network
* Combine our machines together as a network.
* We are currently working on Hadoop version 1. We can update to version 2.
* Use a cloud server to run Hadoop. Digital Ocean seems to be the better choice for ease of use in our case.

<!-- DOCUMENTATION -->
## Documentation
We already implemented an elementary first version of JavaDoc for this project, which is inside the /Javadoc folder. 
We also have added it as a GitHub Pages website in another repo, which is available here:
<br>
<br>
_[Documentation](https://iabeteetmechante.github.io/Javadoc_Wikipedia_project/)_

This is still the first version of our JavaDoc, and it needs more information on many classes and methods. We are already working on it and it will be completed during the second phase of the project.

<!-- WORKLOAD ALLOCATION -->
## Workload Allocation


### Project Milestone 1

Initially, we planned to divide the tasks by module and person:
* Pierre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;MapReduce
* Patricia&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;Analysis built on the resulting data from MapReduce
* Duc&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;Testing

However, due to time constraint of the project, the team switched to work jointly on each of those modules, because we understood our work was very interdependent.

### From Milestone 1 to Demo Day

Given that in the first phase of the project, we switched from specific task allocation (each task to one person only) to a joint effort on all tasks, it may seem counterintuitive to switch back to specific task allocation in the second phase.
But this is what we will try to do:)
The reason is that the project is a bit more advanced, and we already got some general knowledge about the subject to help us accomplish later tasks even if previous tasks are not completed yet. Also specific task allocation present some benefits where we can work more autonomously instead of having to chat continuously with others about what we are doing. And it is more satisfying to accomplish a whole task for each member of the team.

The tentative plan for task allocation until project completions are as follow:

* Collective tasks:
  * Setting up Hadoop and link computers into a network
  * Possibly switch to Hadoop version 2
  * Setting up cloud machines
  * Add JavaDoc comments to all java files

* Duc:
  * MapReduce code for crawling data and analyze language popularities

* Patricia:
  * MapReduce code for crawling data and analyze trending topics

* Pierre:
  * Testing: jUnit tests of course, but also testing techniques specific to Big Data
  
 We will try just for a day or two to see if we can work like this, or if we have to switch back to grouping our efforts on the same tasks at the same time.


<!-- CONTRIBUTING -->
## Contributing

If you are interested in this topic, you too can contribute to this work. Contributions are what will make the project better. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Feel free to contact us on this repo, we are happy to hear from you.

Project Link: [https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop](https://github.com/IAbeteEtMechante/Wikipedia_analysis_with_Hadoop)




<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* To be completed

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[hadoop-screenshot]: images/Screenshot_from_2020-11-17_21-31-09.png
[wiki-logo]: images/wikipedia_logo.png
[UML]: images/UML_diagram.png
[hadoop-input]: images/input.png
[hadoop-output]: images/output.png
[linechart]: images/LineChart.jpeg
[linechartsumpageviews]: images/LineChartSumPageViews.jpeg
[barchart]: images/BarChartTop25Articles.png

