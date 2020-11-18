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
* Get some data from Wikipedia, using some APIs
* Make an HDFS Hadoop network with our machines
* Transfer that data to our machine
* Use MapReduce to get insight about that data
* Build more analysis on top of those MapReduce results
* Optional : grow that Hadoop network on the cloud (Digital Ocean)

### Built With
Here are the major frameworks that we built our project with.
* [Hadoop](https://hadoop.com)
* [GSON](https://gson.com)


<!-- GETTING STARTED -->
## Getting Started

Need Hadoop

### How to install Hadoop
We describe the single node implementation(Standalone) on Hadoop version 1. 
This is recommended for practicing Hadoop commands and test our .jar files, before using them on a multi node network.

This is a multistep process that we will not describe in detail here.
You can follow instructions here:

[Hadoop installation](https://phoenixnap.com/kb/install-hadoop-ubuntu)

### How to use our repo

1. Get a free API Key for wikipedia [https://wikipedia.com](https://wikipedia.com)
2. Clone the repo
3....


<!-- USAGE EXAMPLES -->
## Usage

### Count the number of words in a file
To understand how to use the .jar files created from our java code, let's consider that you want to count the number of words in a file.
First you need to install Hadoop on your machine. A single node implementation(Standalone) as described above in "How to install Hadoop" is enough.

You can then use our WordCount.jar file and type this on the command line on Ubuntu/MacOS:
```sh
hadoop jar <path to:WordCount.jar> WordCount /data/input.txt /output
```
where:
* <path to:WordCount.jar> is the full path to your copy of WordCount.jar
* /data/input.txt is the path to the text file you want to count the number of words of
* /output is the directory where you want to store the result. Be careful that this directory must be new. You must create a new directory every time 
    you run a new Hadoop job.
    
_For more examples, please refer to the [Documentation](https://example.com)_


<!-- POSSIBLE EVOLUTIONS -->
## Possible Evolutions
### Evolution 1

### Evolution 2

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
