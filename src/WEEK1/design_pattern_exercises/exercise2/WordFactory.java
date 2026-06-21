package WEEK1.design_pattern_exercises.exercise2;

class WordFactory extends DocumentFactory {
    Document createDocument() { return new WordDocument(); }
}