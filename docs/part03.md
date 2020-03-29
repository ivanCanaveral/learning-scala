# Part 03: Hierarchies

## Abstract classes

In scala we can define *abstract classes*, that only define their members without implement them.

```scala
abstract class Tree {
  def contains(x: Int): Boolean
  def add(y: Int): Tree
}
```

No instances of an abstract class can be created. We use it as a **superclass**.

```scala
class EmptyBinaryTree extends Tree {
  def contains(x: Int): Boolean = False
  def add(x: Int): BinaryTree = new BinaryTree(x, new EmptyBinaryTree, new EmptyBinaryTree)
}
```

The direct or indirect superclasses of a class `C` are called __base classes__
of `C`. So, the base classes of `EmptyBinatyTree` are `Tree` and `Object`.

## Project structure

In scala, each application should contain an object with a main method.

```scala
object Hello {
  def main(args: Array[String]) = println(”hello world!”)
}
```

### packages

Classes and objects are organized in packages. You can then refer to them by its fully qualified name or you can use an import. You can import from either a package or an object.

Some entities are automatically imported in any Scala program:
* All members of __package scala__
* All members of __package java.lang__
* All members of the __singleton object scala.Predef__ .

Here are the fully qualified names of some types and functions

```scala
Int       scala.Int
Boolean   scala.Boolean
Object    java.lang.Object
require   scala.Predef.require
assert    scala.Predef.assert
```

## Traits

In Scala, a class can only have one superclass. __Classes, objects and traits can inherit from at most one class but arbitrary many traits.__ A trait is similar to an abstract class, but taits cannot have parameters.

```scala
trait Cointainer {
    def contains(x: Int): Boolean
}
```

We can inherit using `extends` but also using `with`:

```scala
NonEmptyBTree(...) extends BTree with Cointainer
```

### tip

These lines are equivalent:

```scala
class MyClass(val head: Int, val tail: IntList) extends IntList ...

class MyClass(_head: Int, _tail: IntList) extends IntList {
  val head = _head
  val tail = _tail
}
```

## Special types

### Any, AnyRef, AnyVal

* `Any`: the base type of all types. Defines this methods: `==`, `!=`, `equals`, `hashCode, `toString`.
* `AnyRef`: Alias of ‘java.lang.Object‘
* `AnyVal`: Base type of all primitive types (`Int`, `Float`, etc)

```scala
Any
 |
 |__ AnyRef
 |      |
 |      |___ scala.Object
 |      |___ java.lang.String
 |      ...
 |
 |__ AnyVal
        |___ scala.Int
        |___ scala.Double
        ...
```

### Nothing

`Nothing` is a subtype of every other type. There is no value of type Nothing, just is useful to signal abnormal termination (exceptions) as an element type of empty collections.

### Null

Null is a subtype of every class that inherits from `Object`, so it is incompatible with subtypes of `AnyVal`. Every reference class type also has `null` as a value. The type that the compiler infers for a variable with value `null` is `Null`.

```scala
val x = null // x: Null
val y: String = null // y: String
val z: Int = null // error: type mismatch
```