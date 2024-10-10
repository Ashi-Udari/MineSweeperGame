MINESWEEP GAME README

Overview
The Minesweeper game is a console-based implementation of the classic game where players uncover squares on a grid while avoiding mines. The objective is to reveal all non-mine squares without triggering a mine. This implementation demonstrates principles of clean code, object-oriented programming, and the use of Test-Driven Development (TDD) methodologies.

Requirements
- Java 17 or later
- Maven (for building the project)

Design and Assumptions

Game Structure:

* The game is played on a square grid where users can specify the size of the grid and the number of mines.
* The grid is represented by a 2D array where mines are randomly placed, and adjacent mine counts are calculated.
* The user interacts with the game via a command line interface.

Game Logic:

* Users input their choices to reveal squares. If a mine is revealed, the game ends immediately.
* Revealed squares show the number of adjacent mines. If a square has no adjacent mines, adjacent squares are automatically revealed.
* The game ends when all non-mine squares are revealed.


Assumptions:

* The maximum number of mines is limited to 35% of the total grid squares to ensure playability.
* Input validation is in place to handle invalid selections.
* Installation Requirements
* Environment
* Operating System: Windows, Linux, or macOS
* Java Version: Java 17 or later
* Build Tool: Apache Maven (optional, for dependency management)

Project Structure:

Java Source Code Structure: (src/main/java)

src
└── main
    └── java
        └── org
            └── minesweeper
                ├── config
                │   ├── GameConfig.java
                │   ├── GameInitializer.java
                │   └── LanguageManager.java
                ├── controller
                │   └── MineSweeperGame.java
                ├── core
                │   ├── Cell.java
                │   └── Grid.java
                ├── exception
                │   ├── InvalidCellSelectionException.java
                │   ├── InvalidGridSizeException.java
                │   ├── InvalidInputException.java
                │   ├── InvalidLanguageException.java
                │   └── InvalidMineCountException.java
                ├── gamelogic
                │   ├── CellRevealer.java
                │   ├── MinePlacer.java
                │   └── WinChecker.java
                ├── ui
                │   ├── GridView.java
                │   └── InputParser.java
                ├── util
                │   └── GameValidation.java
                └── Main.java


Test Structure (src/test/java)

src
└── test
    └── java
        └── com
            └── minesweeper
                ├── config
                │   ├── GameConfigTest.java
                │   └── LanguageManagerTest.java
                ├── controller
                │   └── MineSweeperGameTest.java
                ├── core
                │   ├── CellTest.java
                │   └── GridTest.java
                ├── gamelogic
                │   ├── CellRevealerTest.java
                │   ├── MinePlacerTest.java
                │   └── WinCheckerTest.java
                ├── ui
                │   ├── GridViewTest.java
                │   └── InputParserTest.java
                └── util
                    └── GameValidationTest.java


Installation Steps

Java Installation Instructions for macOS and Windows

Installing Java on Windows

1. Using Chocolatey (recommended):
   If you have [Chocolatey](https://chocolatey.org/install) installed, you can install Java by running the following command in an elevated PowerShell (run as administrator):

   choco install openjdk17
  

2. Manual Installation:
   - Go to the [Oracle JDK Downloads page](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Download the installer for Windows.
   - Follow the installation steps in the installer.

3. Set JAVA_HOME Environment Variable:
   - After installation, set up the `JAVA_HOME` environment variable.
   
   - Right-click on `This PC` -> `Properties` -> `Advanced system settings` -> `Environment Variables`.
   
   - Under **System Variables**, click **New** and add:
     - Variable name: `JAVA_HOME`
     - Variable value: `C:\Program Files\OpenJDK\jdk-17` (or the installation path you selected).

   - Then, add `%JAVA_HOME%\bin` to the **Path** variable:
     - In **System Variables**, find **Path**, click **Edit**, and add a new entry for `%JAVA_HOME%\bin`.



Installing Java on macOS

1. Using Homebrew (recommended):
   If you have [Homebrew](https://brew.sh/) installed, you can install Java with the following command:

   brew install openjdk@17

2. Manual Installation:
   - Download the JDK for macOS from the [Oracle JDK Downloads page](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Open the downloaded `.dmg` file and follow the installation instructions.
   - The installer automatically sets up the necessary paths.

3. Set JAVA_HOME:
   - After installation, run the following command in your terminal to add the `JAVA_HOME` path permanently

 sudo nano /etc/profile
     

 Add the following line at the end of the file:

   export JAVA_HOME=$(/usr/libexec/java_home)
    
   Save the file by pressing `CTRL + O` and then `CTRL + X` to exit.

4. Verify Installation:
   After installation on either platform, run the following command in your terminal or command prompt to verify that Java is installed correctly:

   java -version
  
 This should display the installed version of Java (e.g., `openjdk version "17.0.0"`).

By adding these platform-specific installation instructions, your README will be more helpful for users on both macOS and Windows.
Clone the repository or download the ZIP file containing the source code.

git clone https://github.com/Ashi-Udari/MineSweeperGame.git

Navigate to the Project Directory:

cd minesweeper

Build the Project (optional, if using Maven):

If using Maven, you can compile the project using the following command:

mvn clean install

Compile the Project

To compile the project, use the following Maven command:  

mvn clean compile

Package the Project

To create a JAR file :   mvn package

After running this command, you will find the JAR file in the `target` directory.

Running the Application

On Windows Compile the Java Code:

If not using Maven, compile the Java files manually using Command Prompt:
cd src
javac *.java -d ../out

Run the Application:

Change to the output directory and run the main class:

cd ..\out
java Minesweeper

On Linux/macOS Compile the Java Code:

If not using Maven, compile the Java files manually:

cd src
javac *.java -d ../out

Run the Application:

Change to the output directory and run the main class:

cd ../out
java Minesweeper

Testing

Unit tests are included in the src/test directory. To run the tests:

If using Maven
mvn test

Logging

The application uses loggers to track events and errors. You can find logs under the *logs* directory in the project

Gameplay Instructions

Starting the Game:

Upon running the application, you will see a welcome message.
You will be prompted to enter the size of the grid. For example, entering 4 will create a 4x4 grid.
Next, enter the number of mines you want to place on the grid. Note that the maximum number of mines is 35% of the total squares. For a 4x4 grid (16 squares), the maximum number of mines is 5 (0.35 * 16 = 5.6, rounded down).
Understanding the Grid:

After entering the grid size and the number of mines, the initial game grid will be displayed. The grid will look like this, with _ representing hidden squares:

  1    2   3    4
  
A _ _ _ _

B _ _ _ _

C _ _ _ _

D _ _ _ _

Making a Move:

You will be prompted to select a square to reveal. Input your choice using the format <Letter><Number>, for example, A1, B3, or D4.
Valid Selections:
Ensure that your selection is within the grid boundaries. For a 4x4 grid, valid inputs are from A1 to D4.
Revealing Squares:

If the square you reveal contains a mine (M), the game will end immediately, and you will see a message indicating that you have detonated a mine:

Oh no, you detonated a mine! Game over.
If the square is safe, the game will reveal the number of adjacent mines. For example, if you uncover a square that has 0 adjacent mines, it means none of the neighboring squares contain a mine.

Automatic Uncovering:

If you uncover a square with 0 adjacent mines, the game will automatically reveal all adjacent squares until it reaches squares with adjacent mines.
Game Progression:

After each move, the updated grid will be displayed. For example:

     1    2    3    4
  
A   2   _   2     0

B   3  _   2   0

C    _   2   1   0
 
D   1  1  0  0

Continue making selections until you either uncover all non-mine squares or hit a mine.
Winning the Game:

You will win the game when all non-mine squares are uncovered. Upon winning, you will see a congratulatory message:

Congratulations, you have won the game!

If you lose by uncovering a mine, you can restart the game by pressing ‘y’ key when prompted.

Tips for Success
* Pay attention to the numbers revealed; they indicate how many mines are in adjacent squares.
* Use logic to deduce where the mines might be located based on the numbers revealed.
* Take your time to think through your selections; making hasty decisions can lead to detonating a mine.


