package WEEK1.design_pattern_exercises.exercise2;

class ExcelFactory extends DocumentFactory {
    Document createDocument() { return new ExcelDocument(); }
}