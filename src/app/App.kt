package app

import code.code
import code.standaloneSelector
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.files.FileReader
import react.*
import react.dom.button
import react.dom.div
import react.dom.input
import react.dom.pre
import react.router.dom.RouteResultProps
import themes.BackgroundStyle
import themes.TextStyle
import themes.Theme
import themes.ThemeCss

class App : RComponent<RouteResultProps<App.Props>, App.State>() {
    interface Props : RProps {
        var lang: String
    }

    interface State : RState {
        var currentTheme: Theme
        var themes: ArrayList<Theme>
        var cssThemes: ArrayList<ThemeCss>
        var currentCssTheme: ThemeCss
        var textFile: String
    }

    init {
        console.log("initing the init")
        state.themes = arrayListOf(
                Theme("default-white",
                        "#000000",
                        "#ffffff",
                        "#ffffff",
                        "#ffffff",
                        "#ffffff",
                        "#ffffff",
                        "#ffffff",
                        "#ffffff"
                ),
                Theme("base16-default-dark",
                        "#151515",
                        "#d0d0d0",
                        "#ac4142",
                        "#aa759f",
                        "#f4bf75",
                        "#6a9fb5",
                        "#90a959",
                        "#505050"
                )//,
//                Theme("base16-embers-dark",
//                        "#16130f",
//                        "#a39a90",
//                        "#6d5782",
//                        "#82576d",
//                        "#628257",
//                        "#576d82",
//                        "#57826d",
//                        "#515047"
//                )
        )

        state.currentTheme = state.themes[0]
        state.cssThemes = ArrayList<ThemeCss>()

        for (t in state.themes) {
            state.cssThemes.add(cssFromTheme(t))
        }
        state.currentCssTheme = state.cssThemes[0]
    }

    fun changeTheme(themeName: String) {
        for (theme in state.cssThemes) {
            if (theme.name == themeName) {
                setState {
                    currentCssTheme = theme
                }
                break
            }
        }

        for (theme in state.themes) {
            if (theme.name == themeName) {
                setState {
                    currentTheme = theme
                }
                return
            }
        }
        console.log("changeTheme: no theme with a matching name was found")
    }

    fun addTheme() {
//        console.log("file says: ${state.textFile}")
        val lines = state.textFile.split("\n")
        setState {
            themes.add(Theme(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6], lines[7], lines[8]))
            cssThemes.add(cssFromTheme(themes.last()))
        }
    }

    fun cssFromTheme(t: Theme): ThemeCss {
        return ThemeCss(
                t.name,
                BackgroundStyle(t.bg, "${t.name}-bg"),
                TextStyle(t.fg, "${t.name}-fg"),
                TextStyle(t.keyw, "${t.name}-keyw"),
                TextStyle(t.keyw2, "${t.name}-keyw2"),
                TextStyle(t.func, "${t.name}-func"),
                TextStyle(t.intb, "${t.name}-intb"),
                TextStyle(t.stri, "${t.name}-stri"),
                TextStyle(t.cmnt, "${t.name}-cmnt")
        )
    }

    override fun RBuilder.render() {
        val lang = props.match.params.lang
        val themes = state.themes
        val currentTheme = state.currentTheme
        console.log(currentTheme.name)
        val currCssTheme = state.currentCssTheme

        code(lang, currCssTheme)
        standaloneSelector(themes) { changeTheme(it) }
        button(classes = "ui") {
            +"Import"
            attrs.onClickFunction = {
                addTheme()
            }
        }
        input {
            attrs.type = InputType.file
            attrs.onChangeFunction = {
                val reader = FileReader()
                reader.readAsText(it.target.asDynamic().files[0])
                reader.onloadend = {
                    setState {
                        textFile = reader.result as String
                    }
                }
            }
        }
        div("description-text") {
            +"Theme .ini file:"
            pre("ini") {
                div("ini-top-div") { +"; name: ${currentTheme.name}" }
                div("ini-middle-div") { +"background        = ${currentTheme.bg}" }
                div("ini-middle-div") { +"foreground        = ${currentTheme.fg}" }
                div("ini-middle-div") { +"keywords          = ${currentTheme.keyw}" }
                div("ini-middle-div") { +"alt-keywords      = ${currentTheme.keyw2}" }
                div("ini-middle-div") { +"functions         = ${currentTheme.func}" }
                div("ini-middle-div") { +"integers-booleans = ${currentTheme.intb}" }
                div("ini-middle-div") { +"strings           = ${currentTheme.stri}" }
                div("ini-bottom-div") { +"comments          = ${currentTheme.cmnt}" }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
