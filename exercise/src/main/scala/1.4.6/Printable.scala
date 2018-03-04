package ys.ex1_4_6

import cats._
import cats.implicits._

// using the library
final case class Cat(name: String, age: Int, color: String)

object Runner {

  implicit val catShow: Show[Cat] =
    Show.show(c => s"${c.name} is a ${c.age} year-old ${c.color} cat.")

  def main(args: Array[String]): Unit = {
    val cat = Cat(name = "Kitty", age = 5, color = "brown")
    println(s"Using Show constructor: ${cat.show}")
  }
}
