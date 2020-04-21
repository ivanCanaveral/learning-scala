# Lists

Lists are one of the ost important structures in fuctional programming.

__Lists__ and __arrays__ are *homogeneous* structures: the elements of a list must have the same type. However lists in scala are **immutable** and **recursive**.

`scala.Lists[T]`  is equivalent to `List[T]`

## Cons ::

We can use the constructior `List()` to create new lists, but also is very common to use the **cons** operator and the *empty* list `Nil`. 

`x :: xs` this is a list with a first element `x` and then all the elements of `xs`.

For example, the next expressions are equivalent:

```scala
List(1,2,3) <=> 1 :: (2 :: (3 :: Nil))
```

**Tip 1:** In scala, operators ending in `:` are associative to the right:

```scala
1 :: (2 :: (3 :: Nil)) <=> 1 :: 2 :: 3 :: Nil
```

**Tip 2:** We can also use the `cons` operator as an usual method, using the usual `.method` notation. In this case it works like a `prepend` method:

```scala
Nil.::(3).::(2).::(1) <=> 1 :: 2 :: 3 :: Nil
```

To sum up, the next four expressions are equivalent:

```scala
List(1,2,3)

1 :: (2 :: (3 :: Nil))

Nil.::(3).::(2).::(1)

1 :: 2 :: 3 :: Nil
```

## Methods

Some of the most relevant methods of Lists are `.head`, `.tail` or `.isEmpty`.

## Pattern matching

And some of the possible patterns are:

```scala
Nil
List()
x::xs
List(x1, ..., xn)
```