# Overview:
- The Builder Pattern is a creational design pattern that allows constructing complex objects step by step.
- It separates the construction of a complex object from its representation so that the same construction process can
create different representations.

Intent:
- Separate the construction of a complex object from its representation.
- Allow the same construction process to create different representations.
- Provide a clear and flexible way to build objects.

### Key Concepts:
- Builder Interface: Defines all the steps required to create the product.
- Concrete Builder: Implements the Builder interface and provides specific implementations of the steps to build the
product.
- Product: The complex object being built.
- Director: Constructs the product using the Builder interface.