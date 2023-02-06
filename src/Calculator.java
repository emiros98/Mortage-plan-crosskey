import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {

    ArrayList<ArrayList<String>> prospects = new ArrayList<>();

    public static void main(String[] args) {
        Calculator c = new Calculator();
        String absolutePath = new File("").getAbsolutePath();
        c.calculateInterest(absolutePath + "\\prospects.txt");
    }

    private void calculateInterest(String filepath) {
        readInput(filepath);
        int i = 1;
        for (ArrayList<String> l: prospects) {
            System.out.println("Prospect " + i + ": " + calculate(l));
        }
    }

    private void readInput(String filepath) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine(); //Remove first line of input, containing headers
            parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parse(BufferedReader reader) throws IOException {
        int c = reader.read();
        char character = (char) c;
        ArrayList<String> line = new ArrayList<>();

        while((c != -1))         //Read char by char
        {


            switch (character) {
                case '"':
                    StringBuilder b = new StringBuilder();
                    character = (char) reader.read();
                    while (character != '"') {
                        b.append(character);
                        c = reader.read();
                        character = (char) c;
                    }
                    line.add(b.toString());
                    c = reader.read();
                    character = (char) c;
                    break;
                case '.':
                case ',':
                case '\n':
                    c = reader.read();
                    character = (char) c;
                    break;
                default:
                    StringBuilder d = new StringBuilder();
                    while (character != ',' && character != '\n') {
                        d.append(character);
                        c = reader.read();
                        character = (char) c;
                    }
                    line.add(d.toString());
                    if (character == '\n') {
                        prospects.add(line);
                        line = new ArrayList<>();
                    }
                    break;
            }
        }
    }

    private String calculate(ArrayList<String> line) {
        double sum = Double.parseDouble(line.get(1));
        double interest = Double.parseDouble(line.get(2));
        double years = Double.parseDouble(line.get(3));

        double b = (interest/12.0)/100.0;
        double p = years*12.0;
        double x = pow(1.0+b, p);   // we need this number twice, so we calculate it in advance

        double e = sum*(b*x)/(x-1.0);

        return line.get(0) + " wants to borrow " + sum + "€ for a period of " + (int)years + " years and pay " + round(e) + "€ each month.";

    }




    /**
     * Calculates a^b
     * Returns result
     */
    protected double pow(double a, double b){
        double res = a;
        for (int i = 1; i < b; i++){
            res = res*a;
        }
        return res;
    }


    /**
     * Function for rounding a double to two decimals
     * @param a the double to be rounded
     */
    protected double round(double a){
        a = (long)((a*100.0)+0.5);
        return a/100.0;
    }

}
