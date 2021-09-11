import java.awt.Color

class Ground(x: Int, y: Int, elevation: Int): Tile(x, y) {
    init{
        color = Color.GREEN
    }

    constructor(tile: Tile) : this(tile.x, tile.y, tile.elevation) {
        color = Color.GREEN
    }
}