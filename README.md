# Castillo

# Abstract

Castillo is a 2d-Platform computer game , built on Java.
The player takes on the role of the main protagonist of Castillo.
The idea for Castillo came under the influence of Dangerous Dave .There are similarities between the
two games ,such as level design ,coin collection ,the monsters ,the bonus health ,and the jumping.
The objective of the game is
-->Completion of a time bound level.
-->Collection of coins spread around in the game world to increase score.
-->Avoid/Face/Defeat various enemies and monsters.
The Project is written completely in Java, which include standard Java and applet as well as Graphics
applications.

# Code Description
The game consists of the following main classes :

1. The Game class consists of setting up the JFrame and has the main rendering of
the game is done in it by creating a bufferstrategy and FPS and update method.
Various menu states alike are written in this class which help in switching between
menu states , the only thread of the entire project is created here.

2. The Screen class consists of the rendering of the tiles and sprites which is done by
traversing through the tile/sprite and is stored in the int pixel array.
The collision detection technique adopted involves either the collision by analyzing
the further tile and marking it or having associated rectangles with each of them.

3. Each of the sprite involved has a .png file with it put into the RES folder and is loaded
by first specifying its path in the Spritesheet class and then loading it in Sprite class.
An abstract Tile class involves all the tiles i.e. not switching images in them
and are different from sprites. each of the object declared is a class in itself
where all the methods are overridden and are redefined majorly involving the update and
render methods.

4. An Entity class is an abstract class and has all the entities in the game countable repeating
objects of certain value in number i.e. Enemies ,coins ,bullets ,chains ,etc. are written
both involving mobile and stationary objects.
Again overwritten each time has particular class involved and all of the above objects have lists
associated with them defined in level class.

5. The level class has the methods to add objects into list ,traverse through them and remove them.

6. The Score class has all the score component aspects on screen.

7. The Game class :
Extends Canvas Implements Runnable
-->Creates a Buffered Image of the size of screen
-->Makes an integer array of all the element components of screen in RGB
#The Constructor
-->Sets the size
Constructors which are called in sequence Frame-->Keyboard-->Score-->level-->M-->Player
-->The init function of player-->Mouse listener
Synchronized start() and stop() with a boolean as a flag
#The run method
-->Consists of setting the FPS and TIMER#The Update Method
-->Checking Key Update and menu state for pause screen or end game
-->If not proceed as player.update and level.update
#The Render Method
-->Creates a buffer strategy of 3 checks for it being null and proceeds
-->Clears Screen and checks for menu states if 0 or 1
-->If 0 renders M.k (screen) [Start Screen that is]
-->If 1 allocates player at the defined location with xscroll and yscroll being set
-->Calls of level render and player render accordingly [level.render-->player.render]
-->Level render renders level , player render renders player(DUH)
-->Finally gets all the Graphic components of the screen and
-->Copies the pixel array from screen which has been scanned already and rectangle array for collision
detection
-->Draws all the requisite components onto the screen
-->Disposes all the graphics components

# Future Work
A Game with Multiple levels with increasing difficulty ( more Enemies [number or type] and Player
power-ups ) based on a storyline can be worked upon .

# Bug report and Challenges
Rendering issues at times which includes the Player not completely landing on to the platform.
The Overall FPS of the game greatly varying from one system to another and fluctuatuing at times
despite of lowering the sprites involved and entities rendered.
