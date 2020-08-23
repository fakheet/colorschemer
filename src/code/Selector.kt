package code

import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.option
import react.dom.select
import themes.Theme


fun RBuilder.standaloneSelector(themes: ArrayList<Theme>, onChange: (String) -> Unit) {
    select("select") {
        attrs.onChangeFunction = {
            val value: String = it.target.asDynamic().value as String
            onChange(value)
        }
        for (theme in themes) {
            option {
                attrs.value = theme.name
                +theme.name
            }
        }
    }
}
