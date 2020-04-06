# Advanced parametrized types

To get the most out of polymyphism, so far we have talked about **sub-typing** and **parameterized types**. Now let's see how we can combine both.

## Parametrized types bounds

We can define type bounds when we are working with parametrized types:

```scala
def myFunction[T <: SomeType](elem: T) = ...
```

Where `T <: SomeType` means that `T` should be a **subtype** of `SomeType`. Also works for **supertypes**, with `T >: SomeType`. Actually, we can use both:

```scala
def myFunction[T >: SomeTypeA <: SomeTypeB](elem: T) = ...
```

## Type variance

> Let q(x) be a property provable about objects x of type B. Then q(y) should be provable for objects y of type A where A <: B. -- Barbara Liskov

Let `C[T]` be a parametrized type, and `A` and `B` types such as that `A <: B`.

There are three possibile relationships between `C[A]` and `C[B]`:

* `C[A] <: C[B]` -> C is **covariant**
* `C[A] >: C[B]` -> C is **contravariant**
* `C[A] x: C[B]` -> C is **novariant**

where `x:` means that neither `C[A]` nor `C[B]` is a subtype of the other.

In scala, by default, the parametrized types are **novariant**, but we can specify the variance of a type by using the following notation:

* `class C[+A] {...}` -> C is **covariant**
* `class C[-A] {...}` -> C is **contravariant**
* `class C[A] {...}` -> C is **novariant**

### Type variance of functions

Functions are *contravariant* in in their argument types and *covariant* in their the type of its outputs.

```scala
trait Function[-A, -O] {
    def apply(x: A): O
}
```

There are some rules that we should keep in mind:

 * **covariant** types can only appear in results
 * **contravariant** types can only appear in parameters
 * **invariant** types can appear everywhere