public class GradeCalc {
    public static void main(String[] args) {

        int homeworkTotal, quizTotal;
        double courseTotal;

        System.out.println("Grade Calculator");
        System.out.println("--------------------------");

        QuizGrade quiz = new QuizGrade();
        HomeworkGrade homework = new HomeworkGrade();

        //Get total score for homework assignments
        homeworkTotal = homework.homeworkGrade();
        System.out.println(homeworkTotal);

        //Get total score for quizzes
        quizTotal = quiz.QuizGrade();
        System.out.println(quizTotal);

        //Get total score for Quiz assignments

        courseTotal = (double) (quizTotal + homeworkTotal) / 2;

        System.out.println("----------------------------");
        System.out.println("Your final course grade is: " + courseTotal);

        //letter grade goes here
        System.out.println("Your letter grade is: " + letterGrade((int) courseTotal));

    }

    public static String letterGrade(int score) {

        if (score >= 97) {
            return "A+";
        } else if (score <= 96 && score >= 93) {
            return "A";
        } else if (score <= 92 && score >= 90) {
            return "A-";
        } else if (score <= 89 && score >= 87) {
            return "B+";
        } else if (score <= 86 && score >= 83) {
            return "B";
        } else if (score <= 82 && score >= 80) {
            return "B-";
        } else if (score <= 79 && score >= 77){
            return "C+";
        } else if (score <= 76 && score >= 73){
            return "C";
        } else if (score <= 72 && score >= 70){
            return "C-";
        } else if (score <= 69 && score >= 67){
            return "D+";
        } else if (score <= 66 && score >= 65){
            return "D";
        } else if (score <= 64 ){
            return "Fail";
        } else {
            throw new RuntimeException();
        }
    }



}
