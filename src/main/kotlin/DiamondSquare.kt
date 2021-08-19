import java.awt.Point
import java.util.ArrayList
import kotlin.random.Random

/*
    Since we are creating an island using the Diamond Square Algorithm, the corners of the map are supposed to be at level 0 (sea-floor),
    while the centerpiece of the map is going to be high, simulating either a mountain or a volcano
*/
class DiamondSquare(height: Int, width: Int) {

    var initialMountainHeight: Int = 100
    var seaLevel: Int = 50
    var randomRange: Point = Point(initialMountainHeight / -10, initialMountainHeight / 10)
    lateinit var map: ArrayList<ArrayList<Tile>>

    init {
        map = ArrayList<ArrayList<Tile>>(height)
        for(i in 0..height){
            map[i] = ArrayList<Tile>(width)
            for(j in 0..width){
                map[i][j] = Tile()
            }
        }
        map[0][0] = Water(0)
        map[0][width - 1] = Water(0)
        map[height - 1][0] = Water(0)
        map[height - 1][width - 1] = Water(0)
        map[height / 2][width / 2] = Ground(initialMountainHeight)

    }
    /*  Initial structure
        [v-------v]
        [---------]
        [----^----]
        [---------]
        [v-------v]
     */
    fun generate(beginningX: Int, height: Int, beginningY: Int, width: Int, randRange: Point){
        if(height <= beginningX || width <=beginningY)return
        map[(height - beginningX) / 2][(width - beginningY) / 2] = Tile((map[beginningX][beginningY].elevation
                                                                 + map[height][width].elevation
                                                                 + map[beginningX][width].elevation
                                                                 + map[height][beginningY].elevation) / 4
                                                                 + Random.nextInt(randRange.x, randRange.y))
        val medianElevation = map[(height - beginningX) / 2][(width - beginningY) / 2].elevation;

        map[(height - beginningX) / 2][beginningY] = Tile((map[beginningX][beginningY].elevation + map[height][beginningY].elevation + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[(height - beginningX) / 2][width] = Tile(((map[beginningX][width].elevation + map[height][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[beginningX][(width - beginningY) / 2] = Tile(((map[beginningX][beginningY].elevation + map[beginningX][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[height][(width - beginningY) / 2] = Tile(((map[height][beginningY].elevation + map[height][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        generate(beginningX, (height - beginningX) / 2, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate((height - beginningX) / 2, height, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate(beginningX, (height - beginningX) / 2, (width - beginningY) / 2, width,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate(beginningX, (height - beginningX) / 2, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
    }

    //add snow, mountain, coastal waters, deep waters, jungle, plain, beach, cove(?)
    fun coloring(){

    }
}

