# Project : Data Analysis of Wikipedia using Hadoop
This is the project for M3-Java (Harbour Space)

Authors: 
<li>Patricia Poral</li>
<li>Duc Pham</li>
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
* [Possible Evolutions](#possible-evolutions)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)


<!-- ABOUT THE PROJECT -->
## About The Project

Wikipedia is probably the biggest amount of Text data available out there, that's why it is used to train huge NLP models like GPT3.
We are interested to use our newly acquired knowledge of Java in M3-Java at Harbour Space, to get some interesting insight about WikiPedia. Because of the huge amount of data to work with, we try to implement a MapReduce approach on top of Hadoop.

Plan of work:
* Get some data from Wikipedia, using various APIs
* Make an HDFS Hadoop network with our machines
* Transfer that data to our machine
* Use MapReduce to get insight about that data
* Build more analysis on top of those MapReduce results
* Optional : grow that Hadoop network on the cloud (Digital Ocean)

### Built With
Here are the major frameworks that we built our project with.
* [AQS Pageviews](https://wikitech.wikimedia.org/wiki/Analytics/AQS/Pageviews)
* [Hadoop](https://hadoop.com)
* [GSON](https://gson.com)


<!-- GETTING STARTED -->
## Getting Started


### How to use our repo

1. Clone the repo
2. Intall Hadoop
3. Use WikipediaCrawler.java to get some data from WikiPedia
4. Put those data files on your Hadoop HDFS (if you have multinodes, use them!)
5. Use our MapRedude jobs (.jars) to analyse those files

### How to install Hadoop
We recommend to start with the single node implementation (Standalone) on Hadoop version 1. 
This is recommended for practicing Hadoop commands and test our .jar files, before using them on a multi node network.

This is a multistep process that we will not describe in detail here.
You can follow instructions here:

[Hadoop installation](https://phoenixnap.com/kb/install-hadoop-ubuntu)



<!-- USAGE EXAMPLES -->
## Usage

### Count the number of words in a file
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
    
_For more examples, please refer to the [Documentation](https://example.com)_

<!-- DESIGN -->
## Design

### MapReduce
Modularity is important for the design of our project, and it will be important to create modular Map and Reduce jobs so that we can reuse them between jobs.
We have attempted to start doing that by decoupling Map and Reduce in the WordCount.java (and creating the package wordcount to explain those map and reduce jobs), but this is still very much a work in progress.


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

### Performance tests
Not only do we want to check that our MapReduce jobs work properly, but because we are dealing with Big Data and we are trying to launch our project on a Network, it is important to also run some performance tests. It involves measuring the speed of our jobs, and also testing with bigger volumes of data.

<!-- POSSIBLE EVOLUTIONS -->
## Possible Evolutions
### Text analysis
* Analyse the number of pages per language and compare it to the number of speaker of this language
* Analysis the trending articles

### Network
* Combine our machines together as a network.
* We are currently working on Hadoop version 1. We can update to version 2.
* Use a cloud server to run Hadoop. Digital Ocean seems to be the better choice for ease of use in our case.

<!-- CONTRIBUTING -->
## Contributing

Contributions are what will make the project better. Any contributions you make are **greatly appreciated**.

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
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=flat-square
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
