package code

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import styled.css
import styled.styledPre
import styled.styledSpan
import themes.ThemeCss

fun RBuilder.code(lang: String, theme: ThemeCss) = child(Code::class) {
    attrs.lang = lang
    attrs.t = theme
}

class Code(props: Props) : RComponent<Code.Props, RState>(props) {
    interface Props : RProps {
        var t: ThemeCss
        var lang: String
    }

    override fun RBuilder.render() {
        styledPre {
            css {
                +"codewindow"
                +props.t.fg.wrapper
                +props.t.bg.wrapper
            }
            div { +"  " }
            when (props.lang) {
                "java" -> highlightJava(javaLines, props)
                "python" -> highlightPython(pythonLines, props)
                "rust" -> highlightRust(rustLines, props)
                else -> highlightJava(javaLines, props)
            }
            div { +"  " }
        }
    }
}

fun RBuilder.highlightJava(lines: List<String>, props: Code.Props) {
    for (line in lines) {
        val words = line.splitKeeping(" ", ";", "\"", "(", ")")
        div {
            for (w in words) {
                styledSpan {
                    +w
                    when (w) {
                        "package", "import", "class", "public", "private", "static" ->
                            css { +props.t.keyw2.wrapper }
                        "new", "throws", "while", "for", "try", "catch" ->
                            css { +props.t.keyw.wrapper }
                        "main" ->
                            css { +props.t.func.wrapper }
                        "int", "boolean", "void" ->
                            css { +props.t.stri.wrapper }
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                            css { +props.t.intb.wrapper }
                        "true", "false" ->
                            css { +props.t.intb.wrapper }
                        "\"", "Enter", "an", "integer:" ->
                            css { +props.t.stri.wrapper }
                        "//", "set", "up", "the", "buffered", "reader", "to", "read", "from", "keyboard" ->
                            css { +props.t.cmnt.wrapper }
                    }
                }
            }
        }
    }
}

fun RBuilder.highlightPython(lines: List<String>, props: Code.Props) {
    for (line in lines) {
        val words = line.splitKeeping(" ", "'", "=", ":", "\"", "(", ")")
        div {
            for (w in words) {
                styledSpan {
                    +w
                    when (w) {
                        "def", "if", "or", "print", "return", "class", "pass" ->
                            css { +props.t.keyw2.wrapper }
                        "@requires_authorization", "param1", "param2", ">>>", "..." ->
                            css { +props.t.keyw.wrapper }
                        "somefunc", "SomeClass" ->
                            css { +props.t.func.wrapper }
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                            css { +props.t.intb.wrapper }
                        "None", "0b10l" ->
                            css { +props.t.intb.wrapper }
                        "'", "r", "prompt", "A", "docstring", "Gre\\", "ater" ->
                            css { +props.t.stri.wrapper }
                        "#", "interesting" ->
                            css { +props.t.cmnt.wrapper }
                    }
                }
            }
        }
    }
}

fun RBuilder.highlightRust(lines: List<String>, props: Code.Props) {
    for (line in lines) {
        val words = line.splitKeeping(" ", ",", ";", "::", "(", ")")
        div {
            for (w in words) {
                styledSpan {
                    +w
                    when (w) {
                        "let", "fn" ->
                            css { +props.t.keyw2.wrapper }
                        "use", "*", "extern", "crate", "match", "mut", "&mut", "loop", "=>", "=", "break" ->
                            css { +props.t.keyw.wrapper }
                        "int", "boolean", "void" ->
                            css { +props.t.func.wrapper }
                        "main" ->
                            css { +props.t.stri.wrapper }
                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                            css { +props.t.intb.wrapper }
                        "true", "false" ->
                            css { +props.t.intb.wrapper }
                        "//", "Do", "something", "with", "the", "variable" ->
                            css { +props.t.cmnt.wrapper }
                    }
                }
            }
        }
    }
}

fun String.splitKeeping(str: String): List<String> {
    return this.split(str).flatMap { listOf(it, str) }.dropLast(1).filterNot { it.isEmpty() }
}

fun String.splitKeeping(vararg strs: String): List<String> {
    var res = listOf(this)
    strs.forEach { str ->
        res = res.flatMap { it.splitKeeping(str) }
    }
    return res
}

var javaLines = """
  import java.io.*;
  import java.util.*;
  
  public class KeyboardIntegerReader {
      public static void main (String[] args) throws java.io.IOException {
          String s1;
          String s2;
          int num = 0;
          // set up the buffered reader to read from the keyboard
          BufferedReader br = new BufferedReader (new InputStreamReader (
                  System.in));
          boolean cont = true;
          while (cont) {
              System.out.print ("Enter an integer:");
              s1 = br.readLine();
              StringTokenizer st = new StringTokenizer (s1);
              s2 = "";
              while (cont && st.hasMoreTokens()) {
                  try {
                      s2 = st.nextToken();
                      num = Integer.parseInt(s2);
                      cont = false;
                  }
              }
          }
      }
  } 
""".split("\n")

var pythonLines = """
  @requires_authorization
  def somefunc(param1='', param2=0):
      r'''A docstring'''
      if param1 > param2: # interesting
          print 'Gre\'ater'
      return (param2 - param1 + 1 + 0b10l) or None
  
  class SomeClass:
      pass
  
  >>> message = '''interpreter
  ... prompt''' 
""".split("\n")

var rustLines = """
  #[prelude_import]
  use std::prelude::v1::*;
  #[macro_use]
  extern crate std;
  fn main() {
      {
          let _result = 
              match ::std::iter::IntoIterator::into_iter(::std::ops::Range{ start: 1, end: 3 }) {
                  mut iter => loop {
                      let mut __next;
                      match ::std::iter::IntoIterator::next(&mut iter) {
                          ::std::option::Option::Some(val) => __next = val,
                          ::std::option::Option:None => break,
                      }
                      let n = __next;
                      {
                          // Do something with the variable
                      }
                  },
              };
              _result
      }
  } 
""".split("\n")
