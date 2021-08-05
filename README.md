<!--
*** This template come from : https://github.com/othneildrew/Best-README-Template#best-readme-template
-->



<!-- PROJECT LOGO -->
<br />
<p align="center">
    <img src="http://www.logo-designer.co/wp-content/uploads/2016/05/hyperloop-one-logo-design.png" alt="Logo" width="520" height="321">

  <h3 align="center">HyperLoop Project - University Of Luxembourg</h3>

  <p align="center">
    A project by Adam AISSOU, Daoud BOUSRI & Maxence QUINET
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#map">Map</a>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#what-did-we-use?">What did we use?</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project was requested by the University of Luxembourg as part of our BINGO program for our 4th semester.

The project consists of creating a real simulation of the HyperLoop in Luxembourg.
The HyperLoop simulation therefore required, to be realistic, some constraints:
* Pods must hollow out to transport customers to the right places
* The HyperLoop is a means of transport on demand. It does not have a pre-determined route like standard trains or buses.
* Considering the speed of a pod, if a rail is used, then the next pod that wants to use this same rail must wait for this rail to become free
* Some rails are uni-directional, others are bi-directional. That is to say that some rails only go in one direction. While others take care of the alelr and the return on their own.
* To ensure transport, the pod must find the shortest possible route to bring these travelers.
* Finally, if no pod is available in the station, the station calls a pod at the nearest station that has one.

For this project, we therefore decided to think carefully about what we are going to use: algorithms, inheritance, Multi-Threading ...
We are 3 students to have done this project: Adam AISSOU, Daoud BOUSRI and Maxence QUINET.

### Built With

It doesn't take much to get our program started. You just need an IDE supporting Java, and clone our project to launch it. Then, you are free to make changes.
* [Eclipse IDE](https://www.eclipse.org/downloads/)


<!-- GETTING STARTED -->
## Map

To facilitate the understanding of the application and the routes, here is a map with a legend:
<p align="center">
    <img src="https://zupimages.net/up/21/15/8pyz.png" alt="Map" width="945" height="708">
    </p>

A pod can only contain 4 people at a time, here is a small diagram:
<p align="center">
    <img src="https://zupimages.net/up/21/15/q274.png" alt="Pod" width="672" height="310">
    </p>

<!-- USAGE EXAMPLES -->
## Usage

This project is useful for understanding how to implement a shortest path finding algorithm, Synchronized Multi-Threading, and for testing its logic.

<!-- CONTRIBUTING -->
## What did we use?

We opted to use Dijkstra's algorithm, which allows the train to find the shortest path.
For pod request to neighboring stations. We decided to use part of Dijkstra's algorithm. Since it needs the neighbors of each node to be able to know which is the shortest path.

To synchronize the Threads, we simply used the keyword 'synchronized' to synchronize the rails on which the trains will pass.

We also made a passenger generator to make the Main.java more flexible, and random, which makes each run unique.

Here are some pictures we get in the console after execution:



<!-- LICENSE -->
## License

No License because this is just a student project :) .



<!-- CONTACT -->
## Contact

* Adam AISSOU - [adam.aissou.001@student.uni.lu](adam.aissou.001@student.uni.lu)
* Daoud BOUSRI - [daoud.bousri.001@student.uni.lu](daoud.bousri.001@student.uni.lu)
* Maxence QUINET - [maxence.quinet.001@student.uni.lu](maxence.quinet.001@student.uni.lu)

Project Link: [https://github.com/coast-uni-lu/a3-2021-luxhyperloop-luxhyperloop-2021-team14](https://github.com/coast-uni-lu/a3-2021-luxhyperloop-luxhyperloop-2021-team14)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [GitHub Pages](https://pages.github.com)
* [The person who made this template](https://github.com/othneildrew)


