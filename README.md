<p align="center">
   <img src="https://cdn.rawgit.com/nur1popcorn/Irrlicht/2f2e848d/Irrlicht.svg" width="480" height = "180">
</p>

* * *
  
> Your cross-version cheating champ

*Irrlicht* is an easy to use cheat base which aims to make cross-version cheating attractive by automating the tedious process of making it compatible for each version.

## Index
* [What it does](https://github.com/nur1popcorn/Irrlicht#what-it-does)
  * [Explain it to me](https://github.com/nur1popcorn/Irrlicht#explain-it-to-me)
    * [What it is](https://github.com/nur1popcorn/Irrlicht#what-it-is)
    * [What's unique](https://github.com/nur1popcorn/Irrlicht#whats-unique)
      * [Other solutions](https://github.com/nur1popcorn/Irrlicht#other-solutions-)
      * [My solution](https://github.com/nur1popcorn/Irrlicht#my-solution-)
  * [I don't get it](https://github.com/nur1popcorn/Irrlicht#i-dont-get-it)
* [Features](https://github.com/nur1popcorn/Irrlicht#features)
* [Getting started](https://github.com/nur1popcorn/Irrlicht#getting-started)
  * [Mapper](https://github.com/nur1popcorn/Irrlicht#mapper)
    * [Wrappers](https://github.com/nur1popcorn/Irrlicht#wrappers)
    * [Custom Handlers](https://github.com/nur1popcorn/Irrlicht#custom-handlers)
  * [Hooker](https://github.com/nur1popcorn/Irrlicht#hooker)
  * [Modules](https://github.com/nur1popcorn/Irrlicht#modules)
* [Built with](https://github.com/nur1popcorn/Irrlicht#built-with)
* [Release history](https://github.com/nur1popcorn/Irrlicht#release-history)
* [Contributing](https://github.com/nur1popcorn/Irrlicht#contributing)
* [Authors](https://github.com/nur1popcorn/Irrlicht#authors)
* [License](https://github.com/nur1popcorn/Irrlicht#license)
* [Contact](https://github.com/nur1popcorn/Irrlicht#contact)

## What it does

*Irrlicht* recognises logic and structure in obfuscated classes, makes them easily accessible and enables you to inject your personal cheating-desires. 

### Explain it to me

The game is obfuscated. Therefore, it is difficult to access data structures or invoke methods reliably. Not only that but the game's fields, methods and classes change their names with each version.

*Irrlicht* aims to solve exactly this problem.

* ### What it is

  Is it a bird? Is it a plane? No, it's an injection-client.

  But what is an injection client you might ask...

  Well, let me explain it to you in simple terms:
  - Injection clients are clients desgined for minecraft *(usually)*.
  - An injection-client is a client that is loaded **while** the game is running.
  - It infiltrates and modifies the targeted client thereby adding it's own set of logic.
  
* ### What's unique
  Cross version cheating usually causes a lot of problems, *Irrlicht* solves them all and automates the tedious process of making your cheat compatible with each version.
  * #### Other solutions: <br/>
  Currently there are two public solutions to tackle this problem. One of which involves deobfuscating the whole source code. A loss of cross version compatibility is the result (without putting some extra effort into making it compatible with the next version). And even if this effort is put into the project, there is a high probability that it won’t be compatible with desired mods for the game.<br/><br/> Another solution is to use some sort of modloader, a middle man, if you will. This results in it being rather useless to obfuscate your client since you can see all of the API calls. There will **STILL** be compatibility issues with mods that decide to use another modloader or maybe don't use a modloader at all. Another problem is that one needs a version of this modloader that is compatible with the current version of the game this results in one being unable to cheat in snapshot versions of the game. These are a very desirable target for cheaters since there is no public snapshot-server that uses any kind of anticheat.
  * #### My solution: <br/>
  The idea of creating a very different cheating solution ended up in *Irrlicht*. I tried to make sure that my solution was something rather special. I solved the problem of losing cross-version compatibility by wrapping the source code and creating a proxy that forwards the calls to the obfuscated classes:
  
  
  <p align="center">
   <img src="https://raw.githubusercontent.com/nur1popcorn/Irrlicht/master/Mapping.png" width="720" height = "260">
  </p>

### I don't get it

As mentioned before, *Irrlicht* rather analyses static structure than wonky names.

The example below shows the difference between an older version of the game and a newer one: 

```diff
- public abstract class pk implements m
+ public abstract class sn implements n
{
...
-   public double p;
+   public double m;
-   public double q;
+   public double n;
-   public double r;
+   public double o;
...
}
```

The structure stays the same but the names change, here is where *Irrlicht* comes into play.
It analyses the given structure and tries to find this pattern within the obfuscated classes.

*Irrlicht* will then through [`Wrapper`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/wrappers/Wrapper.java)s make this code accessible to you.

Still don't get it?<br/>
Well, too bad for you.<br/>
Just kidding you can contact me [here](https://github.com/nur1popcorn/Irrlicht#contact) and I will try my best to explain it to you.

## Features
The most important characteristics of *Irrlicht* are:
- Quality
- Cross version compatibility  "write it once, use it always"
- Easy usability while maintaining a high level of customizability
- High probability for mod support

## Getting started

Now its time to enter the playground. These few guides will give you some advice on the basics stuff:

### Mapper

The mapper is responsible for creating and storing the mappings for all of the registered wrappers.

* ### Wrappers
  [`Wrapper`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/wrappers/Wrapper.java)s are a way of making the obfuscated classes easily accessible.
  
  In order to create a new wrapper you have to create an interface and extend [`Wrapper`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/wrappers/Wrapper.java). Then you will have to add a discovery method to the wrapper. This will tell the [`Mapper`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/mapper/Mapper.java) how the class is supposed to be obtained. I suggest looking at the documation of the mapper's class as it shows all of the default ways of obtaining a class. If this doesn't float your boat I suggest telling the mapper to use your custom check and attaching it to the class.
  
  *Note:* Some of the checks will require you to add some additional information to the [`DiscoveryMethod`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/mapper/DiscoveryMethod.java).
  ```java
  @DiscoveryMethod(checks = Mapper.CUSTOM,
                   //The class declaring the class by declaring it as a field or by extending the class.
                   declaring = Other.class,
                   constants = {
                      "Some string used to identify the class.",
                      "More constants."
                   })
  public interface Example extends Wrapper
  {
     ...
  }
  ```
* ### Custom Handlers
 If you are not happy with any of the default ways I provide to obtain a class or a method you may define a custom [`DiscoveryHandler`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/mapper/DiscoveryHandler.java):
 
 ```java
  Mapper.getInstance()
        .register(Example.class, () -> {
           return Class.forName("obf.ObfExample");
        });
 ```

### Hooker

The [`Hooker`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/engine/hooker/Hooker.java) is responsible for hooking all of the registered events. In order to use it, all one has to do is create an event class and attach it to a wrapper.

```java
    @HookingMethod(value = UpdateEvent.class,
                   //inject after the unique array of opcodes.
                   flags = Hooker.DEFAULT | Hooker.OPCODES | Hooker.AFTER,
                   opcodes = {
                       //inject after super call.
                       Opcodes.ALOAD,
                       Opcodes.INVOKESPECIAL
                   })
    public void onUpdate();
```

The method we are hooking would look something like this when we are done:

```diff
public void t_()
{
   if (!o.e(new cj(s, 0, u)))
      return;
   super.t_();
+  EventManager.call(new UpdateEvent());
   if (au())
   {
      this.a.a(new ip.c(y, z, C));
      this.a.a(new it(aZ, ba, b.c, b.d));
   }
   else
      p();
}
```

### Modules

Modules are the different kinds of cheats that can be enabled.

```java
@ModuleInfo(name = "Fly",
            category = Category.MOVEMENT)
public class Fly extends Module
{
    @Override
    public void onDisable()
    {
        super.onDisable();
        Irrlicht.getMinecraft()
                .getPlayer()
                .getPlayerAbilities()
                .setFlying(false);
    }

    @EventTarget
    public void onUpdate(UpdateEvent event)
    {
        Irrlicht.getMinecraft()
                .getPlayer()
                .getPlayerAbilities()
                .setFlying(true);
    }
}
```

All one would have to do now is to create an instance of your class and register it in the [`ModuleManager`](https://github.com/nur1popcorn/Irrlicht/blob/master/src/main/java/com/nur1popcorn/irrlicht/modules/ModuleManager.java).

## Built with
- [Maven](https://maven.apache.org/) - Dependency Management
- [ASM](http://asm.ow2.org/) - Bytecode manipulation
- [JavaAssist](http://jboss-javassist.github.io/javassist/) - I pretty much only use this libary to generate proxies for concrete classes (Which isn't to difficult hence I am thinking about booting this one...)
- JavaFx :)

## Contributing
*NOTE:* **DO NOT** contribute to the gui as I am currently rewriting big portions of it.<br/>

Other than that, just create a new pull request.

## Authors
- **nur1popcorn** *(Hackerman)* - *Inital work*
- **Siphedrion**

## License
Copyright (C) Keanu Poeschko - All Rights Reserved

[License](https://github.com/nur1popcorn/Irrlicht/blob/master/LICENSE).

## Contact
If you have any questions regarding the project please contact: nur1popcorn@gmail.com
