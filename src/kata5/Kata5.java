package kata5;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;

public class Kata5 {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, SQLException {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM...", mailHistogram);
        histogramDisplay.execute();    
        
    }
    
}
