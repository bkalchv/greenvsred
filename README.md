# greenvsred
Green vs. Red

Green vs. Red is a 2D grid game.
The grid consists of cells, that are either red(represented by a 0) or green(represented by a 1). Each cell has a color and a position on the grid.
After a set of 4 rules are applied at once, the grid is being transformed accordingly in a "next generation grid". The 4 rules for the creation of a "next generation grid" are:
  1) If a red cell is surronded by 3 or 6 green cells, it becomes green. (has 3 or 6 green neighoburs)
  2) If a red cell is surrounded by 0,1,2,4,5,7 or 8 green cells, it remains red.
  3) If a green cell is surronded by 0,1,4,5,7 or 8 green cells, it becomes red. (has 0,1,4,5,7 or 8 green neighbours)
  4) If a green cell is surrounded by 2,3 or 6 green cells, it remains green.
*A cell is surrounded by/can have up to 8 neighbours. (4 on the sides and 4 on the corners) 
  
In "Main" there's a program, that outputs in the end the amount of times a certain cell (of choice of the user X1, Y1) has been green throughout a number of generations (choice of the user - N), including the "Generation Zero" grid.
The user firstly inputs the size of the grid. 
  X- the width of the grid(amount of columns), Y- the height of the grid(amount of rows).
After that the next Y lines of X long strings (containing 0s and 1s only) generate the "Generation Zero" grid.
The last two arguements, expected as an input are: 
  - the coordinates X1, Y1 of the cell, which color the program is to inspect throughout different generations
  - N, which represents the amount of different generations of the "Generation Zero" grid, that are to be generated

!NB COORDINATES FORMAT: [X,Y], where in a 3x3 grid: 000 [1,0] is the top center cell. NB! (not as usual)
                                                    111
                                                    000 
