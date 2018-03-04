package ys.ex1_3

trait Printable[A] {
  def format(a: A): String
}

object PrintableInstances {
  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      def format(a: String): String = a
    }

  implicit val intPrintable: Printable[Int] =
    new Printable[Int] {
      def format(a: Int): String = a.toString
    }

  implicit val catPrintable: Printable[Cat] =
    new Printable[Cat] {
      def format(c: Cat): String = {
        // solution uses more strict implementation
        // of converting all member fields into string
        // by calling format methods
        s"${c.name} is a ${c.age} year-old ${c.color} cat."
      }
    }
}

// syntax methods
object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
    def print(implicit p: Printable[A]): Unit = println(p.format(a))
  }
}

object Printable {
  def format[A](a: A)(implicit printable: Printable[A]): String =
    printable.format(a)

  def print[A](a: A)(implicit printable: Printable[A]): Unit =
    println(format[A](a))
}

// using the library
final case class Cat(name: String, age: Int, color: String)

object Runner {
  import PrintableInstances._
  import PrintableSyntax._

  def main(args: Array[String]): Unit = {
    val cat = Cat(name = "Kitty", age = 5, color = "brown")
    println("Using companion object")
    Printable.print(cat)
    println("Using syntax method")
    cat.print
  }
}
