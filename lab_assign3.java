import java.util.Scanner;

class Publication {//Declaring publication class 
    public String title;
    public float price;
    public int copies;
    static private float sum;

    Publication() { //Constructor for publication class 
        title = " ABC";
        price = 100;
        copies = 100;
    }

    public void sellcopy(Publication arr1[]) { //Function to store total sells of publication in a static variabale sum

        for (int j = 0; j < arr1.length; j++) {
            sum = sum + (arr1[j].copies * arr1[j].price);
        }

    }

    public void getTotalSells() {//Function to display total sells of publication
        System.out.println("Total Publication sell : " + sum);
    }
}

class Book extends Publication { //Declaring derived class book
    private String author;
    Scanner sc = new Scanner(System.in);
    static int count_books1 = 1;//Static integers to calculate number of books purchased
    static int count_books2 = 1;
    static int count_books3 = 1;

    Book() {//Costructor for derived class book
        System.out.println("Enter title of book no. " + (count_books1) + " that you want : ");
        title = sc.nextLine();
        System.out.println("Enter the name of author : ");
        author = sc.nextLine();
        System.out.println("Enter price of book : " + (count_books1));
        price = sc.nextFloat();
        count_books1++;
    }

    void ordercopies() {//Function that takes input for no. of copies
        System.out.println("Enter no of copies that you want to order for book no. : " + count_books2);
        copies = sc.nextInt();
        count_books2++;
    }

    void display_bill() {//Function to display bill
        System.out.println("\n*******Payment Reciept*******\n");
        System.out.println("Book No.             : " + count_books3);
        System.out.println("Book Name            : " + title);
        System.out.println("Author               : " + author);
        System.out.println("Price                : " + price);
        System.out.println("Total copies ordered : " + copies);
        System.out.println("Total Bill           : " + price * copies);
        count_books3++;

    }
}

class Magazine extends Publication {//Declaring derived class Magazine
    private int OrderQty;
    private String Current_Issue;
    static int count_magazines1 = 1;//Static integers to calculate number of magazines purchased
    static int count_magazines2 = 1;
    static int count_magazines3 = 1;
    Scanner sc = new Scanner(System.in);

    Magazine() {//Costructor for derived class magazine
        System.out.println("Enter title of magazine no. " + count_magazines1 + " that you want : ");
        title = sc.nextLine();
        System.out.println("Enter the date of issue for magazine no. : " + count_magazines1);
        Current_Issue = sc.nextLine();
        System.out.println("Enter price of magazine no. : " + count_magazines1);
        price = sc.nextFloat();
        count_magazines1++;
    }

    void ordercopies() {//Function that takes input for no. of copies
        System.out.println("Enter no. of copies you want to order of magazine no. " + count_magazines2);
        OrderQty = sc.nextInt();
        copies = OrderQty;
        count_magazines2++;
    }

    void display_bill() {//Function to display bill
        System.out.println("\n*******Payment Reciept*******\n");
        System.out.println("Magazine no.         : " + count_magazines3);
        System.out.println("Magazine Name        : " + title);
        System.out.println("Price                : " + price);
        System.out.println("Date of issue        : " + Current_Issue);
        System.out.println("Total copies ordered : " + copies);
        System.out.println("Total Bill           : " + price * copies);
        count_magazines3++;
    }
}

public class lab_assign3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;//Taking choice from user about which operation to perform
        do {
            System.out.println(
                    "\nSelect the operation :\n\t1.Buy the books\n\t2.Buy the magazines\n\t3.Calculate total publication sell\n\t4.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of books you want to buy ");
                    int max_books = sc.nextInt();
                    Book arr1[] = new Book[max_books];
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i] = new Book();
                        arr1[i].ordercopies();
                    }
                    arr1[0].sellcopy(arr1);
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i].display_bill();
                    }
                    break;

                case 2:
                    System.out.println("Enter the number of magazines you want to buy ");
                    int max_magazines = sc.nextInt();
                    Magazine arr2[] = new Magazine[max_magazines];
                    for (int i = 0; i < arr2.length; i++) {
                        arr2[i] = new Magazine();
                        arr2[i].ordercopies();
                    }
                    arr2[0].sellcopy(arr2);
                    for (int i = 0; i < arr2.length; i++) {
                        arr2[i].display_bill();
                    }
                    break;

                case 3:
                    Publication P = new Publication();
                    P.getTotalSells();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Wrong choice !");
                    break;
            }
        } while (choice != 4);

    }
}