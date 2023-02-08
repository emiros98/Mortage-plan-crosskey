
import java.io.*;
import java.util.ArrayList;

public class Calculator {

    /*public static void main(String[] args) {
        Calculator c = new Calculator();
        String absolutePath = new File("").getAbsolutePath();
        c.calculateInterest(absolutePath + "\\prospects.txt");
    }*/

    /*private void readInput(BufferedReader file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine(); //Remove first line of input, containing headers
            parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/



    public String calculate(ArrayList<String> line) {
        double sum = Double.parseDouble(line.get(1));
        double interest = Double.parseDouble(line.get(2));
        double years = Double.parseDouble(line.get(3));

        double b = (interest/12.0)/100.0;
        double p = years*12.0;
        double x = pow(1.0+b, p);   // we need this number twice, so we calculate it in advance

        double e = sum*((b*x)/(x-1.0));

        return line.get(0) + " wants to borrow " + sum + "€ for a period of " + (int)years + " years and pay " + round(e) + "€ each month.";

    }




    /**
     * Calculates a^b
     * Returns result
     */
    private double pow(double a, double b){
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
    private double round(double a){
        a = (long)((a*100.0)+0.5);
        return a/100.0;
    }

}
