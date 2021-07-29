# Class-hierarchy-interface (Base64)

## 1. Project Introduction<br />
This program is a code that transforms the Base64 encoding decoding program. In this code, I focused on designing and understanding the interface and the application of the Abstract class using class. Further to the first task, code was implemented in accordance with the CodeWord, to String, and encode phases, and each of the descriptions was divided into classes.

## 2. Class
• Schematic or frame for creating objects
• A set of associated variables and methods

## 3. Object
• What to implement in the world of software
• An entity created in the shape declared in the class
• It is also called an instance of a class.
• Objects have a comprehensive meaning that represents all instances.
• In terms of oop, when declared class type, it is called 'object'.

## 4. Abstract class & interface

* Commonalities<br />
Abstract class and interface have only declarations and no implementations. Therefore, they themselves cannot create objects using 'new', and only children class who 'extends' abstract classes or 'implements' interface can create objects. It is used when an inherited child must be implemented. In JAVA, the type declared and the type of child must be the same with the declared type. <br /><br /> 

* Differences<br />
Abstract classes are literally classes, and interfaces are specified for methods before implementation.<br />
The definition of an abstract class is a class in which one of the abstract methods exists.
Therefore, some methods have been implemented, and some methods labeled abstract have not been implemented.
Classes that inherit abstract classes must implement abstract methods. Therefore, abstract classes are used when there are methods that must be implemented.<br />
The interface has no implementation, but only specifications for the method. Classes that inherit interfaces must implement all of the methods in the interface. Abstract classes are single inheritance, because Java supports single inheritance, but when interfaces are used, 'extents' can also be used in the part of 'implements'. In other words, multiple inheritance becomes possible.


