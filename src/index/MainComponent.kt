package index

import app.App
import app.Greeter
import react.RBuilder
import react.dom.div
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.mainComponent() {
    div {
        switch {
            route(
                    exact = true,
                    path = "/",
                    component = Greeter::class
            )
            route(
                    path = "/:lang",
                    component = App::class
            )
        }
    }

}
