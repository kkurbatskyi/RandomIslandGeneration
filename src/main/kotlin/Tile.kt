import java.awt.Color

open class Tile(_x: Int, _y: Int, _elevation: Int = 0) {
    var x: Int = _x
    var y: Int = _y
    var elevation: Int = _elevation
    var color: Color = Color.WHITE
}