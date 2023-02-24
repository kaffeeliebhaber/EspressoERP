package erp;

import erp.hibernate.HibernateUtil;
import erp.hibernate.entities.Answer;
import erp.hibernate.entities.Customer;
import erp.hibernate.entities.Question;
import erp.hibernate.service.CustomerService;
import erp.hibernate.service.QuestionService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Hello JavaFX!");
        Button btn = new Button();
        btn.setText("Hello JavaFX!");
        btn.setOnAction( (event) -> Platform.exit() );
        Pane root = new FlowPane();

        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        root.getChildren().addAll(label, btn);
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();

        /*
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
         */


        //execute();
        //printQuestAnswer(1);

        //add();

        /*

        Customer firstCustomer = get(1);
        firstCustomer.setFirstName("NewFirst");
        new CustomerService().saveOrUpdate(firstCustomer);


         */

    }

    public static void main(String[] args) {
        launch();

    }

    /*
    private void add() {
        final Customer c = new Customer();
        c.setFirstName("Max");
        c.setLastName("Mustermann");

        new CustomerService().saveOrUpdate(c);
    }



    private Customer get(final int customerID) {
        return  new CustomerService().getCustomer(customerID);
    }

    */

    public void printQuestAnswer(final int questionID) {

        final Question question = QuestionService.getQuestion(questionID);

        if (question != null) {
            System.out.println("Question:");
            System.out.println("ID: " + question.getId() + ", NAME: " + question.getQname());

            System.out.println("Answers:");
            for (final Answer a : question.getAnswers()) {
                System.out.println("ID: " + a.getId() + ", ANSWER: " + a.getAnswername());
            }


        } else {
            System.out.println("question == null");
        }
    }

    public void execute() {

        // BEISPIEL VON
        // https://www.javatpoint.com/hibernate-one-to-many-mapping-using-annotation-example
        final Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction t=session.beginTransaction();

        Answer ans1=new Answer();
        ans1.setAnswername("Java is a programming language");
        ans1.setPostedBy("Ravi Malik");

        Answer ans2=new Answer();
        ans2.setAnswername("Java is a platform");
        ans2.setPostedBy("Sudhir Kumar");

        Answer ans3=new Answer();
        ans3.setAnswername("Servlet is an Interface");
        ans3.setPostedBy("Jai Kumar");

        Answer ans4=new Answer();
        ans4.setAnswername("Servlet is an API");
        ans4.setPostedBy("Arun");

        List<Answer> list1=new ArrayList<Answer>();
        list1.add(ans1);
        list1.add(ans2);

        ArrayList<Answer> list2=new ArrayList<Answer>();
        list2.add(ans3);
        list2.add(ans4);

        Question question1=new Question();
        question1.setQname("What is Java?");
        question1.setAnswers(list1);

        Question question2=new Question();
        question2.setQname("What is Servlet?");
        question2.setAnswers(list2);

        session.persist(question1);
        session.persist(question2);

        t.commit();
        session.close();
        System.out.println("success");
    }

}
