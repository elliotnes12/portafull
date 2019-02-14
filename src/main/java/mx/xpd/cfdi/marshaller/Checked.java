
package mx.xpd.cfdi.marshaller;
public class Checked {
    private String nombre;
    private boolean activo;
    private String method;
    
    public Checked(){}

    public Checked(String nombre, boolean activo, String method) {
        this.nombre = nombre;
        this.activo = activo;
        this.method = method;
    }

    public Checked(boolean activo){
        this.activo = activo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
}
