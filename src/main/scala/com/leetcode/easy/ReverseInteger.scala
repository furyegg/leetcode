package com.leetcode.easy

object ReverseInteger {
  def reverse(x: Int): Int = {
    if (x == Int.MinValue) return 0
    
    var res = 0
    var n = x
    while (n != 0) {
      val unitDigit = n % 10
      if (res < 0 && res < (Int.MinValue - unitDigit) / 10) return 0
      if (res > 0 && res > (Int.MaxValue - unitDigit) / 10) return 0
      res = res * 10 + unitDigit
      n = n / 10
    }
    res
  }
  
  def reverse2(x: Int): Int = {
    if (x > -10 && x < 10) return x
    
    val symbol = if (x < 0) -1 else 1
    val arr = x.toLong.abs.toString.toCharArray
    val reversedArr = reverseArr(arr)
    val reversedStr = String.valueOf(reversedArr)
    val reversedNum = reversedStr.toLong * symbol
    if (reversedNum < Int.MinValue || reversedNum > Int.MaxValue) 0
    else reversedNum.toInt
  }
  
  def reverseArr(arr: Array[Char]): Array[Char] = {
    var i = 0
    var j = arr.size - 1
    while (i < j) {
      swap(arr, i, j)
      i = i + 1
      j = j - 1
    }
    arr
  }
  
  def swap(arr: Array[Char], i: Int, j: Int): Unit = {
    val n = arr(i)
    val m = arr(j)
    val tmp = m ^ n
    arr(i) = (n ^ tmp).toChar
    arr(j) = (m ^ tmp).toChar
  }
  
  def main(args: Array[String]): Unit = {
    println(reverse(-2147483648))
    println(reverse(-2147483647))
    println(reverse(123))
    println(reverse(6))
    println(reverse(210))
    println(reverse(-123))
  }
}