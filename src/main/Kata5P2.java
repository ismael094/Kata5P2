
package main;

import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import static view.MailHistogramBuilder.build;
import static view.MailListReader.read;
import static view.MailListReaderBD.read;

public class Kata5P2 {
    
    private final String fileName;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
            
    public static void main(String[] args)  {
        Kata5P2 k = new Kata5P2("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5P2\\src\\main\\email.txt");
        k.execute();
    }

    public Kata5P2(String fileName) {
        this.fileName = fileName;
    }
    
    public void execute() {
        input();
        process();
        output();
    }
    
    public void input() {
        try {
           mailList = read(); 
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con el fichero");
        }
    }
    
    public void process() {
        histogram = build(mailList);
    }
    
    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
