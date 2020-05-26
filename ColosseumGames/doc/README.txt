-------------------When README is finalized, remove everything above this line--------------------

[Colosseum Games]  
Authors: Aditya Senthilvel, Rithvik Bhakhri, Richard Huang
Revision: 5/10/20

Introduction: 
Our program is a game that revolves around waves of enemies spawning for each wave and the player needs to kill all the enemies before moving onto the next wave. The purpose of our program is for people who are feeling bored. If they are feeling bored and have nothing else to do, they should come play our game! 
The goal of this game is to beat the incoming enemies wave by wave. There are 16 waves that you have to defeat including a final boss wave. The rules of this game are that you have to select one hero from a list of heroes that is provided to you. The hero you select will be the hero you play with for all 16 rounds. Each hero has different skills that give them an advantage in the game. This is a game where you are in an arena(square) where enemies are coming from all sides. There are five statistics that every hero has: Damage, Range, Attack Speed, Health, and Speed. Every so often an upgrade menu will come and allow you to upgrade one of your statistics. You can only upgrade one statistic per merchant visit.
/*****People who would want to use our program are anyone who has even a slight passion in gaming! It is meant for all types of gamers! The main features of our program are as follows: the user can pick 1 of 5 heroes to progress through the game, and the user can also choose their desired difficulty level. In terms of the gameplay, there will be: characters, an arena in which the player moves, and where the hero (the player) is tasked to kill enemies as the levels progress through the game. Every few waves, there will be options to upgrade weapons and additionally, there will also be mini bosses every few waves, which the player has to work through until the final boss, who after defeating allows the player to finish the game. *******/

Instructions:
Use WASD to move the character around. Alternatively, the keys can be changed per the user’s desire in Settings. You can aim where the three melee heroes, Perseus, Hercules, and Achilles, attack by maneuvering them into the direction you attack. Chiron's, the bow-wielding hero's, shots can be aimed by pointing the mouse and clicking. For Helen, the AOE mistress, you don't even need to aim at all! Just hold down the Left Mouse Button! 
You will click to fire, and aim in Chiron's case, you will need to click through the start menus and screens and the upgrade menu to choose which stat you want to upgrade. 
Will you have menus that need to be navigated? What will they look like? 
Start menu, choosing a hero, and choosing difficulty before finally coming to the game screen. Additionally, other optional menus and screens are accessible such as credits and settings, as well as pause mid-game. Death menu and merchant menus’ appearances depend on how user progresses through the game.
Do actions need to be taken in a certain order?
You need to defeat the enemies in certain order of waves after going through the initial amount of screens. 

Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
 5 playable heroes that have their own unique skill set and weapon. The player will pick one hero to progress through the story. These characters will be famous Greek demigods, and their skill set and weapon will be based on the way these demigods are depicted in Greek Mythology.
The program will feature an arena in which the player must kill the enemies. The player will start off in the middle of the arena as enemies come pouring in through all sides of the arena, and the player must kill as many as possible.
 Enemy number and/or difficulty progresses as the number of waves/rounds gets higher. More difficult enemies will appear as the waves increase, and the number of easier enemies as waves progress will also increase. Every few waves, a “mini boss” will appear that the player must kill in order to progress through the game, and it will be stronger than any of the enemies the player has encountered in previous waves.
HP replenishment and shop: When vanquished, more difficult enemies have a higher chance to drop HP (which will be a relatively medium to high drop) as compared to weaker enemies who have a much lower chance to drop HP (which, if dropped, will be low) A merchant will appear every few rounds to offer the player an upgrade for stats or weapons. 
Different kinds of menus will be shown depending on what the user does and how they progress through the game. For example, the pause menu gives the user the option to click on a button and opens up a menu giving options to resume, restart, or quit. The death menu would appear when the user dies, and then they have the option to play again or quit

Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
 Gun = Insta kill any enemy with it but only a 1% drop chance from each boss
  Different modes => infinite, easy, medium, hard, etc
Easy: enemies will be given an amount of HP where the user can defeat them in under 2 minutes
Medium: All stats of enemies are raised by a factor of 2 from easy mode
Hard: All stats of enemies should be raised by a factor of 5Two player mode = two players can play at the same time and work together to beat the waves from easy mode
 An interface that shows your stats mid-game 
Accessories => Merchant will sell you dyes and skins to change the look of your character ie different skills
Different enemy patterns for example, some would stay a certain distance away from the player and shoot from there and shoot a single fast moving bullet; others would try to jump onto the player and have a radial shot pattern; Some would just be a hitbox and if you touch them you die
Stopwatch at the top of the game to show how long the player took to beat the game
Beautiful UI => When you hover over the button you are about the click, that button changes color. The exit button is red colored with natural shading and beautiful “texture.” Name Tags under enemies to denote what they are and when you get killed you see a death menu saying what killed you and if you want to continue or not. 

Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
Two player mode = two players can play at the same time and work together to beat the waves; the second player would join in through networking
Highscore log to show records of how long it took people to beat the game
Dialogue between heroes and cured gods after curing the mini bosses of their curse to show storyline progression 
Have an OST with different music per 5 waves and different music for the merchant and the start menu. Have a sound effect for pausing, shooting, etc.


Class List:

*Character Class extends Rectangle2D.Double - super class of hero class and enemy class, will contain similar features of heroes and enemies

**Enemy Class extends Character - represents an enemy in the game

***Harpy Class extends Enemy - will be a low-level enemy that follows the player around
***Minotaur Class extends Enemy - will be a medium-level enemy that charges the player
***Hydra Class extends Enemy - will be a high-level enemy that shoots projectiles
***Hydramite Class extends Enemy - will be an enemy that spawns from a dead Hydra
***FinalBoss Class extends Enemy - will be the strongest enemy the player has to face with 4 unique phases

**Hero Class extends Character  - represents the heroes available in the game
**Achilles extends Hero - represents Achilles
**Chiron extends Hero - represents Chiron
**Helen extends Hero - represents Helen
**Hercules extends Hero - represents Hercules
**Perseus extends Hero - represents Perseus

*Bullet Class extends Rectangle2D.Double - represents every projectile in the game
*DrawingSurface extends PApplet - the PApplet used to draw the game
*Main - where the main method is
*Wave - Represents each wave of enemies

Screen - the framework for all screens
ScreenToggler - An interface used to toggle between screens

*ConfirmQuit extends Screen - Creates a screen that confirms if user wants to quit or not, and if so, allows user to terminate program
*DeathMenu extends Screen - Draws the death menu
*GameScreen extends Screen - Draws the actual game
*Pause extends Screen - Draws the pause screen
*Shop extends Screen - Draws the upgrade menu
*VictoryScreen extends Screen - Draws the victory menu

**ChooseDifficulty - Draws the choose difficulty screen
**ChooseHero - Draws the choose hero screen
**Credits - Draws the credits screen
**Rules - Draws the rules screen
**Settings - Draws the setting screen
**StartScreen - Draws the start screen


Credits:

Aditya -  Animations for all Characters
Richard - All Enemies (other than animations), Chiron and Helen (other than animations), Bullet, Designed all sprites
Rithvik - All Screens, Melees (other than animations)

All together - DrawingSurface, GameScreen, Character, Enemy, Hero, Wave

Outside libraries:
Realm of the Mad God Current Sprite Sheets XML (only used as reference not actually implemented in the game)
https://static.drips.pw/rotmg/production/current/sheets/

Processing core and sound
Smash 4 theme music
Mr. Shelby's idea for screen implementation



