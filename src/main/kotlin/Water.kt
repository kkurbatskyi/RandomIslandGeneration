import java.awt.Color

class Water(x: Int, y: Int, elevation: Int): Tile(x, y) {
    init{
        color = Color.BLUE
    }

    constructor(tile: Tile) : this(tile.x, tile.y, tile.elevation) {
        color = Color.BLUE
    }
}