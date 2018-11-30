package com.leetcode.easy

object PalindromeNumber {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || (x != 0 && x % 10 == 0)) return false
    if (x < 10) return true
    val reversed = reverse(x)
    reversed == x
  }
  
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
}