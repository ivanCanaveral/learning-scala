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

 ## Practical example

 Supongamos que tenemos una definición de listas en lazadas y queremos definir un método `prepend`.

 ```scala
trait List[+T] {
    def preprend(elem: T: List[T])
}
 ```

 Esto no funcionaría por los siguientes motivos:

 * Dada la definición de `+T`, este parámetro únicamente puede aparecer en los outputs, pero no en los inputs.
 * Supongamos que tenemos el tipo `IntSet`, tal que `EmptyIntSet <: IntSet` y `NonEmptyIntSet <: IntSet`. Supongamos ahora además que `xs: IntSet`. Entonces, no habría problema en aplicar la siguiente operación: `xs.prepend(x: EmptyIntSet)`.
 * Ahora, como la definición del parámetro es `+T`, trendríamos que si `ys: NonEmptyIntSet`, entonces `List[NonEmptyIntSet] <: List[IntSet]`, por lo que el tipo de `ys` es subtipo del tipo de `xs`. Sin embargo, `ys.prepend(y: EmptyIntSet)` no es una operación válida.
 * Así, hemos encontrado una propiedad `q(x)` que se cumple para la superclase `IntSet`, pero no para una de sus subclases, `NonEmptyIntSet`, en contra del *Principio de Sustitución de Liskov*.

 Por tanto nuestra definición de tipos no es correcta. Sin embargo, podemos hacer un pequeño arreglo rápido para poder trabajar con ello. 

 Si utilizamos cotas para el tipo de parámetros se puede solucionar fácilmente:

```scala
def preprend [U >: T] (elem: U): List[U] {
    ...
}
```

Con esta definición estamos forzando a que `U` sea subtipo de algo. De este modo, forzaríamos a que estos tipos sean o bien `NonEmptyIntSet` o bien `EmptyIntSet`. (?) no lo tengo claro...
