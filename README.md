Block-Dude
==========

Made for the SDSU programming competition
If you want to read up on it, go here: http://www3.sdstate.edu/eecs/program-design/index.cfm
This is a totally full fledged game engine, with a whole game object and component system.

The link to the the challenge is [here](http://www.sdstate.edu/eecs/program-design/upload/PDC-2015-Problem-Description.pdf)

Link to the [Travis CI](https://travis-ci.org/thomaslauer/Block-Dude), here's the current build status

![Image](https://travis-ci.org/thomaslauer/Block-Dude.svg?branch=master)


##Build Instructions
To build this project, use one of these IDEs:

1.  [Eclipse](https://eclipse.org/)
2.  [Netbeans](https://netbeans.org/)
3.  [IntelliJ IDEA](https://www.jetbrains.com/idea/)

I recommend using Eclipse, and automatically importing the project.

####Jars

If you don't use Eclipse, you'll have to put all the files in the `src`, `libs`, and `res` into your project folder. From the `lib/jar` folder import:

- jinput.jar
- json-simple.1.1.1.jar
- lwjgl.jar
- lwjgl_util.jar
- slick-util.jar

####Natives

To set up natives, into your build settings and select the native location for lwjgl.jar. Set that to the folder `libs/natives/[YOUR OS HERE]`

Replace `[YOUR OS HERE]` with either linux, macosx, solaris, or windows. I'm building this on windows, so if you automatically import the project that's what the default will be.

##Coding conventions
Use the camel style caps on almost everything, with variables and non static methods starting with a lowercase and static methods and classes starting with an uppercase letter.

`exampleVariableName`

`dog.bark();`

`Window.Init();`

Curly braces should be put on the next line:

```java
public class Dog extends Animal
{
  public Dog(String name)
  {
    super(name);
  }
  
  public void bark()
  {
    // bark here
  }
}
```

It's ok for things to be left public unless changing them will cause the engine to crash, such as file paths or things like that. If they have to be private, when able make getters and setters for them. We want components to be able to change almost everything in the engine. 
