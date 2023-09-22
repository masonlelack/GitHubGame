package com.example.githubgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class HelloController {

    @FXML
    private Button startButton;

    @FXML
    private Label definitionText;

    @FXML
    private Label accuracyBox;

    @FXML
    private ImageView myImage;

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonD;

    private double correct = 0;
    private double wrong = 0;
    private double total = 0;


    private int size = VocabularyWord.definitionsSize()-1;


    /*@FXML
    public void buttonClicked(ActionEvent itemClicked){
        Button buttonClicked = (Button)itemClicked.getSource();
    }*/

        private int randomNum1 = (int)((Math.random()*(VocabularyWord.definitionsSize()-1)));
        private int randomNum2 = (int)((Math.random()*(VocabularyWord.definitionsSize()-1)));
        private int randomNum3 = (int)((Math.random()*(VocabularyWord.definitionsSize()-1)));



        public void updateRandomNum(){
            randomNum1 = (int)Math.floor((Math.random()*(VocabularyWord.definitionsSize()-1)));
            randomNum2 = (int)Math.floor((Math.random()*(VocabularyWord.definitionsSize()-1)));
            randomNum3 = (int)Math.floor((Math.random()*(VocabularyWord.definitionsSize()-1)));
        }


    public void gameSetUp(ActionEvent itemClicked){
        definitionText.setText(VocabularyWord.returnDef(24));
        buttonA.setText(VocabularyWord.returnWord(24));
        buttonB.setText(VocabularyWord.returnWord(randomNum1));
        buttonC.setText(VocabularyWord.returnWord(randomNum2));
        buttonD.setText(VocabularyWord.returnWord(randomNum3));
    }

    public void setButtonColor(ActionEvent itemClicked){
        Button buttonClicked = (Button) itemClicked.getSource();
        buttonClicked.setStyle("-fx-background-color: green");
    }

     public void resetButtonColor(){
         buttonA.setStyle("");
         buttonB.setStyle("");
         buttonC.setStyle("");
         buttonD.setStyle("");
    }

    public void replaceWord(ActionEvent itemClicked,int size) {
        Button buttonClicked = (Button) itemClicked.getSource();
        String replacing = VocabularyWord.returnWord(size);
        String newDef = definitionText.getText();
        newDef.replace(replacing, buttonClicked.getText());
        definitionText.setText(newDef);
    }

    public void gameLogic(ActionEvent itemClicked) {
        Button buttonClicked = (Button) itemClicked.getSource();
        setButtonColor(itemClicked);
        replaceWord(itemClicked,size);
        if (buttonClicked.getText().equals(VocabularyWord.returnWord(size))) {
            correct++;
        }
        else{
            wrong++;
        }
        total++;
        size--;
        accuracyBox.setText("You got it correct!  " + "  Number Correct: " + correct + "  Number Incorrect: " + wrong + "  Accuracy: " + (Math.ceil((correct/total)*100)) + "%");
        if((Math.ceil((correct/total)*100))<70){
            accuracyBox.setTextFill(Color.RED);
        }
        else if((Math.ceil((correct/total)*100)>=70) && (79>=(Math.ceil((correct/total)*100)))){
            accuracyBox.setTextFill(Color.ORANGE);
        }
        else if((Math.ceil((correct/total)*100)>=80) && (89>=(Math.ceil((correct/total)*100)))){
            accuracyBox.setTextFill(Color.BLUE);
        }
        else if(((Math.ceil((correct/total)*100)>=90))){
            accuracyBox.setTextFill(Color.GREEN);
        }
        if(size>=0){
            updateRandomNum();
            definitionText.setText(VocabularyWord.returnDef(size));
            buttonA.setText(VocabularyWord.returnWord(size));
            buttonB.setText(VocabularyWord.returnWord(randomNum1));
            buttonC.setText(VocabularyWord.returnWord(randomNum2));
            buttonD.setText(VocabularyWord.returnWord(randomNum3));
        }
        else {
            definitionText.setText("Game Over! Thank you for playing!");
        }
    }

    /*public void newPopUp(ActionEvent event){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),320,420);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/



}
