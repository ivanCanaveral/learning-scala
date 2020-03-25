# Part 03: Hierarchies

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