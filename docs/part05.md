# Cases

## case classes

Este es un tipo de clase, que además de la clase usual implementa de manera implícita un objeto con el mismo nombre, que actúa como generador de objetos.

> En *scala* es muy común generar un objeto que genera nuevas instancias de la clase.
> De este modo, la lógica de creación de las nuevas instancias puede estar dentro de este objeto, dejando así la clase más limpia, y legible. Es una manera de externalizar los constructores.
> No existe ningún problema en tener una clase y un objeto con el mismo nombre. *scala* está pensado para trabajar sin problemas en este sentido.

En concreto, si generamos una clase siguiendo este patrón:

```scala
case class Number(n: Int) extends Expr {
    ...
}
```

Se generará un objeto como el siguiente:

```scala
object Number {
    def apply(n: Int) = new Number(Int)
}
```

> El método **apply** es un método especial en *scala*. Es el método que aplican por defecto las funciones, por ejemplo. Convierte los objetos en `callables`. Esto quiere decir que si tuviésemos un objeto generador como el siguiente:
> ```scala
> object Number {
>    def generateNumber(n: Int) = new Number(Int)
>}
> ```
> para generar un nuevo elemento tendríamos que ejecutarlo del siguiente modo:
> ```scala
> Number.generateNumber(1)
> ```
> mientras que si lo generamos utilizando el método `apply`, bastará con hacer lo siguiente:
> ```scala
> Number(1)
> ```
> Por supuesto, apply no se utiliza únicamante en los generadores, si no que puede utilizarse en cualquier clase u objeto. Aquí, las `case classes` lo utilizan junto al patrón del objeto generador para poder ahorrarnos tener que escribir la palabra `new` cada vez que generamos un nuevo `Number`, y porque además el resultado de esta combianción es especialmente adecuado para trabajar con la herramienta que introduciremos a continuación: **pattern matching**.