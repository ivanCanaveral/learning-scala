package trees

abstract class BTree {
  def contains(x: Int): Boolean
  def add(x: Int): BTree
}

/*
* Actually, the empty set could always the same object.
* So we could use and object instead of a class to
* optimize this.
*/
class EmptyBTree extends BTree {
  def contains(x: Int): Boolean = false
  def add(x: Int): BTree = new NonEmptyBTree(x, new EmptyBTree, new EmptyBTree)
}

/*
* Elements are unique in this implementation
*/
class NonEmptyBTree(elem: Int, left: BTree, right: BTree) extends BTree {
  def contains(x: Int) =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def add(x: Int) =
    if (x < elem) left add x
    else if (x > elem) right add x
    else this
}