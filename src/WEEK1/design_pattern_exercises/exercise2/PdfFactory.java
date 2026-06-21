package WEEK1.design_pattern_exercises.exercise2;

class PdfFactory extends DocumentFactory {
    Document createDocument() { return new PdfDocument(); }
}