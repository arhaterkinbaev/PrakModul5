import java.util.Scanner;

interface Document {
    void open();
}

class Report implements Document {
    public void open() {
        System.out.println("Отчёт открыт.");
    }
}

class Resume implements Document {
    public void open() {
        System.out.println("Резюме открыто.");
    }
}

class Letter implements Document {
    public void open() {
        System.out.println("Письмо открыто.");
    }
}

class Invoice implements Document {
    public void open() {
        System.out.println("Счёт открыт.");
    }
}

abstract class DocumentCreator {
    public abstract Document createDocument();
}

class ReportCreator extends DocumentCreator {
    public Document createDocument() {
        return new Report();
    }
}

class ResumeCreator extends DocumentCreator {
    public Document createDocument() {
        return new Resume();
    }
}

class LetterCreator extends DocumentCreator {
    public Document createDocument() {
        return new Letter();
    }
}

class InvoiceCreator extends DocumentCreator {
    public Document createDocument() {
        return new Invoice();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Тип документа:");
        System.out.println("1. Отчёт");
        System.out.println("2. Резюме");
        System.out.println("3. Письмо");
        System.out.println("4. Счёт");

        int choice = scanner.nextInt();
        DocumentCreator creator = null;

        switch (choice) {
            case 1:
                creator = new ReportCreator();
                break;
            case 2:
                creator = new ResumeCreator();
                break;
            case 3:
                creator = new LetterCreator();
                break;
            case 4:
                creator = new InvoiceCreator();
                break;
            default:
                System.out.println("Неверный выбор!");
                break;
        }

        if (creator != null) {
            Document document = creator.createDocument();
            document.open();
        }

        scanner.close();
    }
}
