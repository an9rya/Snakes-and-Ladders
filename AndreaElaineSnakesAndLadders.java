/*Name: Andrea Cen and Elaine Liu
Date: November 16 2020
Teacher: Ms. Krasteva
Assignment: ISP - Snakes and Ladders game

Received files help from notes posted by Ms. Krasteva, Ms. Cruceanu and Mr. Guglielmi
Received console class help from http://www.staugustinechs.ca/cadawas/hsa/console.html
*/

// import statements
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import hsa.*;
import javax.imageio.ImageIO;

public class AndreaElaineSnakesAndLadders
{
    Console c;
    String choice;
    int menuChoice; // menu choice as an int
    final String FILE = "highScores.txt"; // file called highScores to store high scores
    boolean won1 = false; // player 1 won
    int wins1 = 0; //the amount of wins for player 1
    int wins2 = 0; //the amount of wins for player 2
    int playerPiece1; // the number of the piece that player one chose
    int playerPiece2; // the number of the piece that player two chose
    int[] [] coor = new int [100] [2];

    // custom colours
    Color piece1 = new Color (163, 0, 0); // colour of piece 1: red
    Color piece2 = new Color (15, 147, 255); // colour of piece 2: blue
    Color piece3 = new Color (20, 160, 15); // colour of piece 3: green
    Color piece4 = new Color (146, 63, 235); // colour of piece 4: purple

    public AndreaElaineSnakesAndLadders ()
    {
	c = new Console ("Snakes and Ladders"); // creates a new console
    }


    public void splashScreen ()
    {
	try
	{
	    BufferedImage splashScreen = ImageIO.read (new File ("splashScreen.png")); // uploads the splash screen
	    c.drawImage (splashScreen, 0, 0, null);
	}
	catch (IOException e)
	{
	}

	c.setColor (Color.BLACK);
	c.setFont (new Font ("Algerian", 0, 50)); // draws title of splash screen
	c.drawString ("SNAKES AND", 300, 100);
	c.drawString ("LADDERS", 325, 175);
	c.setFont (new Font ("Algerian", 0, 30));
	c.drawString ("Christmas", 370, 415);
	c.drawString ("Edition!!!", 370, 445);
	c.setColor (Color.BLACK);

	try
	{
	    Thread.sleep (2000); // times the splash screen
	}
	catch (Exception e)
	{
	}

	//animated snow
	int size = 0; //gets the size of the snowflake
	int moveX = 0; //moves x coordinate
	int moveY = 0; //moves y coordinate

	//falling snow
	//snow fall
	c.setColor (new Color (240, 255, 255)); //sets colour to a very light blue
	for (int y = 0 ; y <= 500 ; y += moveY) //runs a certain amount of times
	{
	    moveY = (int) Math.random () * 50 + 10;

	    for (int x = 640 ; x >= 0 ; x -= moveX) //amount of snowflakes in the row
	    {
		moveX = (int) (Math.random () * 500 - 10); //generates distance between snowflakes
		size = (int) (Math.random () * 16 + 5); //generates snowflake size
		c.fillOval (x, y, size, size);
		try //times animation
		{
		    Thread.sleep (3);
		}
		catch (Exception e)
		{
		}
	    }
	}

	//continuous snowfall
	for (int i = 0 ; i < 40 ; i++) //runs 40 times
	{

	    for (int y = 0 ; y <= 550 ; y += moveY) //runs a certain amount of times
	    {
		c.setColor (new Color (240, 255, 255)); //sets colour to a very light blue
		moveY = (int) Math.random () * 50 + 10;

		for (int x = -50 ; x <= 690 ; x += moveX) //amount of snowflakes in the row
		{
		    moveX = (int) (Math.random () * 500 - 10); //generates distance between snowflakes
		    size = (int) (Math.random () * 21 + 5); //generates snowflake size
		    c.fillOval (x, y, size, size);
		}
	    }
	    try //times animation
	    {
		Thread.sleep (5);
	    }
	    catch (Exception e)
	    {
	    }

	    //clears snow
	    try
	    {
		BufferedImage splashScreen = ImageIO.read (new File ("splashScreen.png")); // uploads the splash screen
		c.drawImage (splashScreen, 0, 0, null);
	    }
	    catch (IOException e)
	    {
	    }

	    c.setColor (Color.BLACK);
	    c.setFont (new Font ("Algerian", 0, 50)); // draws title of splash screen
	    c.drawString ("SNAKES AND", 300, 100);
	    c.drawString ("LADDERS", 325, 175);
	    c.setFont (new Font ("Algerian", 0, 30));
	    c.drawString ("Christmas", 370, 415);
	    c.drawString ("Edition!!!", 370, 445);
	    c.setColor (Color.BLACK);
	}
	// snow buildup
	c.setColor (Color.WHITE); // sets colour to white
	for (int y = 500 ; y >= 0 ; y -= moveY) // runs a certain amount of times
	{
	    moveY = (int) Math.random () * 50 + 10;

	    for (int x = 640 ; x >= 0 ; x -= moveX) // amount of snowflakes in the row
	    {
		moveX = (int) (Math.random () * 71 + 30); // generates distance between snowflakes
		size = (int) (Math.random () * 51 + 5); // generates snowflake size
		c.fillOval (x, y, size, size);
		c.fillRect (0, y + 50, 640, 100);
		try // times animation
		{
		    Thread.sleep (1);
		}
		catch (Exception e)
		{
		}
	    }
	}
    }


    public void mainMenu ()
    {
	c.clear (); // clears previous screen

	while (true) // if it is not valid, continue looping
	{
	    c.setColor (new Color (196, 255, 242)); // sets colour to light blue-green
	    c.setTextBackgroundColor (new Color (196, 255, 242)); // sets text background colour to light blue-green
	    c.fillRect (0, 0, 800, 500); // fills entire screen

	    // drawing the main menu options
	    c.setColor (Color.GREEN);
	    c.fillRoundRect (20, 300, 100, 75, 50, 50);
	    c.fillRoundRect (180, 300, 100, 75, 50, 50);
	    c.fillRoundRect (340, 300, 100, 75, 50, 50);
	    c.fillRoundRect (500, 300, 100, 75, 50, 50);

	    c.setColor (Color.WHITE);
	    c.setFont (new Font ("Arial Rounded MT Bold", 0, 80)); // sets font size to 80
	    c.drawString ("i", 55, 365); // draws the information button

	    // draws the play button
	    int[] xt1 = {200, 200, 240};
	    int[] yt1 = {315, 365, 342};
	    c.fillPolygon (xt1, yt1, 3);
	    int[] xt2 = {225, 225, 265};
	    int[] yt2 = {315, 365, 342};
	    c.fillPolygon (xt2, yt2, 3);

	    // draws the high scores button
	    c.setColor (Color.WHITE);
	    c.fillArc (365, 290, 50, 50, 180, 180);
	    c.fillOval (380, 338, 20, 10);
	    int[] x1 = {390, 385, 395};
	    int[] y1 = {338, 370, 370};
	    c.fillPolygon (x1, y1, 3);
	    c.fillRect (380, 365, 22, 5);

	    c.fillOval (360, 320, 25, 20);
	    c.fillOval (397, 320, 25, 20);

	    c.setColor (Color.GREEN);
	    c.fillArc (365, 325, 15, 10, 90, 200);
	    c.fillArc (402, 325, 15, 10, 270, 160);

	    c.setColor (Color.WHITE);
	    // draws the exit button
	    c.setFont (new Font ("Arial Rounded MT Bold", 0, 90)); // sets font size to 90
	    c.drawString ("x", 527, 362);

	    // draws the options as numbers
	    c.setFont (new Font ("Arial Rounded MT Bold", 0, 70)); // sets font size to 70
	    c.setColor (Color.BLACK);
	    c.drawString ("1", 50, 450);
	    c.drawString ("2", 215, 450);
	    c.drawString ("3", 375, 450);
	    c.drawString ("4", 525, 450);

	    try
	    {
		BufferedImage mainMenu = ImageIO.read (new File ("mainMenu.png")); // uploads the splash screen
		c.drawImage (mainMenu, 0, 0, null);
	    }
	    catch (IOException e)
	    {
	    }
	    c.setFont (new Font ("Calibri", 0, 15)); // sets font size to 70
	    choice = c.readString ();
	    try
	    {
		menuChoice = Integer.parseInt (choice); // menuChoice is the integer value of choice
		if (menuChoice >= 1 && menuChoice <= 4)
		{ // valid input
		    break;
		}
		else
		{
		    new Message ("ERROR: Please enter a valid choice(1 - 4)");
		}
	    }
	    catch (Exception e)
	    {
		new Message ("ERROR: Please enter a valid choice(1 - 4)");
	    }
	}
    }


    public void instructions ()
    {
	c.clear (); // clears previous screen

	c.setColor (new Color (254, 255, 214)); // sets color to pastel yellow
	c.setTextBackgroundColor (new Color (254, 255, 214)); // sets text background colour to pastel yellow
	c.fillRect (0, 0, 800, 500); // fills the entire screen
	c.setColor (new Color (217, 255, 214)); // sets color to pastel green
	c.fillRoundRect (90, 75, 450, 350, 50, 50); // fills the text portion

	try
	{
	    BufferedImage instructions = ImageIO.read (new File ("instructions.png")); // uploads the instructions screen
	    c.drawImage (instructions, 50, 0, null);
	}
	catch (IOException e)
	{
	}

	c.setColor (Color.BLACK); // sets color to black
	c.setFont (new Font ("Calibri", 0, 20)); // sets font to calibri with size 20
	c.drawString ("Roll the dice by pressing 'enter'.", 180, 150); // instructions
	c.drawString ("Reach the end of the board by rolling the dice.", 110, 200);
	c.drawString ("If you roll a 6, you get an extra dice.", 150, 250);

	c.drawString ("Go up at the bottom of a ladder!", 170, 300);
	c.drawString ("Go down at the top of a snake!", 170, 350);

	c.setFont (new Font ("Calibri", 0, 15)); // sets font size to 15
	c.drawString ("Press enter to continue.", 240, 400); // user wants to go back to main menu
	char key = c.readChar ();
    }


    public void drawPiece ()
    {
	int x = 100; // placement variable
	int y = 118; //placement variable
	// game piece 1 -- red
	c.setColor (piece1);
	c.fillOval (50 + x, 49 + y, 50, 50);
	int px1[] = {73 + x, 77 + x, 104 + x, 46 + x};
	int py1[] = {51 + y, 51 + y, 176 + y, 176 + y};
	c.fillPolygon (px1, py1, 4);
	c.fillOval (46 + x, 168 + y, 58, 22);

	c.setFont (new Font ("Calibri", 0, 20));
	c.drawString ("1", 70 + x, 225 + y);

	// game piece 2 -- blue
	c.setColor (piece2);
	c.fillOval (50 + x * 2, 49 + y, 50, 50);
	int px2[] = {73 + x * 2, 77 + x * 2, 104 + x * 2, 46 + x * 2};
	int py2[] = {51 + y, 51 + y, 176 + y, 176 + y};
	c.fillPolygon (px2, py2, 4);
	c.fillOval (46 + x * 2, 168 + y, 58, 22);

	c.drawString ("2", 70 + x * 2, 225 + y);

	// game piece 3 -- green
	c.setColor (piece3);
	c.fillOval (50 + x * 3, 49 + y, 50, 50);
	int px3[] = {73 + x * 3, 77 + x * 3, 104 + x * 3, 46 + x * 3};
	int py3[] = {51 + y, 51 + y, 176 + y, 176 + y};
	c.fillPolygon (px3, py3, 4);
	c.fillOval (46 + x * 3, 168 + y, 58, 22);

	c.drawString ("3", 70 + x * 3, 225 + y);

	// game piece 4 -- purple
	c.setColor (piece4);
	c.fillOval (50 + x * 4, 49 + y, 50, 50);
	int px4[] = {73 + x * 4, 77 + x * 4, 104 + x * 4, 46 + x * 4};
	int py4[] = {51 + y, 51 + y, 176 + y, 176 + y};
	c.fillPolygon (px4, py4, 4);
	c.fillOval (46 + x * 4, 168 + y, 58, 22);

	c.drawString ("4", 70 + x * 4, 225 + y);

	c.setColor (Color.BLACK); // sets colour to black again
    }


    public void gameSelection ()
    {
	String playerPiece1S; // the number of the piece that player one chose
	String playerPiece2S; // the number of the piece that player two chose
	boolean error = false; // tells program if there is an error or not

	c.clear (); // clears previous screen

	c.setColor (new Color (216, 193, 255)); // sets colour to purple
	c.setTextBackgroundColor (new Color (216, 193, 255)); // sets text background colour to purple
	c.fillRect (0, 0, 800, 500); // fills the entire screen
	c.setColor (new Color (255, 192, 203)); // sets colour to light red
	c.fillRoundRect (70, 100, 500, 300, 50, 50); // text box

	do
	{
	    try
	    {
		drawPiece (); // draws game piece
		c.setColor (Color.BLACK);
		c.drawString ("Player 1 please select your game piece: ", 150, 450); // asks player 1 to pick a game piece
		playerPiece1S = c.readLine (); // gets user input
		playerPiece1 = Integer.parseInt (playerPiece1S); // converts user input to int
		if (playerPiece1 < 1 || playerPiece1 > 4) // checks if player piece is within range
		{
		    new Message ("ERROR: Please enter a valid choice(1 - 4)");
		    error = true;
		}
		else
		{
		    error = false; // no more error
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("ERROR: Please enter a valid choice(1 - 4)");
		error = true;
	    }
	}
	while (error == true);

	c.setColor (new Color (216, 193, 255)); // sets colour to purple
	c.fillRect (150, 430, 68, 25); // clears the first prompt

	// eliminates player 1's piece choice
	c.setXORMode (Color.lightGray); // sets mode to XOR (transparent)
	if (playerPiece1 == 1)
	{
	    c.fillRect (141, 155, 68, 200);
	}
	else if (playerPiece1 == 2)
	{
	    c.fillRect (241, 155, 68, 200);
	}
	else if (playerPiece1 == 3)
	{
	    c.fillRect (341, 155, 68, 200);
	}
	else if (playerPiece1 == 4)
	{
	    c.fillRect (441, 155, 68, 200);
	}

	c.setPaintMode (); // sets mode back to paint (solid)
	c.setColor (Color.BLACK); // sets colour back to black

	do
	{
	    try
	    {
		drawPiece (); // draws game piece

		c.drawString ("Player 2 please select your game piece: ", 150, 450); // asks player 2 to pick a game piece
		playerPiece2S = c.readLine (); // gets user input
		playerPiece2 = Integer.parseInt (playerPiece2S); // converts user input to int
		if (playerPiece2 < 1 || playerPiece2 > 4) // checks if player piece is in range
		{
		    new Message ("ERROR: Please enter a valid choice (1 - 4)");
		    error = true;
		}
		else if (playerPiece2 == playerPiece1)  // checks if the piece is the same as player piece 1
		{
		    new Message ("ERROR: Please enter a different choice than Player 1.");
		    error = true;
		}
		else
		{
		    error = false; // no more error
		}
	    }
	    catch (NumberFormatException e)
	    {
		new Message ("ERROR: Please enter a valid choice(1 - 4)");
		error = true;
	    }
	}
	while (error == true);
    }


    public void getCoor ()
    { // gets the coordinate of each number on the board
	for (int i = 0 ; i < 10 ; i += 2)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		coor [i * 10 + j] [0] = 85 + 37 * j; // x value of number
		coor [i * 10 + j] [1] = 420 - 37 * i; // y value of number
	    }
	}

	for (int i = 1 ; i < 10 ; i += 2)
	{
	    for (int j = 0 ; j < 10 ; j++)
	    {
		coor [i * 10 + j] [0] = 85 + 37 * (9 - j); // x value of number
		coor [i * 10 + j] [1] = 420 - 37 * i; // y value of number
	    }
	}
    }


    public void game ()
    {
	c.clear ();

	c.setColor (new Color (193, 248, 255)); // sets colour to light blue
	c.setTextBackgroundColor (new Color (193, 248, 255)); // sets text background colour to light blue
	c.fillRect (0, 0, 800, 500);
	drawBoard ();

	int x = 50;

	// game piece 1
	if (playerPiece1 == 1) // player chose red
	{
	    c.setColor (piece1);
	}
	else if (playerPiece1 == 2) // player chose blue
	{
	    c.setColor (piece2);
	}
	else if (playerPiece1 == 3) // player chose green
	{
	    c.setColor (piece3);
	}
	else if (playerPiece1 == 4) // player chose purple
	{
	    c.setColor (piece4);
	}

	c.fillOval (1 + x, 0 + x * 9, 14, 14); // draws top of piece
	int[] px1 = {7 + x, 9 + x, 16 + x, 0 + x}; // x values
	int[] py1 = {2 + x * 9, 2 + x * 9, 37 + x * 9, 37 + x * 9}; // y values
	c.fillPolygon (px1, py1, 4); // draws the polygon
	c.fillOval (0 + x, 34 + x * 9, 16, 6); // draws bottom of piece

	// game piece 2
	if (playerPiece2 == 1) // player chose red
	{
	    c.setColor (piece1);
	}
	else if (playerPiece2 == 2) // player chose blue
	{
	    c.setColor (piece2);
	}
	else if (playerPiece2 == 3) // player chose green
	{
	    c.setColor (piece3);
	}
	else if (playerPiece2 == 4) // player chose purple
	{
	    c.setColor (piece4);
	}

	c.fillOval (1 + x * 2, 0 + x * 9, 14, 14); // draws top of piece
	int px2[] = {7 + x * 2, 9 + x * 2, 16 + x * 2, 0 + x * 2}; // x values
	int py2[] = {2 + x * 9, 2 + x * 9, 37 + x * 9, 37 + x * 9}; // y values
	c.fillPolygon (px2, py2, 4); // draws the polygon
	c.fillOval (0 + x * 2, 34 + x * 9, 16, 6); // draws bottom of piece

	int roll;
	int currBlock1 = 1; // block that player 1 is currently at
	int currBlock2 = 1; // block that player 2 is currently at
	char key; // used when player rolls dice

	getCoor (); // gets coordinates of all the blocks

	while (currBlock1 != 100 && currBlock2 != 100)
	{ // piece not at 100

	    key = c.readChar (); // player 1 wants to roll dice

	    c.clear ();
	    c.setColor (new Color (193, 248, 255)); // sets colour to light blue
	    c.fillRect (0, 0, 800, 500);
	    drawBoard ();

	    // player 1 roll
	    roll = (int) (Math.random () * 6 + 1); // dice number
	    drawDice (roll);
	    currBlock1 += roll;
	    if (currBlock1 > 100)
	    { // near the end of the board (over 100)
		currBlock1 = 200 - currBlock1; // moves backwards
	    }
	    currBlock1 = jumpTo (currBlock1); // calls the jumpTo method

	    // draws piece 1 at current block
	    int cx1 = coor [currBlock1 - 1] [0]; // current x coordinate of player 1
	    int cy1 = coor [currBlock1 - 1] [1] - 20; // current y coordinate of player 1

	    int cx2 = coor [currBlock2 - 1] [0]; // current x coordinate of player 2
	    int cy2 = coor [currBlock2 - 1] [1] - 20; // current y coordinate of player 2

	    c.setColor (Color.WHITE); // draws outline of piece
	    c.fillOval (cx1 - 2, cy1 - 3, 20, 20); // draws top of piece
	    int px01[] = {5 + cx1, 11 + cx1, 21 + cx1, cx1 - 4}; // x coordinates of body
	    int py01[] = {cy1, cy1, 39 + cy1, 39 + cy1}; // y coordinates of body
	    c.fillPolygon (px01, py01, 4); // draws body part
	    c.fillOval (cx1 - 2, cy1 + 34, 21, 10); // draws bottom of piece

	    // draws piece at current block
	    if (playerPiece1 == 1) // player chose red
	    {
		c.setColor (piece1);
	    }
	    else if (playerPiece1 == 2) // player chose blue
	    {
		c.setColor (piece2);
	    }
	    else if (playerPiece1 == 3) // player chose green
	    {
		c.setColor (piece3);
	    }
	    else if (playerPiece1 == 4) // player chose purple
	    {
		c.setColor (piece4);
	    }

	    c.fillOval (cx1 + 1, cy1, 14, 14); // draws top of piece
	    int x1[] = {7 + cx1, 9 + cx1, 16 + cx1, cx1}; // x coordinates of body
	    int y1[] = {2 + cy1, 2 + cy1, 37 + cy1, 37 + cy1}; // y coordinates of body
	    c.fillPolygon (x1, y1, 4); // draws body part
	    c.fillOval (cx1 - 1, cy1 + 35, 19, 6); // draws bottom of piece

	    c.setColor (Color.WHITE); // draws outline of piece
	    c.fillOval (cx2 - 2, cy2 - 3, 20, 20); // draws top of piece
	    int px02[] = {5 + cx2, 11 + cx2, 21 + cx2, cx2 - 4}; // x coordinates of body
	    int py02[] = {cy2, cy2, 39 + cy2, 39 + cy2};     // y coordinates of body
	    c.fillPolygon (px02, py02, 4); // draws body part
	    c.fillOval (cx2 - 2, cy2 + 34, 21, 10); // draws bottom of piece

	    if (playerPiece2 == 1) // player chose red
	    {
		c.setColor (piece1);
	    }
	    else if (playerPiece2 == 2) // player chose blue
	    {
		c.setColor (piece2);
	    }
	    else if (playerPiece2 == 3) // player chose green
	    {
		c.setColor (piece3);
	    }
	    else if (playerPiece2 == 4) // player chose purple
	    {
		c.setColor (piece4);
	    }

	    c.fillOval (cx2 + 1, cy2, 14, 14); // draws top of piece
	    int x2[] = {7 + cx2, 9 + cx2, 16 + cx2, cx2}; // x coordinates of body
	    int y2[] = {2 + cy2, 2 + cy2, 37 + cy2, 37 + cy2}; // y coordinates of body
	    c.fillPolygon (x2, y2, 4); // draws body part
	    c.fillOval (cx2 - 1, cy2 + 35, 19, 6); // draws bottom of piece

	    key = c.readChar (); // player 2 wants to roll dice

	    c.clear ();
	    c.setColor (new Color (193, 248, 255)); // sets colour to light blue
	    c.fillRect (0, 0, 800, 500);
	    drawBoard ();

	    // player 2 roll
	    roll = (int) (Math.random () * 6 + 1); // dice number
	    drawDice (roll);
	    currBlock2 += roll;
	    if (currBlock2 > 100)
	    { // near the end of the board (over 100)
		currBlock2 = 200 - currBlock2; // moves backwards
	    }
	    currBlock2 = jumpTo (currBlock2); // calls the currBlock method

	    // draws piece 1 and 2 at current block

	    c.setColor (Color.WHITE); // draws outline of piece
	    c.fillOval (cx1 - 2, cy1 - 3, 20, 20); // draws top of piece
	    c.fillPolygon (px01, py01, 4); // draws body part
	    c.fillOval (cx1 - 2, cy1 + 34, 21, 10); // draws bottom of piece

	    // draws piece at current block
	    if (playerPiece1 == 1) // player chose red
	    {
		c.setColor (piece1);
	    }
	    else if (playerPiece1 == 2) // player chose blue
	    {
		c.setColor (piece2);
	    }
	    else if (playerPiece1 == 3) // player chose green
	    {
		c.setColor (piece3);
	    }
	    else if (playerPiece1 == 4) // player chose purple
	    {
		c.setColor (piece4);
	    }

	    c.fillOval (cx1 + 1, cy1, 14, 14); // draws top of piece
	    c.fillPolygon (x1, y1, 4); // draws body part
	    c.fillOval (cx1 - 1, cy1 + 35, 19, 6); // draws bottom of piece

	    cx2 = coor [currBlock2 - 1] [0]; // player 2 x coordinate at current block
	    cy2 = coor [currBlock2 - 1] [1] - 20; // player 2 y coordinate at current block

	    c.setColor (Color.WHITE); // draws outline of piece
	    c.fillOval (cx2 - 2, cy2 - 3, 20, 20); // draws top of piece
	    int px12[] = {5 + cx2, 11 + cx2, 21 + cx2, cx2 - 4}; // x coordinates of body
	    int py12[] = {cy2, cy2, 39 + cy2, 39 + cy2};     // y coordinates of body
	    c.fillPolygon (px12, py12, 4); // draws body part
	    c.fillOval (cx2 - 2, cy2 + 34, 21, 10); // draws bottom of piece

	    if (playerPiece2 == 1) // player chose red
	    {
		c.setColor (piece1);
	    }
	    else if (playerPiece2 == 2) // player chose blue
	    {
		c.setColor (piece2);
	    }
	    else if (playerPiece2 == 3) // player chose green
	    {
		c.setColor (piece3);
	    }
	    else if (playerPiece2 == 4) // player chose purple
	    {
		c.setColor (piece4);
	    }
	    int[] x21 = {7 + cx2, 9 + cx2, 16 + cx2, cx2}; // x coordinates of body in array
	    int[] y21 = {2 + cy2, 2 + cy2, 37 + cy2, 37 + cy2}; // y coordinates of body in array

	    c.fillOval (cx2 + 1, cy2, 14, 14); // draws top of piece
	    c.fillPolygon (x21, y21, 4); // draws body part
	    c.fillOval (cx2 - 1, cy2 + 35, 19, 6); // draws bottom of piece
	}
	if (currBlock1 == 100)
	{
	    won1 = true; // player 1 won
	}
	else
	{
	    won1 = false; //player 1 lost
	}

    }


    public void drawBoard ()
    {
	try
	{
	    BufferedImage board = ImageIO.read (new File ("board.png")); // uploads the board
	    c.drawImage (board, 70, 70, null);
	}
	catch (IOException e)
	{
	}
    }


    public void drawDice (int roll)
    {
	c.setColor (Color.WHITE);
	c.fillRoundRect (500, 100, 95, 95, 50, 50); // fills dice colour
	c.setColor (Color.BLACK);
	c.drawRoundRect (500, 100, 95, 95, 50, 50); // draws dice

	if (roll == 1)
	{
	    c.fillOval (540, 140, 15, 15); // draws 1 dot
	}
	else if (roll == 2)
	{
	    c.fillOval (520, 120, 15, 15); // draws 2 dots
	    c.fillOval (560, 160, 15, 15);
	}
	else if (roll == 3)
	{
	    c.fillOval (520, 120, 15, 15); // draws 3 dots
	    c.fillOval (540, 140, 15, 15);
	    c.fillOval (560, 160, 15, 15);
	}
	else if (roll == 4)
	{
	    c.fillOval (520, 120, 15, 15); // draws 4 dots
	    c.fillOval (560, 120, 15, 15);
	    c.fillOval (520, 160, 15, 15);
	    c.fillOval (560, 160, 15, 15);
	}
	else if (roll == 5)
	{
	    c.fillOval (520, 120, 15, 15); // draws 5 dots
	    c.fillOval (560, 120, 15, 15);
	    c.fillOval (520, 160, 15, 15);
	    c.fillOval (560, 160, 15, 15);
	    c.fillOval (540, 140, 15, 15);
	}
	else
	{
	    c.fillOval (520, 120, 15, 15); // draws 6 dots
	    c.fillOval (560, 120, 15, 15);
	    c.fillOval (520, 160, 15, 15);
	    c.fillOval (560, 160, 15, 15);
	    c.fillOval (520, 140, 15, 15);
	    c.fillOval (560, 140, 15, 15);
	}
    }


    public int jumpTo (int block)
    { // jump from which block to which block
	// ladders
	if (block == 1)
	{
	    return 38;
	}


	else if (block == 4)
	{
	    return 14;

	}


	else if (block == 9)
	{
	    return 31;
	}


	else if (block == 21)
	{
	    return 42;
	}


	else if (block == 28)
	{
	    return 84;
	}


	else if (block == 36)
	{
	    return 44;
	}


	else if (block == 51)
	{
	    return 67;
	}


	else if (block == 71)
	{
	    return 91;
	}


	else if (block == 80)
	{
	    return 100;
	}


	// snakes
	if (block == 16)
	{
	    return 6;
	}


	else if (block == 47)
	{
	    return 26;
	}


	else if (block == 49)
	{
	    return 11;
	}


	else if (block == 56)
	{
	    return 53;
	}


	else if (block == 62)
	{
	    return 19;
	}


	else if (block == 64)
	{
	    return 60;
	}


	else if (block == 87)
	{
	    return 24;
	}


	else if (block == 93)
	{
	    return 73;
	}


	else if (block == 95)
	{
	    return 75;
	}


	else if (block == 98)
	{
	    return 78;
	}

	return block; // did not go on a snake or ladder
    }


    public void gameOver ()
    {
	BufferedReader br;
	PrintWriter pw;
	PrintWriter pw2;
	String wins = "0"; // wins in String
	String line = ""; // what is on the line
	String[] data = new String [7];

	c.clear (); // clears screen

	try
	{
	    pw = new PrintWriter (new FileWriter (FILE)); // writes to file
	    br = new BufferedReader (new FileReader (FILE)); // reading a file

	    // writes file if file is not already made
	    line = br.readLine ();
	    if (line == null)
	    {
		pw2 = new PrintWriter (new FileWriter (FILE)); // creates a file called highScores.txt
		pw2.println ("Snakes and Ladders Wins");
		pw2.println ();
		pw2.println ("Player One Wins: 0");
		pw2.println ("Player Two Wins: 0");
		pw2.println ();
		pw2.println ("Created by Andrea Cen and Elaine Liu.");
		pw2.close ();
	    }

	    // finds amount of wins
	    int count = 0;
	    line = br.readLine (); // read the first line of data
	    data [count] = line; // save the data into an array
	    line = br.readLine (); // read the next line

	    try
	    {
		if (line.charAt (7) == ('O')) // finds player 1 score
		{
		    wins = line.substring (17);
		    c.println (line);
		    c.println (wins);
		    wins1 = Integer.parseInt (wins); // turns wins into an integer
		}
		else if (line.charAt (7) == ('T'))  // finds player 2 score
		{
		    wins = line.substring (17);
		    c.println (line);
		    c.println (wins);
		    wins2 = Integer.parseInt (wins); // turns wins into an integer
		}
	    }
	    catch (Exception e)
	    {
	    }

	    count++; // go to the next position in the array

	    // adds winner into file
	    if (won1 == true) //if player one won the game
	    {
		wins1++;
	    }
	    else // if player 2 won the game
	    {
		wins2++;
	    }
	    pw.println ("Snakes and Ladders Wins");
	    pw.println ();
	    pw.println ("Player One Wins:" + wins1);
	    pw.println ("Player Two Wins:" + wins2);

	    pw.close (); // this line will close and save the information in the file
	}
	catch (IOException e)
	{
	}

	c.setColor (new Color (255, 219, 250)); // sets colour to light pink
	c.setTextBackgroundColor (new Color (255, 219, 250)); // sets text background colour to light pink
	c.fillRect (0, 0, 800, 500); // fills entire screen
	c.setColor (new Color (255, 235, 219)); // sets color to light orange
	c.fillRoundRect (100, 100, 450, 250, 50, 50);

	try
	{
	    BufferedImage winners = ImageIO.read (new File ("winners.png")); // uploads the winners screen
	    c.drawImage (winners, 0, 0, null);
	}
	catch (IOException e)
	{
	}

	c.setFont (new Font ("Calibri", 0, 30)); // sets font to calibri with size 30
	c.setColor (Color.BLACK); // sets color to black
	// player 1 won
	if (won1)
	{
	    c.drawString ("Player 1 Won!", 220, 200);
	}

	else // player 2 won
	{
	    c.drawString ("Player 2 Won!", 240, 200);
	}
	c.setFont (new Font ("Calibri", 0, 20)); // sets font size to 20
	c.drawString ("Press enter to continue.", 225, 300);
	char key = c.readChar ();
    }


    public void highScores ()
    {
	c.clear ();

	c.setColor (new Color (216, 193, 255)); // sets colour to purple
	c.setTextBackgroundColor (new Color (216, 193, 255)); // sets text background colour to purple
	c.fillRect (0, 0, 800, 500); // fills the entire screen
	c.setColor (new Color (255, 130, 132)); // sets colour to light red
	c.fillRoundRect (70, 100, 500, 300, 50, 50); // text box

	try
	{
	    BufferedImage winners = ImageIO.read (new File ("winners.png")); // uploads the winners screen
	    c.drawImage (winners, 0, 0, null);
	}
	catch (IOException e)
	{
	}

	c.setColor (Color.BLACK);
	c.setFont (new Font ("Calibri", 0, 20)); // sets font to calibri with size 20
	BufferedReader br;
	String line = "";
	String[] data = new String [20]; // array called data with a large size (will not index out of bounds)
	try
	{
	    br = new BufferedReader (new FileReader (FILE)); // reading a file
	    line = br.readLine (); // reads the line
	    int count = 0; // array index currently at 0
	    while (line != null)
	    {
		data [count] = line; // adds the line into the array
		line = br.readLine (); // reads the line again
		count++; // adds the index by 1 each time
	    }

	    c.drawString ("WINNERS", 280, 150);
	    for (int i = 1 ; i <= count ; i++)
	    {
		c.drawString (data [i - 1], 170, 200 + i * 20); // draws each line onto the screen
	    }
	    c.drawString ("Press enter to continue: ", 230, 375);
	}
	catch (IOException e)
	{
	} // catches exceptions
	char key = c.readChar ();
    }


    public void goodbye ()
    {
	c.clear (); // clears the previous screen
	c.setColor (new Color (201, 205, 255)); // sets color to light blue
	c.fillRect (0, 0, 800, 500); // fills the entire screen
	c.setColor (new Color (153, 248, 255)); // sets color to cyan
	c.fillRoundRect (33, 125, 575, 250, 50, 50);
	try
	{
	    BufferedImage goodbye = ImageIO.read (new File ("goodbyeScreen.png")); // uploads the goodbye screen
	    c.drawImage (goodbye, 0, 0, null);
	}
	catch (IOException e)
	{
	}
	c.setColor (Color.BLACK);
	c.setFont (new Font ("Calibri", 0, 30)); // sets font to calibri size 50
	c.drawString ("Thank you for playing Snakes and Ladders: ", 50, 150); // goodbye message
	c.drawString ("Christmas Edition!", 200, 200);
	c.setFont (new Font ("Calibri", 0, 20)); // sets font to calibri size 20
	c.drawString ("Created by: Andrea Cen and Elaine Liu", 150, 490);

	try
	{
	    Thread.sleep (4000); // times the goodbye screen
	    c.close (); //closes console
	}
	catch (Exception e)
	{
	}

    }


    public static void main (String[] args)
    {
	AndreaElaineSnakesAndLadders sl = new AndreaElaineSnakesAndLadders ();
	// method initialization
	sl.splashScreen (); //displays spash screen
	// runs until exit choice is inputted
	while (sl.menuChoice != 4)
	{
	    sl.mainMenu (); // goes to main menu
	    if (sl.menuChoice == 1)
	    { // user wants to read instructions
		sl.instructions ();
	    }
	    else if (sl.menuChoice == 2)
	    { // user wants to play game
		sl.gameSelection (); // selecting game piece
		sl.game (); // goes to game
		sl.gameOver (); // game over
	    }
	    else if (sl.menuChoice == 3)
	    { // user wants to go to high scores
		sl.highScores (); // goes to high scores
	    }
	}
	sl.goodbye (); // goes to goodbye method
    }
}
