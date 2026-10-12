
package OOP.class_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface GradedQuestion {
    double evaluate();
    String getType();
}

class MCQQuestion implements GradedQuestion {
    private final String correct;
    private final String answer;
    private final double points;

    MCQQuestion(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    public double evaluate() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion implements GradedQuestion {
    private final String correct;
    private final String answer;
    private final double points;

    TFQuestion(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    public double evaluate() {
        return answer.equalsIgnoreCase(correct) ? points : 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements GradedQuestion {
    private final String keywords;
    private final String answer;
    private final double points;

    EssayQuestion(String keywords, String answer, double points) {
        this.keywords = keywords;
        this.answer = answer;
        this.points = points;
    }

    public double evaluate() {
        String lowerAnswer = answer.toLowerCase();
        String[] words = keywords.split(",");
        int matches = 0;

        for (String word : words) {
            String keyword = word.trim().toLowerCase();

            if (!keyword.isEmpty()
                    && lowerAnswer.contains(keyword)) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            String[] fields = new String[5];
            int count = 0;

            while (matcher.find()) {
                fields[count++] = matcher.group(1) != null
                        ? matcher.group(1) : matcher.group(2);
            }

            String type = fields[0].toUpperCase();
            String correct = fields[2];
            String answer = fields[3];
            double points = Double.parseDouble(fields[4]);

            GradedQuestion question;

            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(correct, answer, points);
                    break;
                case "TF":
                    question = new TFQuestion(correct, answer, points);
                    break;
                case "ESSAY":
                    question = new EssayQuestion(correct, answer, points);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid question type");
            }

            double score = question.evaluate();
            System.out.printf("%s: %.2f%n", question.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
