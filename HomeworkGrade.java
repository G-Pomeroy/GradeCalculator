import java.util.InputMismatchException;
import java.util.stream.*;
import java.util.Scanner;
public class HomeworkGrade extends GradeCalc {

    //Setting up variables, arrayLists, and Scanner for collecting homework grades
    //region
    boolean mainLoop = true;
    private String lateFlag;
    private int sum;
    private int [] homeworkGrades = new int[5];
    private Scanner input = new Scanner(System.in);
    private static int totalScore;
    //endregion

    //endregion

    public int homeworkGrade() {

        /* A For Loop to go through each assignment collecting the grades and checking if the homework was late, if so,
        a penalty of 15% is applied. */


        for(int i = 0; i < homeworkGrades.length; i++) {
            mainLoop = true;
            while (mainLoop) {
                System.out.println("On a scale from 0 - 100,");
                System.out.println("Enter a grade for homework #" + (i + 1) + ": ");
                try {
                    homeworkGrades[i] = input.nextInt();
                    if (homeworkGrades[i] >= 0 && homeworkGrades[i] <= 100) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 0 -100");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Not a number. Please a valid number between 0 - 100.");
                    input.nextLine();
                }
            }

                input.nextLine();


            // Asking user if homework was late, and submitted within 24hr for point deduction
                while (mainLoop) {
                    System.out.println("Was homework #" + (i + 1) + " submitted on time? (Y/N)");
                    try {
                        lateFlag = input.next();
                        if (lateFlag.equals("n") || lateFlag.equals("N")) {
                            System.out.println("Was the homework submitted within the 24hr timeframe? (Y/N)");
                            lateFlag = input.next();

                            while (mainLoop) {
                                if (lateFlag.equals("n") || lateFlag.equals("N")) {
                                    int score = homeworkGrades[i];
                                    score *= 0.85;
                                    homeworkGrades[i] = score;
                                    mainLoop = false;
                                } else if (lateFlag.equals("y") || lateFlag.equals("Y")) {
                                    mainLoop = false;
                                } else {
                                    System.out.println("Please enter a valid answer using Y/y or N/n");
                                }
                            }
                        } else if (lateFlag.equals("y") || lateFlag.equals("Y")) {
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Not a number. Please a valid number between 0 - 100.");
                        input.nextLine();
                    }
                }
        }

        //Adding all scores up and dividing by the number of quizzes to receive the average mark
        for(int i = 0; i < homeworkGrades.length; i++){
            sum = IntStream.of(homeworkGrades).sum();
            totalScore = sum / 5;
        }
        return totalScore;
    }
}
