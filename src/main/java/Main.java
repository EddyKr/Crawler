import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application{

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        Button searchBtn = new Button("Launch");
        ListView<String> statisticsLV = new ListView<String>();
        statisticsLV.setPrefWidth(325);
        ListView<String> JSONresponseLV = new ListView<String>();
        TextField targetURL = new TextField();
        TextField searchPhrase = new TextField();
        Label lblTarget = new Label("Enter Target URL:");
        Label lblSearch = new Label("Extra search phrase:");
        Label lblStats = new Label("Statistics:");
        Label lblJSON = new Label("JSON objects:");


        HBox rootHB = new HBox();
        VBox vB1 = new VBox();
        VBox vB2 = new VBox();

        vB1.getChildren().add(lblTarget);
        vB1.getChildren().add(targetURL);
        vB1.getChildren().add(lblSearch);
        vB1.getChildren().add(searchPhrase);
        vB1.getChildren().add(searchBtn);

        vB2.getChildren().add(lblStats);
        vB2.getChildren().add(statisticsLV);
        vB2.getChildren().add(lblJSON);
        vB2.getChildren().add(JSONresponseLV);

        rootHB.getChildren().add(vB1);
        rootHB.getChildren().add(vB2);

        Scene s = new Scene(rootHB,750,500);
        primaryStage.setScene(s);
        primaryStage.show();
    }



    public static void main(String[] args) {
/*
        WebCrawler mainCrawler = new WebCrawler();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your root URL: ");
        String URL = sc.nextLine() + " ";
        mainCrawler.crawl(URL);
*/
        launch(args);
    }



}
