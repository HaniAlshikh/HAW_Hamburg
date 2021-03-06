Professor: Dr. Bernd Kahlbrandt  
Author: Hani Alshikh
<div style="text-align: right">15.05.2020</div>

# A05: Generics

## 1. Java Denksportaufgaben

### 1.1. Primitive Types == Equivalence relation

Boxing Conversion:

>"If the value p being boxed is the result of evaluating a constant expression (§15.29) of type boolean, byte, char, short, int, or long, and the result is true, false, a character in the range '\u0000' to '\u007f' inclusive, or an integer in the range -128 to 127 inclusive, then let a and b be the results of any two boxing conversions of p. It is always the case that a == b."

- Definiert „==“ eine Äquivalenzrelation auf den Werten numerischer primitiver Typen in Java?  
    Nein, denn in Java prüft == auf Objekt-Referenzen und nicht Werte. Das heißt alle primitive Typen werden automatisch geboxt.

    - <span color="green">Reflexivität</span>
        
        sei x ein beliebig aber fest primitiver Typ und hat beliebig aber festen Wert, dann gilt x == x. Also Reflexivität ist vorhanden, denn Objekte sind immer gleich sich selbst.
    
    - <span color="green">Symmetrie</span>
    
        sei x ein beliebig aber fest primitiver Typ, hat beliebig aber festen Wert und y = x, dann gilt x == y. Also die Relation ist auch symmetrisch. Nur x mit sich selbst sind gleich, denn alle anderen sind != x und somit ist die Premise falsch und die Implikation wahr.
    
    - <span color="red">Transitivität</span>
    
        sei 128 = x == 128 und 128 == y = 128, dann gilt x != y, **__Widerspruch__**. Dies gilt auch für andere primitiven Typen bei Werten, die die Werten nach Boxing Conversion überschreiten.

### 1.2. Field hiding

- Ist der Code legal?

    Nein.

- Welche Schwächen hat der Code ggfs?

    - Ähnlich zu der LinkedList-Aufgabe verbergt className der Klasse Derived className der Klasse Base, da className der Klasse Derived strenger Access-Modifier hat. Hiding ist in der Regel schlecht und sollte man nicht machen.
    
    - Außerdem Attribute/Fields sollten durch Methoden zugegriffen werden und nicht direkt.

- Wie machen Sie das ggfs. besser, wenn Sie in einer derartigen Situation sind und so etwas benötigen?

    - je nachdem was eigentlich gefragt ist, schreibt man am besten Methoden, die className entsprechend zurückgeben (ob von Base oder Derived).
    
    - wenn man nichts ändern kann und unbedingt className der Klasse Base haben will, könnte man einfach eine Instanz der klasse Base erzeugen und dann ClassName aufrufen
    
    - und wenn das auch nicht erlaubt könnte man Derived auf Base casten und dann ClassName aufrufen  
    
        ```java
        System.out.println(((Base)new Derived()).className);
        ```

##### Quellen
- [Equality and Comparison in Java: Pitfalls and Best Practices](https://medium.com/better-programming/equality-and-comparison-in-java-pitfalls-and-best-practices-96b713e7009)
- [EXP03-J. Do not use the equality operators when comparing values of boxed primitives](https://wiki.sei.cmu.edu/confluence/display/java/EXP03-J.+Do+not+use+the+equality+operators+when+comparing+values+of+boxed+primitives)
- [5.1.7. Boxing Conversion](https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.7)
- [java.util.stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Interface Stream<T>](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)
- [4.8 Implementation of DEQUE using circular array | Data structures](https://www.youtube.com/watch?v=WJres9mgiAk)
- [Mod in Java produces negative numbers](https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers)
- [Java: Maximum length of array](https://programming.guide/java/array-maximum-length.html)
- [Using an Array to represent a Circular Queue](https://www.youtube.com/watch?v=ia__kyuwGag)
- [Why is Deque (ArrayDeque) capacity a power of two?](https://stackoverflow.com/questions/56779739/why-is-deque-arraydeque-capacity-a-power-of-two)