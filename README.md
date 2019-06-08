# Gilded Rose Solution for Java

[![Build Status](https://travis-ci.org/cfisch3r/gilded-rose-java.svg?branch=master)](https://travis-ci.org/cfisch3r/gilded-rose-java)

This is my solution of the [Gilded Rose Legacy Code Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata)
as made famous by [Emily Bache](https://twitter.com/emilybache).

As you can see I finally end up with the [Chain of Responsibility Pattern](https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern) for the implementation code. On the test side I decided to split 
the test cases into general and item specific rule sets, which reflects the structure of the problem domain and
 follows the considerations of [Robert C. Martin's article](https://blog.cleancoder.com/uncle-bob/2017/03/07/SymmetryBreaking.html) about breaking the symmetry between test and 
 implementation code.
 
 IMHO tests are first and foremost specifications of the code. So I decided to formulate them to describe the 
 required business rules. To make them even more expressive I used the BDD-Framework [JGiven](http://http://jgiven.org). 
 Furthermore I summarized 
 equivalent test cases using [test parametrization](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests).
The [generated Test Report](https://cfisch3r.github.io/gilded-rose-java/)  demonstrates how this approaches can be used for an up-to-date living documentation.
 
 If you are interested in more examples and thoughts about Test Driven Development, please visit my [site](http://agiledojo.de).    

