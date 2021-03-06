#Java设计模式七大原则
1.单一职责原则  
2.开闭原则  
3.里氏替换原则  
4.依赖倒置原则  
5.接口隔离原则  
6.迪米特法则  
7.组合/聚合复用原则  

##单一职责原则（Single Responsibility Principle）—高内聚、低耦合
>定义：不要存在多于一个导致类变更的原因。通俗的说，一个类只负责一项职责，应该仅有一个引起它变化的原因。  

>适用于：模块、类、接口、方法。  

>优点：降低复杂度;提高可读性，系统的可维护性;降低变更引起的风险。

>建议：接口一定要做到单一职责，类的设计尽量做到只有一个原因引起变化。


##开闭原则（Open Close Principle）—— 高内聚、低耦合
定义：一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。
面对新需求，对程序的改动是通过增加新代码进行的，而不是更改现有的代码。
经典的话说：过去的事已成为历史，是不可修改的，因为时光不可倒流，但现在或明天计划做什么，是可以自己决定（即扩展）的。
怎样的设计才能面对需求的改变却可以保持相对稳定，从而使得系统可以在第一个版本后不断推出新的版本呢？开放-封闭。
在发生小的变化时，就及早去想办法应对发生更大变化的可能。
等到发生变化时立即采取行动。创建抽象来隔离以后发生的同类变化。
开发人员应该对程序中频繁变化的那部分做出抽象。
拒绝不成熟的抽象和抽象本身一样重要。

##里氏替换原则（Liskov Substitution Principle）——低耦合
定义：子类型必须能够替换掉它们的父类型。
里氏替换原则通俗的来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。
子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
子类中可以增加自己特有的方法。
如果不遵循里氏替换原则，代码出现问题的几率会大大的增加。

##依赖倒置原则（Dependence Inversion Principle）
定义：高层模块不应该依赖底层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象；即针对接口编程，不要针对实现编程。
程序中所有的依赖关系都终止于抽象类或者接口，那就是面向对象的设计，反之那就是过程化的设计。
这个是开闭原则的基础。
“面向接口编程”——OOD（Object-Oriented Design，面向对象设计）的精髓之一。
在实际编程中，我们一般需要做到如下3点：
底层模块尽量都要有抽象类或接口，或者两者都有。
变量的声明类型尽量是抽象类或接口。
使用继承时遵循里氏替换原则。

##接口隔离原则（Interface Segregation Principle）——高内聚
含义：建立单一接口，尽量细化接口，接口中的方法尽量少。
为各个类建立专用的接口。
在程序设计中，依赖几个专用的接口要比依赖一个综合的接口更灵活。
运用接口隔离原则，一定要适度，接口设计的过大或过小都不好。
设计接口的时候，只有多花些时间去思考和筹划，才能准确地实践这一原则。

##迪米特法则（Law Of Demeter）——松耦合
迪米特法则又叫最少知道原则，通俗的来讲，就是一个类对自己依赖的类知道的越少越好。
也就是说，对于被依赖的类来说，无论逻辑多么复杂，都尽量地的将逻辑封装在类的内部，对外除了提供的public方法，不对外泄漏任何信息。
迪米特法则还有一个更简单的定义：只与直接的朋友通信。
一句话总结就是：一个对象应该对其他对象保持最少的了解。

##组合/聚合复用原则（Composition/Aggregation Reuse Principle ）——松耦合
尽量使用合成和聚合，而不是集成来达到复用的目的。
该原则就是在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分,新的对象通过向这些对象的委派达到复用已有功能的目的



#JAVA 设计模式(23种)
##1.创建型模式（5种）
    这些设计模式提供了一种在创建对象的同时隐藏创建逻辑的方式，而不是使用 new 运算符直接实例化对象。
    这使得程序在判断针对某个给定实例需要创建哪些对象时更加灵活。
* 工厂模式（Factory Pattern）  
* 抽象工厂模式（Abstract Factory Pattern）  
* 单例模式（Singleton Pattern）  
* 建造者模式（Builder Pattern） 
* 原型模式（Prototype Pattern）  


##2.结构型模式（8种）
    这些设计模式关注类和对象的组合。继承的概念被用来组合接口和定义组合对象获得新功能的方式。
 * 适配器模式（Adapter Pattern）  
 * 桥接模式（Bridge Pattern）  
 * 过滤器模式（Filter、Criteria Pattern）  
 * 组合模式（Composite Pattern）  
 * 装饰器模式（Decorator Pattern）  
 * 外观模式（Facade Pattern）  
 * 享元模式（Flyweight Pattern）  
 * 代理模式（Proxy Pattern）  
 ##3.行为型模式
     这些设计模式特别关注对象之间的通信。
	
*责任链模式（Chain of Responsibility Pattern）  
*命令模式（Command Pattern）  
*解释器模式（Interpreter Pattern）  
*迭代器模式（Iterator Pattern）  
*中介者模式（Mediator Pattern）  
*备忘录模式（Memento Pattern）  
*观察者模式（Observer Pattern）  
*状态模式（State Pattern）  
*空对象模式（Null Object Pattern）  
*策略模式（Strategy Pattern）  
*模板模式（Template Pattern）  
*访问者模式（Visitor Pattern）      