package app

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1

class Greeter(props: RProps) : RComponent<RProps, RState>(props) {
    override fun RBuilder.render() {
        h1 ("greeter"){
            +"Welcome to my color scheme previewer!"
        }
        div ("greeter") {
            +"Please select the desired programming language from the above."
        }
    }
}
