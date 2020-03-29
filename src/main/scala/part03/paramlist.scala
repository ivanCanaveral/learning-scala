package plist

trait PList[T] {
    def isEmpty: Boolean
    def head: T
    def tail: PList[T]
}

class FullPList[T](val head: T, val tail: PList[T]) extends PList[T] {
    def isEmpty = false
}

class EmptyPList[T] extends PList[T] {
    def isEmpty = true
    def head = throw new NoSuchElementException("Empty head")
    def tail = throw new NoSuchElementException("Empty tail")
}