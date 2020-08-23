package themes

import kotlinx.css.*
import styled.StyleSheet

class Theme(
        val name: String,
        var bg: String, // Default Background
        var fg: String, // Default Foreground, Caret, Delimiters, Operators
        var keyw: String, // Keywords
        var keyw2: String, // Keywords
        var func: String, // Functions, Methods
        var intb: String, // Integers, Boolean, Constants
        var stri: String, // Strings
        var cmnt: String // Comments
)

class ThemeCss(
        var name: String,
        var bg: BackgroundStyle,
        var fg: TextStyle,
        var keyw: TextStyle,
        var keyw2: TextStyle,
        var func: TextStyle,
        var intb: TextStyle,
        var stri: TextStyle,
        var cmnt: TextStyle
)


class TextStyle(colorCode: String, styleName: String) : StyleSheet(styleName, isStatic = true) {
    val wrapper by css {
        color = Color(colorCode)
    }
}

class BackgroundStyle(colorCode: String, styleName: String) : StyleSheet(styleName, isStatic = true) {
    val wrapper by css {
        backgroundColor = Color(colorCode)
    }
}
