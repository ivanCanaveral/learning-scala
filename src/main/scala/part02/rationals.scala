package numbers

class Rational(x: Int, y: Int){
  require(y > 0, "denominator should be positive")
  private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd(b, a % b)
  private val g = gcd(x, y) // if we use def here, i'll be computed each time
  val num = x / g // The same here
  val den = y / g // if fact, if we use def fof g, this will be the same as y / gcd(x, y)

  def sum(r: Rational): Rational = 
    new Rational(this.num * r.den + this.den * r.num, this.den * r.den)

  def mult(r: Rational): Rational =
    new Rational(this.num + r.num, this.den * r.den)

  /*
  * the modifier override declares that toString
  * redefines a method that already exists
  * (in the class java.lang.Object )
  */
  override def toString = this.num + "/" + this.den
}