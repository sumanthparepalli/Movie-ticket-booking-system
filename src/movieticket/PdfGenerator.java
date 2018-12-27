package movieticket;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author Sumanth
 */
public class PdfGenerator {
    
    String name;
    String seats;
    int noofseats;
    int hallNo;
    String movieName;
    String date;
    String time;
    String ticketType;
    byte[] img;
    

    Document document;


    public PdfGenerator(String name, String seats, int noofseats, int hallNo, String movieName, String date, String time, String ticketType, byte[] img) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        
        this.name = name;
        this.seats = seats;
        this.noofseats = noofseats;
        this.hallNo = hallNo;
        this.movieName = movieName;
        this.date = date;
        this.time = time;
        this.ticketType = ticketType;
//        this.img = Arrays.copyOf(img, img.length);
        
        document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Ticket.pdf"));
        document.open();
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
//        paragraph1.add(anchorTarget);
        document.add(paragraph1);
//        document.add(new Paragraph("*This is automatically gennerated by TIcket booking software.",
//        FontFactory.getFont(FontFactory.COURIER, 8, Font.BOLD, new CMYKColor(0, 255, 0, 0))));
        Paragraph title1 = new Paragraph("*This is automatically gennerated by TIcket booking software.",FontFactory.getFont(FontFactory.COURIER,8, Font.BOLDITALIC, new CMYKColor(0, 255, 0,0)));
        Chapter chapter1 = new Chapter(title1, 1);
        chapter1.setNumberDepth(0);
        Paragraph title11 = new Paragraph("\b\bMovie  Name: "+movieName+"\nHall No: "+hallNo+"\nDate: "+date+"\t  Time: "+time+"\nNumber of seats: "+noofseats+"\nSeats: "+seats+"\nTicket Type: "+ticketType, FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, 
        new CMYKColor(0, 255, 255,17)));    
        Section section1 = chapter1.addSection(title11);
        Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 1.");
//        section1.add(someSectionText);
        someSectionText = new Paragraph("Following is a 3 X 2 table.");
//        section1.add(someSectionText);
        Image image2 = Image.getInstance(img);
        image2.scaleAbsolute(93f,52f);
        section1.add(image2);
        Image img3=Image.getInstance("logo.png");
        img3.scaleAbsolute(93f, 52f);
        section1.add(img3);
        document.add(chapter1);
        document.close();
    }
    

//    public static void main(String[] args) throws FileNotFoundException, DocumentException, BadElementException, BadElementException{
//        try {
//            byte[] img2={1,0};
//            new PdfGenerator("Sumanth","1,2",2,1,"Hello","19-08-2018","16:00","Normal+Combo",img2);
//        } catch (DocumentException | IOException | NullPointerException ex) {
//            Logger.getLogger(PdfGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
