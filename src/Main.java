import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printMenu();
        Book[] bookArr = new Book[10];
        Book book1 = new Book(1, "kolge", "ayxan");
        bookArr[0] = book1;
        int choice;
        while (true) {
            System.out.println("secim daxil edin");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    boolean added = false;
                    for (int i = 0; i < bookArr.length; i++) {
                        if (bookArr[i] == null) {
                            bookArr[i] = addBook();
                            System.out.println("kiab ugurla elave olundu");
                            added = true;
                            break;
                        }
                    }
                    if (added == false) System.out.println("kitab ucun yer yoxdur");
                    break;
                case 2:
                    boolean found = false;
                    for (int i = 0; i < bookArr.length; i++) {
                        if (bookArr[i] != null) {
                            System.out.println(bookArr[i]);
                            found = true;
                        }
                    }
                    if (found == false) System.out.println("kitab yoxdur");
                    break;

                case 3:
                    boolean deleted = false;
                    System.out.println("silmek istediyiniz kitabin ID-ni yazin");
                    int deleteId = scan.nextInt();
                    for (int i = 0; i < bookArr.length; i++) {
                        if (bookArr[i] != null) {
                            if (bookArr[i].getId() == deleteId) {
                                bookArr[i] = null;
                                System.out.println(deleteId + "--ID olan kitab silindi");
                                deleted = true;
                                break;
                            }
                        }

                    }
                    if (deleted == false) System.out.println(" bu ID-li kitab yoxdur");
                    break;
                case 0:
                    System.out.println("programdan cixilir..");
                    return;

                default:
                    System.out.println("sehv secim etmisiniz");

            }
        }
    }


    public static Book addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ID daxil edin");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("kitab adi daxil edin");
        String name = scan.nextLine();
        System.out.println("yazici adi daxil edin");
        String author = scan.nextLine();
        Book newBook = new Book(id, name, author);
        return newBook;

    }

    public static final void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add new book");
        System.out.println("2. View all books");
        System.out.println("3. Delete book by ID");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}