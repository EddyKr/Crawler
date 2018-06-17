import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WebCrawler mainCrawler = new WebCrawler();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your root URL: ");
        String URL = sc.nextLine();
        mainCrawler.startCrawling(URL);

    }
}
