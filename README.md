# learning-scala

In this repository you can find some basic notes and code examples about my first steps with **scala**. It is structured in two main folders: `src` and `docs`.

* `src`: All the `.scala` files, organized in folders. One folder for each part or topic.
* `docs`: Markdown files with some interesting notes on each part.

## Contents

This repository is organized in parts. Below you can find its contents.

* **Part 1:** [call-by-value vs call-by-name. Recursion.](docs/part01.md)
* **Part 2:** [Hihgher order functions and classes.](docs/part02.md)
* **Part 3:** [Project structure and special types.](docs/part03.md)
* **Part 4:** [Advanced parametrized types.](docs/part04.md)
* **Part 5:** [Case classes.](docs/part05.md)
* **Part 6:** [Pattern matching.](docs/part06.md)
* **Part 7:** [Lists](docs/part07.md)
* **Part 8:** [More on Lists](docs/part08.md)

## Running the examples


### Running it using the Dokerfile

You can build and run a simple container ready to run scala using the `Dockerfile` we provide. In order to do this, just execute the following commands:

```
docker build -t learning-scala .
docker run -dit --name learning-scala-container -v ~/workspace/learning-scala:/scala learning-scala
docker attach learning-scala-container
```

Once there, type `sbt` to start *scala build tools* cli.

To launch a scala console, type `console`. To compile your proyect type `compile`, to run it `run`, and `~run` to keep it watching.

### Running it using docker-compose

However, if you have installed `docker-compose` in addition to `docker`, you can do the same by just typing:

```bash
docker-compose up
```

If you want to access the container, yo can do it by typing

```bash
docker-compose exec scala bash
```