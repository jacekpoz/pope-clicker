## 0.1
+ made the game
+ added clicking mechanism
+ added 2 upgrades: kremowka, sculpture
+ added the system for adding points for upgrades

## 0.2
+ added kremowka particles

## 0.3
+ overhauled the upgrades
+ added additional text for points and points per second

## 0.3.1
+ added the marysia and szpinak upgrades

## 0.3.2
+ added a background, might change it later
  ~ changed the images from .gif to .png

## 0.4 pre-release 1
+ finally made the gif work
+ added a "special mode":
    + when you get an achievement (might change that) the pope image is replaced with a gif of the pope cranking some sick moves
    + points per click are doubled
    + ends after 10 seconds
      ~ changed most of the polish names to english for consistency
- the special mode is broken - after it ends the pope image doesn't come back

## 0.4
~ almost fixed the bug with the pope disappearing, it only worked the first time

## 0.4.1
+ actually fixed the bug from before

## 0.4.2
+ updated the project to FXGL snapshot mode, in which the issue with mouse button 4 and 5 breaking the game is fixed

## 0.5
+ added a new background and kremówka image, courtesy of JustRafau
+ added a new type of upgrade called the click upgrade, which increases your points per click
+ fixed a bunch of things about the particles that pop up when you click the pope:
    + the particles spin now just like gorila
    + before the particles left a weird trace wherever they moved, it's fixed now
    + particles don't get in the way of clicking on the pope now, they give points when you click on them too
+ finally managed to make the saving / loading mechanism to work, you can now save your progress
  ~ saving your progress creates a save1.sav file on your computer, Idk how to fix that yet but it might not be that big of a problem

## 0.5.1
+ added music I'm sorry

## 0.5.2
+ added an info button in the top right corner of the upgrades
+ added a new PointsPerClickUpgrade - barka

+ reworked most of the code, now instead of cramming everything into PopeClickerApp.java, I made way more classes than before, and the code is much cleaner, easier to read and more importantly easier to work with, which will make future upgrades easier for me to make

## 0.6
+ added a shop for skins:
    + in the shop you can buy 3 crates:
        + pope crate (drops pope skins)
        + background crate (drops background skins)
        + music crate (drops new soundtracks)
          each crate costs 2137 points, and has a really simple animation for the drop that fades it in and out: it lasts 4 seconds in total
    + in the shop you have 3 pickers for the pope skin, background skin and soundtracks

+ added 4 new upgrades:
    + the dziwisz upgrade (PPS upgrade)
    + the vatican upgrade (PPS upgrade)
    + the dinosaur upgrade (PPC upgrade)
    + the papamobile upgrade (PPC upgrade)

+ added a new screen: the statistics screen, accessed under the pope menu, or by the S key

+ reworked the code even more, I'm kinda proud of how it looks but obviously it still could be made better

- unfortunately couldn't get the unit tests to work, I'll have to figure that out later
