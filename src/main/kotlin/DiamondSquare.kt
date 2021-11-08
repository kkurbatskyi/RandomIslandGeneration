import java.awt.Point
import java.util.ArrayList
import kotlin.random.Random

/*
    Since we are creating an island using the Diamond Square Algorithm, the corners of the map are supposed to be at level 0 (sea-floor),
    while the centerpiece of the map is going to be high, simulating either a mountain or a volcano
*/
class DiamondSquare(_height: Int, _width: Int) {

    val height = _height
    val width = _width
    var initialMountainHeight: Int = 100
    var seaLevel: Int = 50
    var randomRange: Point = Point(initialMountainHeight / -10, initialMountainHeight / 10)
    var map: ArrayList<ArrayList<Tile>>

    init {
        map = ArrayList<ArrayList<Tile>>()
        for(i in 0..height){
            map.add(ArrayList<Tile>())
            for(j in 0..width){
                map[i].add(Tile(i , j))
            }
        }
        map[0][0] = Water(0 , 0 , 0)
        map[0][width - 1] = Water(0, width - 1, 0)
        map[height - 1][0] = Water(height - 1, 0, 0)
        map[height - 1][width - 1] = Water(height - 1, width - 1, 0)
        map[height / 2][width / 2] = Ground(height / 2, width / 2, initialMountainHeight)

        generate(0, height, 0, width, randomRange)
        coloring()
    }
    /*
    Recursive generation (it is terrible. rewrite it at first convenience)
    Initial structure
        [v-------v]
        [---------]
        [----^----]
        [---------]
        [v-------v]
     */
   /* fun generate(beginningX: Int, height: Int, beginningY: Int, width: Int, randRange: Point){
        if(height <= beginningX || width <=beginningY)return
        map[(height - beginningX) / 2][(width - beginningY) / 2] = Tile((height - beginningX) / 2, (width - beginningY) / 2, (map[beginningX][beginningY].elevation
                                                                 + map[height][width].elevation
                                                                 + map[beginningX][width].elevation
                                                                 + map[height][beginningY].elevation) / 4
                                                                 + Random.nextInt(randRange.x, randRange.y))
        val medianElevation = map[(height - beginningX) / 2][(width - beginningY) / 2].elevation;

        map[(height - beginningX) / 2][beginningY] = Tile((height - beginningX) / 2, beginningY, (map[beginningX][beginningY].elevation + map[height][beginningY].elevation + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[(height - beginningX) / 2][width] = Tile((height - beginningX) / 2, width, ((map[beginningX][width].elevation + map[height][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[beginningX][(width - beginningY) / 2] = Tile(beginningX, (width - beginningY) / 2, ((map[beginningX][beginningY].elevation + map[beginningX][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        map[height][(width - beginningY) / 2] = Tile(height, width - beginningY / 2, ((map[height][beginningY].elevation + map[height][width].elevation) + medianElevation) / 3
                                                        + Random.nextInt(randRange.x, randRange.y))
        generate(beginningX, (height - beginningX) / 2, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate((height - beginningX) / 2, height, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate(beginningX, (height - beginningX) / 2, (width - beginningY) / 2, width,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
        generate(beginningX, (height - beginningX) / 2, beginningY, (width - beginningY) / 2,
            Point((randRange.x * 0.7).toInt(), (randRange.y * 0.7).toInt()))
    }*/

    fun generate(){
        var startX = 0
        var endX = height - 1
        var startY = 0
        var endY = width - 1
        var middleX = height / 2
        var middleY = width / 2
        generate(0, 0, middleX, middleY) //top left part
        generate(middleX, 0, endX, middleY) //top right
        generate(0, middleY, middleX, endY) //bottom left
        generate(middleX, middleY, endX, endY) //bottom right
    }

    private fun generate(startX: Int, startY: Int, endX: Int, endY: Int) {
        var middle: Int
        //first: square, then diamond
        for (i in 0..height){
            for(j in 0..width){
                //reference: https://medium.com/@nickobrien/diamond-square-algorithm-explanation-and-c-implementation-5efa891e486f
            }
        }
    }


    //add snow, mountain, coastal waters, deep waters, jungle, plain, beach, cove(?)
    fun coloring(){
        for(row in map){
            for(i in 0..width){
                row[i] = if(row[i].elevation > seaLevel) Ground(row[i]) else Water(row[i])
            }
        }
    }
}

