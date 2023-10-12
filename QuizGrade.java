import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class QuizGrade extends GradeCalc {
    //Setting up variables, arrayLists, and Scanner for collecting quiz grades
    //region
    boolean mainLoop = true;
    private ArrayList<Integer> quizzes = new ArrayList<Integer>();
    private Scanner input = new Scanner(System.in);
    private int prelim,finalGrade = 0, sum = 0;
    private static int totalScore;
    //endregion


    public int QuizGrade() {

        while(mainLoop) {
            System.out.println("\nOn a scale from 0 - 100,");
            //Gather prelim score from user input
            System.out.println("Enter a grade for prelim: ");
            try {
            prelim = input.nextInt();
            if (prelim>= 0 && prelim <= 100) {
                break;
            } else {
                System.out.println("Please enter a valid number between 0 - 100!");
            }
            input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Please a valid number between 0 - 100.");
                input.nextLine();
            }
        }


        //Gather finals score details from user input
        //region
        while(mainLoop) {
            System.out.println("Enter a grade for the final: ");
            try {
                finalGrade = input.nextInt();
                if (finalGrade >= 0 && finalGrade <= 100) {
                    break;
                } else {
                    System.out.println("Please enter a valid number between 0 - 100!");
                }
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Please a valid number between 0 - 100.");
                input.nextLine();
            }
        }
        //endregion

        //Gather all scores for the quizzes from user input
        //region
            for (int i = 0; i < 6; i++) {
                mainLoop = true;
                while(mainLoop) {
                    System.out.println("Enter a grade for quiz #" + (i + 1) + ": ");
                    try {
                        quizzes.add(input.nextInt());
                        if (quizzes.get(i) >= 0 && quizzes.get(i) <= 100) {
                            mainLoop = false;
                        } else {
                            System.out.println("Please enter a valid number between 0 - 100.");
                            quizzes.remove(i);
                        }
                        input.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Not a number. Please a valid number between 0 - 100.");
                        input.nextLine();
                    }
                }
            }
            //endregion

        //Calculate the lowest quiz score to drop
        //region
        int min = quizzes.get(0);
        for(int i = 0; i < quizzes.size(); i++){
            if(quizzes.get(i) < min){
                min = quizzes.get(i);
            }
        }
        //endregion

        //Remove the lowest quiz score
        //region
        System.out.println("The lowest is: " + min);
        quizzes.remove(quizzes.indexOf(min));
        //endregion

        //Add the total score of all quizzes, minus lowest score
        //region
        for(int i = 0; i < quizzes.size(); i++){
            sum += quizzes.get(i);
        }
        //endregion

        //Add all scores together to get total score for quizzes
        //region
        totalScore = (prelim + sum + finalGrade) / 7;
        //endregion

        return totalScore;

    }
}
