interface Document {
    String getDocumentType();
}

class WordDocument implements Document {
    @Override
    public String getDocumentType() {
        return "Word Document";
    }
}

class PdfDocument implements Document {
    @Override
    public String getDocumentType() {
        return "Pdf Document";
    }
}

class ExcelDocument implements Document {
    @Override
    public String getDocumentType() {
        return "Excel Document";
    }
}

abstract class BuildFactory {
    public abstract Document createDocument();
}

class BuildWordDocument extends BuildFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class BuildPdfDocument extends BuildFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class BuildExcelDocument extends BuildFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryPatternExample {
    public static void main(String[] args) {

        // Word Document
        BuildFactory buildWordDoc = new BuildWordDocument();
        Document wordDoc = buildWordDoc.createDocument();
        System.out.println("Document type is: " + wordDoc.getDocumentType());

        // Pdf Document
        BuildFactory buildPdfDoc = new BuildPdfDocument();
        Document pdfDoc = buildPdfDoc.createDocument();
        System.out.println("Document type is: " + pdfDoc.getDocumentType());

        // Excel Document
        BuildFactory buildExcelDoc = new BuildExcelDocument();
        Document excelDoc = buildExcelDoc.createDocument();
        System.out.println("Document type is: " + excelDoc.getDocumentType());
    }
}