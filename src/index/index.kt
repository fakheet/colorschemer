package index

import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.div
import react.dom.render
import react.router.dom.browserRouter
import kotlin.browser.document

fun main(args: Array<String>) {
    requireAll(require.context("src", true, js("/\\.css$/")))

    render(document.getElementById("root")) {
        browserRouter {
            div {
                headerComponent()
                mainComponent()
            }
        }
    }
}
