package App;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InEntAtrController {

    ArrayList<TextField> textFields = new ArrayList<>();

    private void addAllTextField(){
        Collections.addAll(textFields, textFieldAtrFct, textFieldDflVal, textFieldEndEnt, textFieldEndStc,
                textFieldIdAtr, textFieldIdTbl, textFieldNamAtr, textFieldNamSlv,
                textFieldNomAtr, textFieldNomFct, textFieldOgrAtr, textFieldOnDlt,
                textFieldOnUpd, textFieldOprFct, textFieldTblFct, textFieldTypDat, textFieldVidAtr);
    }

    private void init(){
        ArrayList<TableColumn<DataInEntAtr, String>> columns = new ArrayList<>(Arrays.asList(
                atrFctColumn, dflValColumn, endEntColumn, endStcColumn, idAtrColumn, idTblColumn,
                namAtrColumn, namSlvColumn, nomAtrColumn, nomFctColumn, ogrAtrColumn, onDltColumn,
                onUpdColumn, oprFctColumn, tblFctColumn, typDatColumn, vidAtrColumn
        ));

        for(int i = 0; i < columns.size(); i++){
            int value = i;
            columns.get(i).setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().ret(value)));
        }

    }
    private boolean areFieldsFilled() {
        for (TextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void addSql(){
        AddToPostgreSQL addToPostgreSQL = new AddToPostgreSQL();
        int idAtr = Integer.parseInt(textFieldIdAtr.getText());
        int idTbl = Integer.parseInt(textFieldIdTbl.getText());
        int nomAtr = Integer.parseInt(textFieldNomAtr.getText());
        int nomFct = Integer.parseInt(textFieldNomFct.getText());
        int endEnt = Integer.parseInt(textFieldEndEnt.getText());
        int endStc = Integer.parseInt(textFieldEndStc.getText());
        int vidAtr = Integer.parseInt(textFieldVidAtr.getText());

        String namAtr = textFieldNamAtr.getText();
        String typDat = textFieldTypDat.getText();
        String ogrAtr = textFieldOgrAtr.getText();
        String dflVal = textFieldDflVal.getText();
        String namSlv = textFieldNamSlv.getText();
        String onUpd = textFieldOnUpd.getText();
        String onDlt = textFieldOnDlt.getText();
        String tblFct = textFieldTblFct.getText();
        String atrFct = textFieldAtrFct.getText();
        String oprFct = textFieldOprFct.getText();
        addToPostgreSQL.addSQLinEntAtr(
                idAtr, namAtr, typDat, ogrAtr, dflVal, namSlv, vidAtr, onUpd, onDlt,
                idTbl, tblFct, atrFct, oprFct, nomAtr, endEnt, nomFct, endStc
        );
    }

    @FXML
    private TableColumn<DataInEntAtr, String> atrFctColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> dflValColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> endEntColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> endStcColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> idAtrColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> idTblColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> namAtrColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> namSlvColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> nomAtrColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> nomFctColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> ogrAtrColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> onDltColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> onUpdColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> oprFctColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> tblFctColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> typDatColumn;
    @FXML
    private TableColumn<DataInEntAtr, String> vidAtrColumn;
    @FXML
    private TableView<DataInEntAtr> table;



    @FXML
    private TextField textFieldAtrFct;
    @FXML
    private TextField textFieldDflVal;
    @FXML
    private TextField textFieldEndEnt;
    @FXML
    private TextField textFieldEndStc;
    @FXML
    private TextField textFieldIdAtr;
    @FXML
    private TextField textFieldIdTbl;
    @FXML
    private TextField textFieldNamAtr;
    @FXML
    private TextField textFieldNamSlv;
    @FXML
    private TextField textFieldNomAtr;
    @FXML
    private TextField textFieldNomFct;
    @FXML
    private TextField textFieldOgrAtr;
    @FXML
    private TextField textFieldOnDlt;
    @FXML
    private TextField textFieldOnUpd;
    @FXML
    private TextField textFieldOprFct;
    @FXML
    private TextField textFieldTblFct;
    @FXML
    private TextField textFieldTypDat;
    @FXML
    private TextField textFieldVidAtr;
    @FXML
    private Button addButton;

    @FXML

    void initialize() {
        addAllTextField();
        init();

        addButton.setOnAction(event -> {
                DataInEntAtr dataInEntAtr = new DataInEntAtr(textFieldAtrFct.getText(), textFieldDflVal.getText(),
                        textFieldEndEnt.getText(), textFieldEndStc.getText(), textFieldIdAtr.getText(),
                        textFieldIdTbl.getText(), textFieldNamAtr.getText(), textFieldNamSlv.getText(),
                        textFieldNomAtr.getText(), textFieldNomFct.getText(), textFieldOgrAtr.getText(),
                        textFieldOnDlt.getText(), textFieldOnUpd.getText(), textFieldOprFct.getText(),
                        textFieldTblFct.getText(), textFieldTypDat.getText(), textFieldVidAtr.getText()
                );

                table.getItems().add(dataInEntAtr);
                addSql();
                textFields.forEach(TextField::clear);

        });
    }
}
