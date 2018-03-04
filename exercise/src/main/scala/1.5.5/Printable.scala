package ys.ex1_5_5

import cats.Eq
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._
import cats.syntax.eq._

// NOTE: importing cats.syntax.option._ for example breaks compile
//       why is that ?

final case class Cat(name: String, age: Int, color: String)

object Runner {

  implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    cat1.name === cat2.name &&
    cat1.age === cat2.age &&
    cat1.color === cat2.color
  }

  def main(args: Array[String]): Unit = {
    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")

    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]

    println(s"cat1===cat1 is ${cat1 === cat1}")
    println(s"cat1===cat2 is ${cat1 === cat2}")
    println(s"optionCat1===optionCat1 is ${optionCat1 === optionCat1}")
//    println(s"cat1===optionCat1 is ${cat1 === optionCat1}")
    println(s"optionCat1===optionCat2 is ${optionCat1 === optionCat2}")
  }
}
