import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.util.*
import javax.swing.JPanel

class Visual(width: Int, height: Int) : JPanel() {

    var island: DiamondSquare
    private var timer: Timer = Timer()

    init{
        isFocusable = true
        island = DiamondSquare(width, height)

        repaint()
    }

    override fun paintComponent(g: Graphics) {
        val g2 = g as Graphics2D
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        )
        paintComponent(g2)
    }

    private fun paintComponent(g2: Graphics2D) {
        for(row in island.map){
            for(tile in row){
                setPixel(tile, g2)
            }
        }
    }

    private fun setPixel(tile: Tile, g2: Graphics2D) {
        g2.color = tile.color;
        g2.drawRect(tile.x, tile.y, 1, 1)
    }
}