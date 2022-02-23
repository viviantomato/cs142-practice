import java.util.*;
import java.io.*;
//read name, read original result AB; convert to AB counts two arrays
//convert to percentage of B; map to personality type;
//add intro; swap constant for four;
//check coding style

public class Personality {
    //main method reads from original data, capturing name and line
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner (new File ("personality.txt"));
        while (input.hasNextLine()) {
            String name = input.nextLine();
            String line = input.nextLine();
            System.out.println(name); //output1
            System.out.println(line);
            //int[] countAResults = bPecent(line);
            int[] countBPercent = bPecent(line);
            System.out.println(Arrays.toString(countBPercent));
            //System.out.println(Arrays.toString(countBResults));
        }
    }
    
    //this method reads from line and pinpoint the index of the character to test in four catagories
    public static int[] bPecent(String line) {
        int[] countAResults = new int [4];
        int[] countBResults = new int [4];
        int[] countBPercent = new int [4];
        for (int i = 0; i < 4; i++) {  // loop 0-3 for new array
            for (int j = 0; j < 70 / 7; j++) { // loop 0-9 for index in line
                if (i == 0) {
                    char next = line.charAt(j * 7); // read char from calculated index position
                    test (next, i, countAResults, countBResults); // test char for a, b, - and increase counter
                } else {
                    char next = line.charAt(j * 7 + 2 * i - 1);  //1st
                    test (next, i, countAResults, countBResults);
                    char next2 = line.charAt(j * 7 + 2 * i);  //2nd
                    test (next2, i, countAResults, countBResults);
                }
            }
            countBPercent[i] = (int) Math.round((double) countBResults[i] / (countAResults[i] + countBResults[i]) * 100);
        }
        return countBPercent; // return array of percentage directly
    }
    
    //this method tests the character and calculate three counter accordingly
    public static void test(char next, int i, int[] countAResults, int[] countBResults) {
        if (next == 'a' || next == 'A') {   // ' ' single quote for char
            countAResults[i] ++;
        } else if (next == 'b' || next == 'B') {
            countBResults[i] ++;
        }
    }
    
    
    
    //Print Personality type, as String?
    //     [0] (bPecent > 50%) return I; (bPecent < 50%) return E; else return X;
    //     [1] (bPecent > 50%) return N; (bPecent < 50%) return S; else return X;
    //     [2] (bPecent > 50%) return F; (bPecent < 50%) return T; else return X;
    //     [3] (bPecent > 50%) return P; (bPecent < 50%) return J; else return X;
    //
    
    
}

Fix Indentation
Indent by:  Tabs  Spaces: 
4
65 lines; 33 substantive lines
(ignoring blank/comment lines)
Instructions and Disclaimer:
NOTE: Use this tool at your own risk. We do not guarantee that using this tool will cause you to avoid losing points for indentation on an assignment. We are also not responsible if it messes up your indentation, or even breaks your program. Always back up your code before using this tool, and recompile and re-run your program after using this tool to be certain it still works. The indenter works for most code but is not good at handling nested ifs/loops without curly-braces.