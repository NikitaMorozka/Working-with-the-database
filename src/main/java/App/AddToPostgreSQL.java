package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddToPostgreSQL extends ConfigsSQL {

    public  void addSQLmdEnt(int id_ent, String sch,String tbl,String idf, String nic, String slv, String prd) {

        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbUser,
                dbName, dbPass)) {
            String sql = "INSERT INTO mdb.\"mdEnt\" (id_ent, sch, tbl, idf,nic,slv,prd) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id_ent);
            stmt.setString(2, sch);
            stmt.setString(3, tbl);
            stmt.setString(4, idf);
            stmt.setString(5, nic);
            stmt.setString(6, slv);
            stmt.setString(7, prd);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

        public void addSQLinEntAtr (int id_atr, String namAtr, String typDat, String ogrAtr, String dflVal,
                            String namSlv,  int vidAtr, String onUpd, String onDlt, int id_tbl,
                            String tblFct, String atrFct, String oprFct, int nomAtr, int endEnt,
                            int nomFct, int endStc){

            try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbUser,
                    dbName, dbPass)) {

                String sql = "INSERT INTO mdb.\"inEntAtr\" (\"id_atr\", \"namAtr\", \"typDat\", \"ogrAtr\", \"dflVal\", \"namSlv\", \"vidAtr\", " +
                        "\"onUpd\", \"onDlt\", \"id_tbl\", \"tblFct\", \"atrFct\", \"oprFct\", \"nomAtr\", \"endEnt\", \"nomFct\", \"endStc\") " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setInt(1, id_atr);
                stmt.setString(2, namAtr.isEmpty() ? null : namAtr);
                stmt.setString(3, typDat.isEmpty() ? null : typDat);
                stmt.setString(4, ogrAtr.isEmpty() ? null : ogrAtr);
                stmt.setString(5, dflVal.isEmpty() ? null : dflVal);
                stmt.setString(6, namSlv.isEmpty() ? null : namSlv);
                stmt.setInt(7, vidAtr);
                stmt.setString(8, onUpd.isEmpty() ? null : onUpd);
                stmt.setString(9, onDlt.isEmpty() ? null : onDlt);
                stmt.setInt(10, id_tbl);
                stmt.setString(11, tblFct.isEmpty() ? null : tblFct);
                stmt.setString(12, atrFct.isEmpty() ? null : atrFct);
                stmt.setString(13, oprFct.isEmpty() ? null : oprFct);
                stmt.setInt(14, nomAtr);
                stmt.setInt(15, endEnt);
                stmt.setInt(16, nomFct);
                stmt.setInt(17, endStc);


                stmt.executeUpdate();


            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        }
    }
