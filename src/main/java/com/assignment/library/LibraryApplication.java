package com.assignment.library;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class LibraryApplication extends Application {
    private static Library library;
    public static class HBoxCell extends HBox {
        Label label = new Label();
        Button button = new Button();

        HBoxCell(String labelText, String buttonText) {
            super();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);
            button.setText(buttonText);
            this.getChildren().addAll(label, button);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String innerButtonText = button.getText();
                    for (Book book: library.getBooks()) {
                        if (book.getTitle().equals(labelText)) {
                            System.out.println("You have " + innerButtonText.toLowerCase() + "ed " + "\""+ labelText +"\"");
                            if (innerButtonText.equals("Borrow")) {
                                book.borrowed();
                                innerButtonText = "Return";
                            } else {
                                book.returned();
                                innerButtonText="Borrow";
                            }
                            button.setText(innerButtonText);
                            break;
                        }
                    }
                }
            });
        }
    }

    public Parent createContent() {
        BorderPane layout = new BorderPane();
        List<HBoxCell> list = new ArrayList<>();
        for (Book book : library.getBooks()) {
            String buttonDisplayText = "Borrow";
            if (book.isBorrowed()) {
                buttonDisplayText = "Return";
            }
            list.add(new HBoxCell(book.getTitle(), buttonDisplayText));
        }
        ListView<HBoxCell> listView = new ListView<HBoxCell>();
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        layout.setCenter(listView);
        return layout;
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }
    public static void main(String[] args) {
        library = new Library("300 College Park Dr.");
        library.addBook(new Book("Java How To Program (Early Objects))"));
        library.addBook(new Book("Rise of the Robots"));
        library.addBook(new Book("Code Complete"));
        library.getBooks().get(2).borrowed();
        library.addBook(new Book("The Pragmatic Programmer"));
        launch(args);
    }
}