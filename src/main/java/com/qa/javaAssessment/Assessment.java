package com.qa.javaAssessment;

import java.util.*;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i < input.length(); i++) {
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
		}
		return word;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"                 
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		input = input.toLowerCase();
		int i;
		String word = "";
		String bert = "bert";
		int startindex = -1;
		int endIndex = 0;
		for (i = 0; i < input.length() - 3; i++) {
			if (input.substring(i, i + bert.length()).equals(bert)) {
				if (startindex == -1) {
					startindex = i + bert.length();
				} else {
					endIndex = i;
					break;
				}
			}
		}
		try {
			word = input.substring(startindex, endIndex);
		} catch (Exception e) {
			return "";
		}
		String reverse = "";
		for (i = word.length() - 1; i >= 0; i--) {
			reverse = reverse + word.charAt(i);
		}
		return reverse;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {

		if (a - b == b - c) {

			return true;
		}

		if (a - c == c - b) {

			return true;
		}

		if (a - b == c - a) {

			return true;
		}

		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.
	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
			
			 String first = input.substring(0, (input.length() - a)/2);
			 
             String second = input.substring((input.length() + a)/2, input.length());
             
             String Endinput = first.concat(second);
            
		 
		return Endinput;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {

		int block;
        int max = 0;
        block = 0;
        String char1;
        if(input.equals("")) {
            return 0;
        }
        char1 = input.substring(0, 1);
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(char1)) {
                block++;
            } else {
                if (max < block) {
                    max = block;
                }
                char1 = input.substring(i, i + 1);
                block = 1;
            }  
        }
		return max;

	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") ==> 1
	// amISearch("I am in Amsterdam am I?") ==> 2
	// amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		     
		       int count=0;
		       arg1 = arg1.toLowerCase();
		       String []word =arg1.split(" ");

		       for(int i=0;i<=word.length-1;i++)
		       {
		          if(word[i].equals("am") )
		           {
		               count++; 
		           }
		       }
		
		return count;

	}

	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) ==> "fizz"
	// fizzBuzz(10) ==> "buzz"
	// fizzBuzz(15) ==> "fizzbuzz"

	public String fizzBuzz(int arg1) {

		if (arg1 % 5 == 0 & arg1 % 3 == 0) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0) {
			return "fizz";
		}

		else if (arg1 % 5 == 0) {
			return "buzz";
		}

		else {
			System.out.println("Are you returning the right thing?");
		}

		return null;
	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") ==> 14
	// largest("15 72 80 164") ==> 11
	// largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		
        String[] stringArray = arg1.split(" ");
        int[] intArray = new int[stringArray.length];
        for ( int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        int sumArray[] = new int[intArray.length];
        for ( int i = 0; i < intArray.length; i++) {
            int input = intArray[i];
            int sum = 0;
             while (input > 0) {
                   int add = input % 10;
                   sum = sum + add;
                   input = input / 10;
             }
            sumArray[i] = sum;
            
            
        }
        Arrays.sort(sumArray);
        return sumArray[sumArray.length - 1];
    }	

}