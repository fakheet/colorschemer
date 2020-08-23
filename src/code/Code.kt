package code

import react.*
import react.dom.div
import styled.css
import styled.styledDiv
import styled.styledPre
import styled.styledSpan
import themes.ThemeCss

//fun RBuilder.code(theme: ThemeCss) = child(Code::class) {
//    attrs.t = theme
//}
//
//class Code(props: Props) : RComponent<Code.Props, RState>(props) {
//    interface Props : RProps {
//        var t: ThemeCss
//    }
//
//    override fun RBuilder.render() {
////        console.log("Code.render: theme is ${props.t.name}")
//        styledPre {
//            css {
//                +"codewindow"
//                +props.t.fg.wrapper
//                +props.t.bg.wrapper
//            }
//            div { +"  " }
//            div {
//                styledSpan {
//                    css { +props.t.keyw2.wrapper }
//                    +"  import"
//                }
//                +" java.io.*"
//            }
//            div {
//                styledSpan {
//                    css { +props.t.keyw2.wrapper }
//                    +"  import"
//                }
//                +" java.util.*;"
//            }
//            div { +"  " }
//            div {
//                styledSpan {
//                    css { +props.t.keyw2.wrapper }
//                    +"  public class "
//                }
//                styledSpan {
//                    css { +props.t.func.wrapper }
//                    +"KeyboardIntegerReader "
//                }
//                +"{"
//            }
//            div {
//                styledSpan {
//                    css { +props.t.keyw2.wrapper }
//                    +"      public static void "
//                }
//                styledSpan {
//                    css { +props.t.func.wrapper }
//                    +"main "
//                }
//                +"(String[] args) "
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"throws "
//                }
//                +"java.io.IOException {"
//            }
//            div { +"          String s1;" }
//            div { +"          String s2;" }
//            div {
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.stri.wrapper }
//                    +"          int "
//                }
//                +"num = "
//                styledSpan {
//                    //                    css { +state.intb.wrapper }
//                    css { +props.t.intb.wrapper }
//                    +"0"
//                }
//                +";"
//            }
//            styledDiv {
//                //                css { +state.cmnt.wrapper }
//                css { +props.t.cmnt.wrapper }
//                +"          // set up the buffered reader to read from the keyboard"
//            }
//            div {
//                +"          BufferedReader br = "
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"new "
//                }
//                +"BufferedReader ("
//                styledSpan {
//                    //                    css { +state.keyw2.wrapper }
//                    css { +props.t.keyw2.wrapper }
//                    +"new "
//                }
//                +"InputStreamReader ("
//            }
//            div { +"                  System.in));" }
//            div {
//                styledSpan {
//                    //                    css { +state.stri.wrapper }
//                    css { +props.t.stri.wrapper }
//                    +"          boolean "
//                }
//                +"cont = "
//                styledSpan {
//                    //                    css { +state.intb.wrapper }
//                    css { +props.t.intb.wrapper }
//                    +"true"
//                }
//                +";"
//            }
//            div {
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"          while "
//                }
//                +"(cont) {"
//            }
//            div {
//                +"              System.out.print ("
//                styledSpan {
//                    //                    css { +state.stri.wrapper }
//                    css { +props.t.stri.wrapper }
//                    +"\"Enter an integer:\""
//                }
//                +");"
//            }
//            div { +"              s1 = br.readLine();" }
//            div {
//                +"              StringTokenizer st = "
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"new "
//                }
//                +"StringTokenizer (s1);"
//            }
//            div {
//                +"              s2 = "
//                styledSpan {
//                    //                    css { +state.stri.wrapper }
//                    css { +props.t.stri.wrapper }
//                    +"\"\""
//                }
//                +";"
//            }
//            div {
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"              while "
//                }
//                +"(cont && st.hasMoreTokens()) {"
//            }
//            div {
//                styledSpan {
//                    //                    css { +state.keyw.wrapper }
//                    css { +props.t.keyw.wrapper }
//                    +"                  try "
//                }
//                +"{"
//            }
//            div { +"                      s2 = st.nextToken();" }
//            div { +"                      num = Integer.parseInt(s2);" }
//            div {
//                +"                      cont = "
//                styledSpan {
//                    //                    css { +state.intb.wrapper }
//                    css { +props.t.intb.wrapper }
//                    +"false"
//                }
//                +";"
//            }
//            div { +"                  }" }
//            div { +"              }" }
//            div { +"          }" }
//            div { +"      }" }
//            div { +"  }" }
//            div { +"  " }
//        }
//    }
//}
//
