package com.leetcode.easy

object RomanToInteger {
  def romanToInt(s: String): Int = {
    calculate(s.toCharArray.toList, 0)
  }
  
  def calculate(list: List[Char], n: Int): Int = {
    list match {
      case Nil => n
      case 'I' :: 'V' :: t => calculate(t, n + 4)
      case 'I' :: 'X' :: t => calculate(t, n + 9)
      case 'I' :: t => calculate(t, n + 1)
      case 'V' :: t => calculate(t, n + 5)
      case 'X' :: 'L' :: t => calculate(t, n + 40)
      case 'X' :: 'C' :: t => calculate(t, n + 90)
      case 'L' :: t => calculate(t, n + 50)
      case 'X' :: t => calculate(t, n + 10)
      case 'C' :: 'D' :: t => calculate(t, n + 400)
      case 'C' :: 'M' :: t => calculate(t, n + 900)
      case 'C' :: t => calculate(t, n + 100)
      case 'D' :: t => calculate(t, n + 500)
      case 'M' :: t => calculate(t, n + 1000)
    }
  }
  
  def main(args: Array[String]): Unit = {
    println(romanToInt("III"))
    println(romanToInt("IV"))
    println(romanToInt("IX"))
    println(romanToInt("LVIII"))
    println(romanToInt("MCMXCIV"))
  }
}