package linked.list

import scala.annotation.tailrec

trait LinkedList {
    def length: Int
    def add(elem: Int): LinkedList
}

class EmptyLinkedList extends LinkedList{
    def length = 0
    def add(elem: Int) = new NonEmptyLinkedList(elem, new EmptyLinkedList)
}

class NonEmptyLinkedList(val head: Int, val tail: LinkedList) extends LinkedList {
    
    @tailrec
    private def lengthAcc(acc: Int, tail: LinkedList): Int =
      if (tail.isInstanceOf[EmptyLinkedList]) acc
      else lengthAcc(acc + 1, tail)
    
    def length = lengthAcc(1, tail)

    def add(elem: Int) = new NonEmptyLinkedList(elem, this)
}