//Author: Tyler Stratton
//The purpose of this program is to allow a user to manipulate a certain string in various ways, such as testing if it a palidrome, and removing, counting, and searching for characters.
package StringManipulation;

import java.util.Scanner;
public class StringManipulation {
    
    public static boolean isPalin(String str){
        if(str.length() >= 1){ //stopping state
            if (str.charAt(0) == str.charAt(str.length()-1))
                return isPalin(str.substring(1, str.length()-1)); //take each end off of string
            else
                return false; //No reason to waste time recursing if we fail
        }
        return true; //base case -- we can return true if we get to the end of the string
    }
    
    public static int countChars(String str, char c){
        if (str.length() > 0){ //stopping state -- end when string is empty
            if (str.charAt(0) == c)
                return 1 + countChars(str.substring(1, str.length()), c);
            else
                return countChars(str.substring(1, str.length()), c);
        }else
            return 0; //base case
    }
    
    public static String removeChars(String str, char c){
        if (str.length() > 0){ //stopping state
            if (str.charAt(0) == c) //if we find c
                return removeChars(str.substring(1, str.length()), c); //don't add it to the result string
            else //if we don't find c
                return str.charAt(0) + removeChars(str.substring(1, str.length()), c); //we need to add the character back to the result string
        }else
            return ""; //base case, return null string
    }
    
    public static String findChars(String str, char c){ //Will return a string containing each location of c in the string
        if (str.length() > 0){ //stopping state
            if (str.charAt(str.length()-1) == c)
                return findChars(str.substring(0, str.length()-1), c) + " " + str.length()+47; //Use ASCII code to add each number into the string
            else //didn't find c
                return findChars(str.substring(0, str.length()-1), c); //continue recursing from right to left
        }else
            return "";
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int choice;
        
        do{
            System.out.println("Main menu");
            System.out.println("1. Determine whether a string is a palindrome");
            System.out.println("2. Count all occurrences of a specified character in a string");
            System.out.println("3. Remove all occurrences of a specified character in a string");
            System.out.println("4. Find all occurrences of a specified character in a string");
            System.out.println("5. Exit");
            System.out.print("Please make a selection: ");
            choice = in.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Please enter the string: ");
                    String str = in.nextLine();
                    System.out.println(isPalin(str));
                    break;
                case 2:
                    System.out.print("Please enter the string: ");
                    str = in.nextLine();
                    System.out.print("Please enter the character: ");
                    char c = in.next().charAt(0);
                    System.out.println(countChars(str, c));
                    break;
                case 3:
                    System.out.print("Please enter the string: ");
                    str = in.nextLine();
                    System.out.print("Please enter the character: ");
                    c = in.next().charAt(0);
                    System.out.println(removeChars(str, c));
                    break;
                case 4:
                    System.out.print("Please enter the string: ");
                    str = in.nextLine();
                    System.out.print("Please enter the character: ");
                    c = in.next().charAt(0);
                    System.out.println(findChars(str, c));
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("You have entered an invalid value. Please try again.");
            }
        }while(choice != 5);
        
    }
}
