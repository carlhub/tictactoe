/*
//Carlos O
//June 2014
//created with Java
//in My Room
//last seen: 6/1/15
*/

/* test for no winners
0 0 0 2 
0 1 1 0 
1 2 1 1 
2 0 2 1 
2 2
*/


/* test for no winners
1 1 1 3 
1 2 2 1 
2 3 2 2 
3 1 3 2 
3 3 
*/

/*Test WINNER!
1 1 1 3 2 2 2 1  3 3  



/*Test WINNER!
0 0 0 2 
1 1 1 0 
2 2

   */
                        

import javax.swing.*;
import java.util.*;
public class TicTacToe
{
	private static Scanner keyboard = new Scanner(System.in);
	private static boolean outcome = false;
	private static boolean FLAG_QUIT = false;
	private static char[][] arrayTable = new char[3][3];
	private static char currentPlayer = 'O';
	private static int count_game_moves = 0;
	private static int userChoice=0;//;
	private final static int FLAG = -999;

	
	public static void displayTable(){
		System.out.println();//spaces
		System.out.println();//spaces
		System.out.println();//spaces
		System.out.println();//spaces
		int count = 0;
		
		int x=0;//row
		int y=0;//columns count
		System.out.println("\tTic Tac Toe Game!\n" +
						   "\tontiveros-carlos\n" +
						   "\t(error checking: Incomplete)");
		System.out.println();//
                System.out.println("\tColumn    Column    Column\n"
                                 + "\t  1         2         3      \n");
                
		for(int j = 0; j<3;j++){//j represents the rows of the Table
			y = 0;//reset y/columns count
						
			//print bar =====
                        System.out.print("\t");//prints initial Tab
			for(count = 0; count < 23; count++){
                            if(count == 0)//initial space
                                    System.out.print(" ");					
                            System.out.print("=");
                            if(count == 22)//last line
                                    System.out.println();
			}
			//Inner box;X's and O's-------------------------|
			for(int i = 1; i <= 9; i++){//for each Row of the Table                                                   
                           
                            if(i==1 || i==7)
                                System.out.print("\t");
                             if(i==4)//prints at the start of each row box
                                System.out.print("Row " + (j+1) + ":  ");//j is defined at top
                             
                            count = 1;//count is "|" for the whole table	
                            if (count ==1)
                                System.out.print("|");

                            while (count <= 7){                               
                                if( (i>=4 && i<=6) && (count == 4) ){//Print values for current						
                                    if(arrayTable[x][y] == 'X'|| arrayTable[x][y] == 'O')//check if value exists				  	
                                        System.out.print(arrayTable[x][y]);//
                                    else
                                        System.out.print(" ");
                                    y++;//increase y/columns!
                                }
                                else{  
                                    System.out.print(" ");//fill with space of '-'/testing
                                }
                                count++;					 					
                            }
                            if(i%3==0)//if (i ==2)			
                                System.out.println("|");			
			}//endfor iiiiii
			
			if(j==2){//display the last bar
                            System.out.print("\t");//prints initial Tab
                            for(count = 0; count < 23; count++){
                                if(count == 0)//initial space
                                    System.out.print(" ");					
                                System.out.print("=");
                                if(count == 22)//last line
                                    System.out.println();
                            }
			}//end if j==2	
		x++; //this will increment row to----OK	
		}//end outer loop J
				
	}
	public static void main(String[] args)
	{
                int x;// 1
                int y;//tracts 1
		displayTable();// display---------------
		System.out.println();
						   
		while(count_game_moves < 9 && !FLAG_QUIT){
			if(currentPlayer == 'X'){
				currentPlayer = 'O';
			}
			else//currentPlayer = 'O'
				currentPlayer = 'X';
                        
			boolean occupied = false;//value in table is empty//Error CHECK!
			do{//while occupied is false
                            System.out.println("\nCurrent player is: " + currentPlayer + "    Make your move. (EXIT: -999)--->");// (row,column):  ");
                            System.out.println();

                            System.out.print("\tRow (choose 1-3)   :  ");//enter row

				/*input*/
                            userChoice = keyboard.nextInt();// - 1;//subtracts 1
				if(userChoice==FLAG)
				{
					FLAG_QUIT=true;
					break;
				}
				else{
					x=userChoice-1;
				}

                            //int x = keyboard.nextInt() - 1;//subtracts 1
							/*make sure input is valid*/
							while(x<0 || x>2){
								System.out.print(" *Re-enter Row:    ");
								x=keyboard.nextInt() - 1;
							}
							
                            System.out.print("\tColumn (choose 1-3):  ");//enter column
				/*input*/
                            userChoice = keyboard.nextInt();// - 1;//subtracts 1
				if(userChoice==FLAG)
				{
					FLAG_QUIT=true;
					break;
				}
				else{
					y=userChoice-1;
				}


                            //y = keyboard.nextInt() - 1;//subtracts 1
							/*make sure input is valid*/
							while(y<0 || y>2){
								System.out.print(" *Re-enter Column:    ");
								y=keyboard.nextInt() - 1;
							}
                            if(arrayTable[x][y] == 'O' || arrayTable[x][y] == 'X')
                                    occupied = true;
                            else
                            {
                                    arrayTable[x][y] = currentPlayer;//set value to equal letter of current player
                                    occupied = false;
                            }
                                    //
			} while(occupied);//error check			
			
			displayTable();//display the table
                        System.out.println();
			
			outcome = check();//if winner then outcome will = positive
			count_game_moves++;//test the count game moves variable
			if (outcome)//if outcome == true
				display_winner_message();//only if outcome is true	
			if(count_game_moves==9)
				play_again();//play another game?
		}//end of while loop
		System.out.println("\nEnd Program.\n");
		//
		
	}
	public static void display_winner_message(){//diplay Winner!
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Player: " + currentPlayer + " is the   Winner!!");
		System.out.println("--------------------------------");
		play_again();//call to play again or not ?
	}
	public static void play_again(){//this method checks if winner or not/
		System.out.println();
		System.out.println();
		
		System.out.print("Would you like to play again? (Y/N):  ");
		String answer = keyboard.next();
		
		if(answer.toUpperCase().charAt(0) == 'Y'){
			count_game_moves = 0;//if Yes, reset game count
			arrayTable = new char[3][3];//create a new empty table!
			//main(args);
			displayTable();
		}
		else{
			count_game_moves = 9;//if no fill up game count
			System.out.print("\n[void play_again()]::Exit Game.  ");
			System.exit(0);//
		}
	}
	public static boolean check(){//char currentPlayer){
		int count = 0;
		//accross check------------------------------------------//
		for(int i = 0; i < 3; i++){//rows
			count = 0;//reset count
			for(int j = 0; j<3; j++){//columns
				if(arrayTable[i][j] == currentPlayer)//conts same letter in row
					count++;
				if(count == 3)
					return true;//returns true
			}
		}
		//check down/columns----------------------------------//
		for(int i = 0; i<3; i++){//columns
			count = 0;
			for(int j = 0; j<3; j++){//rows
				if(arrayTable[j][i] == currentPlayer)//conts same letter in row
					count++;
				if(count == 3)
					return true;//returns true
			}
		}
		//check diagonals----------------------------------------//
		count = 0;//reset the count
		for(int i = 0; i < 3; i++){//diagonal Left to right
			if(arrayTable[i][i] == currentPlayer)//conts same letter in row
					count++;
				if(count == 3)
					return true;//returns true
		}
		count = 0;//reset the count for diagonal 2
		for(int i = 3-1; i >= 0; i--){//diagonal right to left
			if(arrayTable[i][i] == currentPlayer)//conts same letter in row
					count++;
				if(count == 3)
					return true;//returns true
		}
		return false;//no winner was found
	}
}
