import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Creating instance of webcrawler
        WebCrawler mainCrawler = new WebCrawler();
        //Scanner for reading users url input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your root URL: ");
        String URL = sc.nextLine();
        //Launching
        mainCrawler.startCrawling(URL);

    }
}
