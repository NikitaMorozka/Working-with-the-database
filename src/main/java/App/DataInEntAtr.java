package App;

import java.util.ArrayList;
import java.util.Collections;

public class DataInEntAtr {
    private String atrFct;
    private String dflVal;
    private String endEnt;
    private String endStc;
    private String idAtr;
    private String idTbl;
    private String namAtr;
    private String namSlv;
    private String nomAtr;
    private String nomFct;
    private String ogrAtr;
    private String onDlt;
    private String onUpd;
    private String oprFct;
    private String tblFct;
    private String typDat;
    private String vidAtr;

    public DataInEntAtr(String atrFct, String dflVal, String endEnt, String endStc, String idAtr,
                        String idTbl, String namAtr, String namSlv, String nomAtr, String nomFct,
                        String ogrAtr, String onDlt, String onUpd, String oprFct, String tblFct,
                        String typDat, String vidAtr) {
        this.atrFct = atrFct;
        this.dflVal = dflVal;
        this.endEnt = endEnt;
        this.endStc = endStc;
        this.idAtr = idAtr;
        this.idTbl = idTbl;
        this.namAtr = namAtr;
        this.namSlv = namSlv;
        this.nomAtr = nomAtr;
        this.nomFct = nomFct;
        this.ogrAtr = ogrAtr;
        this.onDlt = onDlt;
        this.onUpd = onUpd;
        this.oprFct = oprFct;
        this.tblFct = tblFct;
        this.typDat = typDat;
        this.vidAtr = vidAtr;
    }
    ArrayList<String> arr = new ArrayList<>();

    public void initialize(){
        Collections.addAll(arr, atrFct, dflVal, endEnt, endStc, idAtr,
                idTbl, namAtr, namSlv, nomAtr, nomFct, ogrAtr, onDlt,
                onUpd, oprFct, tblFct, typDat, vidAtr);
    }

     public String ret(int index){
         initialize();
        return arr.get(index);
    }

    public String getAtrFct() {
        return atrFct;
    }

    public String getDflVal() {
        return dflVal;
    }

    public String getEndEnt() {
        return endEnt;
    }

    public String getEndStc() {
        return endStc;
    }

    public String getIdAtr() {
        return idAtr;
    }

    public String getIdTbl() {
        return idTbl;
    }

    public String getNamAtr() {
        return namAtr;
    }

    public String getNamSlv() {
        return namSlv;
    }

    public String getNomAtr() {
        return nomAtr;
    }

    public String getNomFct() {
        return nomFct;
    }

    public String getOgrAtr() {
        return ogrAtr;
    }

    public String getOnDlt() {
        return onDlt;
    }

    public String getOnUpd() {
        return onUpd;
    }

    public String getOprFct() {
        return oprFct;
    }

    public String getTblFct() {
        return tblFct;
    }

    public String getTypDat() {
        return typDat;
    }

    public String getVidAtr() {
        return vidAtr;
    }
}
