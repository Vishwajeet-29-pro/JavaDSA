# Adapter Pattern
#### Overview:
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together.
It acts as a bridge between two incompatible interfaces by converting the interface of a class into another interface
that a client expects.

Intent:
- Convert the interface of a class into another interface that clients expect.
- Allow classes to work together that could not otherwise because of incompatible interfaces.
Key Concepts:

**Target Interface**: The interface that the client expects.
- Adaptee: The existing interface that needs adapting.
- Adapter: The class that implements the target interface and translates requests from the target interface to the
adaptee.