package WEEK1.DesignPatterns.exercise2;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory pdfFactory = new PdfFactory();
        Document myPdf = pdfFactory.createDocument();
        myPdf.open();

        DocumentFactory wordFactory = new WordFactory();
        Document myWord = wordFactory.createDocument();
        myWord.open();
    }
}
