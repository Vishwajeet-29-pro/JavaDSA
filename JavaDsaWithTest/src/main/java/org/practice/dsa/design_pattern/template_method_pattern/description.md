# Overview:
The Template Method Pattern is a behavioral design pattern that defines the skeleton of an algorithm in the superclass
but lets subclasses override specific steps of the algorithm without changing its structure.

## Intent:

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
Let subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
Key Concepts:

Abstract Class: Contains the template method which defines the skeleton of the algorithm. The concrete steps are
implemented in the subclasses.
Concrete Classes: Implement the abstract methods defined in the abstract class to provide specific behavior.