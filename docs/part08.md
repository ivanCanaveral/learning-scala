# More on lists

## Insert sort

```scala
def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y::ys => insert(y, isort(ys))
}

def insert(y: Int, ys: List[Int]) = xs match {
    case List() = List(y)
    case x::xs => if x<y x::insert(y, ys) else y::ys
}
```