import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    public ArrayList<ArrayList<String>> parse(BufferedReader reader) throws IOException {

        ArrayList<ArrayList<String>> prospects = new ArrayList<>();

        reader.readLine(); //Remove first line of input, containing headers
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
        return prospects;
    }
}
