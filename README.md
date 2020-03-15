# learning-scala

Notes about scala

## Running the examples

```
docker build -t learning-scala .
docker run -dit --name learning-scala-container -v ~/workspace/learning-scala:/scala learning-scala
docker attach learning-scala-container
```

Once there, type `sbt` to start *scala build tools* cli.

To launch a scala console, type `console`. To compile your proyect type `compile`, to run it `run`, and `~run` to keep it watching.