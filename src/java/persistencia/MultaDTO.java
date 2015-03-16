/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


/**
 *
 * @author jeisson
 */
public class MultaDTO {
    
    private int idMulta;
    private int prestamoId;
    private String fechaMulta;
    private int valorTotal;
    private String fechaPago;
    private byte estado;

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public String getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "MultaDTO{" + "idMulta=" + idMulta + ", prestamoId=" + prestamoId + ", fechaMulta=" + fechaMulta + ", valorTotal=" + valorTotal + ", fechaPago=" + fechaPago + ", estado=" + estado + '}';
    }
    
}
