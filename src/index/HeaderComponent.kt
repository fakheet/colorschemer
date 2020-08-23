package index

import react.RBuilder
import react.dom.*
import react.router.dom.navLink

fun RBuilder.headerComponent() {
    header(classes = "header") {
        navLink("/", className="header-entry") {
            +"Home"
        }
        navLink("/java", className="header-entry") {
            +"Java"
        }
        navLink("/python", className="header-entry") {
            +"Python"
        }
        navLink("/rust", className="header-entry") {
            +"Rust"
        }
    }
}
