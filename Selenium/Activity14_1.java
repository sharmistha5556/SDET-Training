package selenium_session1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity14_1 {
	public static void main(String[] args) throws IOException, CsvException {
		//Load CSV file
        CSVReader reader = new CSVReader(new FileReader("src/test/java/tests/sample.csv"));

        //Load content into list
        List<String[]> list = reader.readAll();
        System.out.println("Total number of rows are: " + list.size());

        //Create Iterator reference
        Iterator<String[]> itr = list.iterator();

        //Iterate all values
        while(itr.hasNext()) {
            String[] str = itr.next();

            System.out.print("Values are: ");
            System.out.print("The array size is: " + str.length);
            for(int i=0;i<str.length;i++) {
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }
        
        reader.close();
	}
}