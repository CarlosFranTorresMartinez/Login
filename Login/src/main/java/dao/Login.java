package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Persona;

public class Login extends Conexion {

    public Persona loginPersona(int dni, String contrasenia) throws SQLException {
        this.conectar();
        ResultSet rs;
        Persona personaM = null;
        try {
            String sql = "SELECT IDPER,\n"
                    + "       CONCAT(NOMBRE,' ',APELLIDO_MATERNO,' ',APELLIDO_PARTENO) AS NOMCOM , \n"
                    + "       DNI, \n"
                    + "       CONTRASENIA,\n"
                    + "       TIP\n"
                    + "FROM PERSONA\n"
                    + "WHERE DNI=? AND CONTRASENIA=?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setInt(1, dni);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            if (rs.next()) {
                personaM = new Persona();
                personaM.setIDPER(rs.getLong("IDPER"));
                personaM.setNOMCOM(rs.getString("NOMCOM"));
                personaM.setTIP(rs.getString("TIP"));
                personaM.setDNI(dni);
                personaM.setCONTRASENIA(contrasenia);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            this.Cerrar();
        }
        return personaM;
    }

}
