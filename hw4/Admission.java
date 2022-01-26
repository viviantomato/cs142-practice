import java.util.*;

public class Admission {
    public static void main (String [] args ) {
        Intro();
        Scanner console = new Scanner(System.in);
        System.out.println("Information for applicant #1:");
        double score1 = getScore(console);
        double GPAscore1 = GPAsystem(console);
        System.out.println();
        System.out.println("Information for applicant #2:");
        double score2 = getScore(console);
        double GPAscore2 = GPAsystem(console);
        System.out.println();
        System.out.print("First applicant overall score = ");
        double finalscore1 = score1 + GPAscore1;
        System.out.println(round1(finalscore1));
        System.out.print("Second applicant overall score = ");
        double finalscore2 = score2 + GPAscore2;
        System.out.println(round1(finalscore2));
        Conclusion(finalscore1, finalscore2);        
    }
    
    //introduce the purpose of the program
    public static void Intro() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant. For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
        System.out.println();
    }
    
    //identify which scoring system to use and calculate, SAT or ACT
    public static double getScore(Scanner console) {
        System.out.print("\t do you have 1) SAT scores or 2) ACT scores? ");
        int system = console.nextInt();
        if (system == 1) {
            double SATscore = SATsystem(console);
            return SATscore;
        } else {
            double ACTscore = ACTsystem(console);
            return ACTscore;
        }
    }
    
    //SAT scoring system calculates SAT score
    public static double SATsystem(Scanner console) {
        System.out.print("\t SAT math? ");
        double SATmath = console.nextDouble();
        System.out.print("\t SAT critical reading? ");
        double SATreading = console.nextDouble();
        System.out.print("\t SAT writing? ");
        double SATwriting = console.nextDouble();
        System.out.print("\t exam score = ");
        double SATscore = SATexam (SATmath, SATreading, SATwriting);
        System.out.println(round1(SATscore));
        return SATscore;        
    }
    
    //formula to calculate SAT score
    public static double SATexam(double SATmath, double SATreading, double SATwriting) {
        return (2 * SATmath + SATreading + SATwriting) / 32;
    }
    
    // ACT scoring system calculates ACT score
    public static double ACTsystem(Scanner console) {
        System.out.print("\t ACT English? ");
        double ACTEng = console.nextDouble();
        System.out.print("\t ACT math? ");
        double ACTmath = console.nextDouble();
        System.out.print("\t ACT reading? ");
        double ACTreading = console.nextDouble();
        System.out.print("\t ACT science? ");
        double ACTscience = console.nextDouble();
        System.out.print("\t exam score =  ");
        double ACTscore = ACTexam (ACTEng, ACTmath, ACTreading, ACTscience);
        System.out.println(round1(ACTscore));
        return ACTscore;
    }
    
    //formula to calculate ACT score
    public static double ACTexam(double ACTEng, double ACTmath, double ACTreading, double ACTscience) {
        return (ACTEng + 2 * ACTmath + ACTreading + ACTscience) / 1.8;
    }
    
    //GPA scoring system calculates GPA score
    public static double GPAsystem(Scanner console) {
        System.out.print("\t overall GPA? ");
        double overallGPA = console.nextDouble();
        System.out.print("\t max GPA? ");
        double maxGPA = console.nextDouble();
        System.out.print("\t Transcript Multiplier? ");
        double Multiplier = console.nextDouble();
        System.out.print("\t GPA score = ");
        double GPAscore = GPAexam(overallGPA, maxGPA, Multiplier);
        System.out.println(round1(GPAscore));
        return GPAscore;
    }
    
    //formula to calculate GPA score
    public static double GPAexam(double overallGPA, double maxGPA, double Multiplier) {
        return overallGPA / maxGPA * 100 * Multiplier;
    }
    
    //conclusion shows comparison of two applicants
    public static void Conclusion(double finalscore1, double finalscore2) {
        if (finalscore1 > finalscore2) {
            System.out.println("The first applicant seems to be better.");
        } else if (finalscore1 < finalscore2) {
            System.out.println("The second applicant seems to be better.");
        } else if (finalscore1 == finalscore2) {
            System.out.println("The two applicants seem to be equal.");
        }
    }
    
    // returns the result of rounding n to 1 digit after the decimal point
    public static double round1(double n) {
        return Math.round(n * 10.0) / 10.0;
    }
}
