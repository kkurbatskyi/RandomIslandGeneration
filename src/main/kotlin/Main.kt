import javax.swing.JFrame

class Main: JFrame() {
    private val WIDTH: Int = 513
    private val HEIGHT: Int = 513
    var visual: Visual
    init{
        isResizable = true
        title = "Island"
        visual = Visual(WIDTH, HEIGHT)
        contentPane = visual
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val window = Main()

            window.setSize(window.WIDTH, window.HEIGHT)
            window.defaultCloseOperation = EXIT_ON_CLOSE
            window.isVisible = true
            //window.visual.start()
        }
    }
}