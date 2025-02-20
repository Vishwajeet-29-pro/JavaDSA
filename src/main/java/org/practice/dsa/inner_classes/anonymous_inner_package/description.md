## Anonymous Inner Classes

An anonymous inner class is a class without a name that is declared and instantiated all at once, typically as an
argument to a method or as an implementation of an interface or abstract class. They are used to override methods of
classes or interfaces.

**Characteristics**
- No Name: Anonymous inner classes do not have a class name.
- Single Use: They are often used for one-time use, usually to provide a simple implementation of an interface or to
    override the methods of a class.
- Instantiation and Declaration: They are declared and instantiated simultaneously.
- Can Extend a Class or Implement an Interface: You can create an anonymous inner class to extend an existing class or to
    implement an interface.

**Syntax:**
    // Anonymous inner class implementing an interface
```Java
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Running in an anonymous inner class");
        }
    };
```
```
    // Anonymous inner class extending a class
    Button button = new Button("Click Me");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button clicked!");
        }
    });
```