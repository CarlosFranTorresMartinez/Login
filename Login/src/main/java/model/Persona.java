package model;

public class Persona {
    private Long IDPER;
    private String NOMBRE;
    private String APELLIDO_PATERNO;
    private String APELLIDO_MATERNO;
    private int DNI;
    private String CONTRASENIA;
    private String TIP;
    
    
    private String NOMCOM;

    public Long getIDPER() {
        return IDPER;
    }

    public void setIDPER(Long IDPER) {
        this.IDPER = IDPER;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO_PATERNO() {
        return APELLIDO_PATERNO;
    }

    public void setAPELLIDO_PATERNO(String APELLIDO_PATERNO) {
        this.APELLIDO_PATERNO = APELLIDO_PATERNO;
    }

    public String getAPELLIDO_MATERNO() {
        return APELLIDO_MATERNO;
    }

    public void setAPELLIDO_MATERNO(String APELLIDO_MATERNO) {
        this.APELLIDO_MATERNO = APELLIDO_MATERNO;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getCONTRASENIA() {
        return CONTRASENIA;
    }

    public void setCONTRASENIA(String CONTRASENIA) {
        this.CONTRASENIA = CONTRASENIA;
    }

    public String getTIP() {
        return TIP;
    }

    public void setTIP(String TIP) {
        this.TIP = TIP;
    }

    public String getNOMCOM() {
        return NOMCOM;
    }

    public void setNOMCOM(String NOMCOM) {
        this.NOMCOM = NOMCOM;
    }
    
    
    
}
