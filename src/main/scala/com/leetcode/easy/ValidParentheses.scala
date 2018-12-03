package com.leetcode.easy

object ValidParentheses {
  
  val left: List[Char] = List('(', '{', '[')
  val right: List[Char] = List(')', '}', ']')
  
  def isValid(s: String): Boolean = {
    if (s == null || s.isEmpty) return true
  
    val chars = s.toCharArray
    if (right.contains(chars.head)) return false
    
    var stack: List[Char] = Nil
    
    for (c <- chars) {
      if (left.contains(c))
        stack = c :: stack
      else {
        if (stack.isEmpty) return false
        
        val last = stack.head
        if (c == ')' && last == '(' ||
            c == '}' && last == '{' ||
            c == ']' && last == '[')
          stack = stack.tail
        else return false
      }
    }
    
    stack.isEmpty
  }
  
  def main(args: Array[String]): Unit = {
    println(isValid("()"))
  }
}
