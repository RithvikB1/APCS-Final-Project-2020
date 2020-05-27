# APCS-Final-Project-2020
[Colosseum Games]  

**Authors**: Aditya Senthilvel, Rithvik Bhakri, Richard Huang

**Revision**: 4/16/20 (OUT OF DATE, CHECK DOC FOLDER LOCATED IN PROJECT FOR UPDATED README)

**Introduction**: 

Our program is a game that revolves around waves of enemies spawning for each wave and the player needs to kill all the enemies before moving onto the next wave. The purpose of our program is for people who are feeling bored. If they are feeling bored and have nothing else to do, they should come play our game! The story of the game is as follows: 5 demigods have been chosen by the Three Fates to vanquish the enemies that plague Greece. However, due to mysterious circumstances, this time the gods are not on your side! You have to vanquish them to relinquish the curse that is upon them. But as you slay enemies one by one, you approach the real mastermind behind it all.

The goal of this game is to beat the incoming enemies wave by wave. There are 20 waves that you have to defeat including a final boss wave. The rules of this game are that you have to select one avatar from a list of avatars that is provided to you. The avatar you select will be the avatar you play with for all 20 rounds. Each avatar has different skills that give them an advantage in the game. This is a game where you are in an arena(square) where enemies are coming from all sides. There are three statistics that every avatar has: Attack Speed, Health, and Speed. After three rounds a merchant will come and offer you to upgrade one of your statistics. When you upgrade your stats, they are there only for 20 seconds, except for Health as that is a permanent upgrade. You can only upgrade one statistic per merchant visit.

People who would want to use our program are anyone who has even a slight passion in gaming! It is meant for all types of gamers! The main features of our program are as follows: the user can pick 1 of 5 heroes to progress through the game, and the user can also choose their desired difficulty level. In terms of the gameplay, there will be: characters, an arena in which the player moves, and where the hero (the player) is tasked to kill enemies as the levels progress through the game. Every few waves, there will be options to upgrade weapons and additionally, there will also be mini bosses every few waves, which the player has to work through until the final boss, who after defeating allows the player to finish the game. 

**Instructions**:

Explain how to use the program. This needs to be **specific**: 

Which keyboard keys will do what? 

WASD to move the character around

Where will you need to click? 

You will click to fire and aim, you will need to click through the start menu and if you choose to go to the upgrade menu, you will have to click around in order to upgrade your stats.

Will you have menus that need to be navigated? What will they look like? 

Start menu and the upgrade menu, rules screen 

Do actions need to be taken in a certain order?

You need to defeat the enemies in certain order of waves

**Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER)**:

**Must-have Features**:

[These are features that we agree you will *definitely* have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]

*  5 playable heroes that have their own unique skill set and weapon. The player will pick one hero to progress through the story. These characters will be famous Greek demigods, and their skill set and weapon will be based on the way these demigods are depicted in Greek Mythology.

* The program will feature an arena in which the player must kill the enemies. The player will start off in the middle of the arena as enemies come pouring in through all sides of the arena, and the player must kill as many as possible.

*  Enemy number and/or difficulty progresses as the number of waves/rounds gets higher. More difficult enemies will appear as the waves increase, and the number of easier enemies as waves progress will also increase. Every few waves, a "mini boss" will appear that the player must kill in order to progress through the game, and it will be stronger than any of the enemies the player has encountered in previous waves.

* HP replenishment and shop: When vanquished, more difficult enemies have a higher chance to drop HP (which will be a relatively medium to high drop) as compared to weaker enemies who have a much lower chance to drop HP (which, if dropped, will be low) A merchant will appear every few rounds to offer the player an upgrade for stats or weapons. 

* Different kinds of menus will be shown depending on what the user does and how they progress through the game. For example, the pause menu gives the user the option to click on a button and opens up a menu giving options to resume, restart, or quit. The death menu would appear when the user dies, and then they have the option to play again or quit

**Want-to-have Features**:

[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]

*  Gun = Insta kill any enemy with it but only a 1% drop chance from each boss

*   Different modes => infinite, easy, medium, hard, etc

    * Easy: enemies will be given an amount of HP where the user can defeat them in under 2 minutes

    * Medium: All stats of enemies are raised by a factor of 2 from easy mode

    * Hard: All stats of enemies should be raised by a factor of 5Two player mode = two players can play at the same time and work together to beat the waves from easy mode

*  An interface that shows your stats mid-game 

* Accessories => Merchant will sell you dyes and skins to change the look of your character ie different skills

* Different enemy patterns for example, some would stay a certain distance away from the player and shoot from there and shoot a single fast moving bullet; others would try to jump onto the player and have a radial shot pattern; Some would just be a hitbox and if you touch them you die

* Stopwatch at the top of the game to show how long the player took to beat the game

* Beautiful UI => When you hover over the button you are about the click, that button changes color. The exit button is red colored with natural shading and beautiful "texture." Name Tags under enemies to denote what they are and when you get killed you see a death menu saying what killed you and if you want to continue or not. 

**Stretch Features**:

[These are features that we agree a *fully complete version of this program would have, but that you probably will not have time to implement*. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]

* Two player mode = two players can play at the same time and work together to beat the waves; the second player would join in through networking

* Highscore log to show records of how long it took people to beat the game

* Dialogue between heroes and cured gods after curing the mini bosses of their curse to show storyline progression 

* Have an OST with different music per 5 waves and different music for the merchant and the start menu. Have a sound effect for pausing, shooting, etc.

**Class List**:

[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]

* Character Class - super class of hero class and enemy class, will contain similar features of heroes and enemies

    * Enemy Class extends Character - represents an enemy in the game 

    * Hero Class extends Character  - represents the heroes available in the game

* Menu Class: class to store all the menus in the game such as the menu when you open the game, when you die, or if you pause the game. (will store difficulty level-player chosen)

* DrawingSurface: will decide when waves are implemented and will incorporate when the different menus will be implemented

* Wave Class: decides what Enemy objects go into the wave and how they behave, and enemy level/behavior will increase as waves increase

**Credits**:

Aditya - DrawingSurface, ½ Wave, ½ Hero

Richard - Character, ½ Wave, ½ Enemy

Rithvik - Menu, ½ Enemy, ½ Hero

Outside libraries:

Processing

Chill Kirby beats (music)
