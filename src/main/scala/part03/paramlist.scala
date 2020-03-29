package plist

trait Plist[T] {
    def isEmpty: Boolean
    def head: T
    def tail: Plist[T]
}

class FullPlist[T](val head:T, val tail: Plist[T]) extends Plist[T] {
    def isEmpty = false
}

class EmptyPList[T] extends Plist[T] {
    def isEmpty = true
    def head = throw new NoSuchElementException("Empty head")
    def tail = throw new NoSuchElementException("Empty tail")
}