# Project Euler Problem 83 Java Solution
<p><b>WARNING: SPOILERS FOR PROBLEM 83</b></p>

## The Problem
<p>Formal problem available on: <a href="https://projecteuler.net/problem=83">Project Euler</a></p>
<p>You are provided with an 80x80 matrix of numbers between 1 and 9999. You are tasked with finding the sum of the shortest path from the top-left corner to the bottom-right corner, moving only to adjacent, non-diagonal cells.</p>

## My Approach
<p>The code above is an implementation of <a href="https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm">Dijkstra's Alorithm</a>. It imports the provided text file into an array, and uses Dijkstra to find the shortest path.</p>
