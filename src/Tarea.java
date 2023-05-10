/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22luismsg
 */
public class Tarea {
    
    private String texto;
    private String estado;
    private boolean estadoBol;
    private String fechaInicio;
    private int idTarea;

    public Tarea(String texto, String estado, String fechaInicio, int idTarea) {
        this.texto = texto;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.idTarea = idTarea;
        
        this.estadoBol = (estado.equals("activa")) ? false : true;
    }

    public String getTexto() {
        return texto;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isEstadoBol() {
        return estadoBol;
    }

    public void setEstadoBol(boolean estadoBol) {
        this.estadoBol = estadoBol;
    }

    
    public String getFechaInicio() {
        return fechaInicio;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
    

    @Override
    public String toString() {
        return "Tarea{" + "texto=" + texto + ", estado=" + estado + ", estadoBol=" + estadoBol + ", fechaInicio=" + fechaInicio + '}';
    }
    
    
    
}
