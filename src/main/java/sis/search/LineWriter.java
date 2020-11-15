package sis.search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LineWriter {

    public static void write(String filename, String[] recodes) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i <recodes.length; i++){
                writer.write(recodes[i]);
                writer.newLine();
            }
        }finally {
            if (writer != null)
                writer.close();
        }
    }
}
