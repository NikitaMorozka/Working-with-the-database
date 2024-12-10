package App;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mdEntController {
    ArrayList<TextField> textFields = new ArrayList<>();

    private void addTextField(){
        Collections.addAll(textFields,id_ent,idf,nic,prd,sch,slv,tbl);
    }

    private boolean areFieldsFilled() {
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id_ent;

    @FXML
    private TextField idf;

    @FXML
    private TextField nic;

    @FXML
    private TextField prd;

    @FXML
    private TextField sch;

    @FXML
    private TextField slv;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField tbl;

    @FXML
    private Button addButton;




    @FXML
    void initialize() {
        AddToPostgreSQL addToPostgreSQL = new AddToPostgreSQL();
        addButton.setOnAction(event -> {
            addTextField();
            try {
                if (areFieldsFilled()) {
                    addToPostgreSQL.addSQLmdEnt(Integer.parseInt(id_ent.getText()), idf.getText(),
                            nic.getText(), prd.getText(), sch.getText(), slv.getText(),
                            tbl.getText());
                    addButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/inEntAtr.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                } else {
                    statusLabel.setText("Ошибка, проверьте правильность заполнения полей");
                }
            }catch (Exception e){
                statusLabel.setText("Такой ID уже существует");
            }

        });

    }

}
