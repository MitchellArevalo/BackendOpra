package ecommerce.sales.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.employees.modelo.entidad.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Sale {
    private Long idSale;
    private DataDTOEmployee employee;
    private Cliente cliente;
    private BigDecimal valorVenta;
    private BigDecimal profitVenta;
    private String marginProfitVenta;
    private String tipoVenta;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime fechaVenta;
    private String estadoVenta;

    public Sale(Long idSale, DataDTOEmployee employee, Cliente cliente, BigDecimal valorVenta, BigDecimal profitVenta, String marginProfitVenta, String tipoVenta, LocalDateTime fechaVenta, String estadoVenta) {
        this.idSale = idSale;
        this.employee = employee;
        this.cliente = cliente;
        this.valorVenta = valorVenta;
        this.profitVenta = profitVenta;
        gananciaProfitMargin();
        this.tipoVenta = tipoVenta;
        this.fechaVenta = fechaVenta;
        this.estadoVenta = estadoVenta;
    }
    public static Sale reconstruir(Long idSale, DataDTOEmployee employee, Cliente cliente, BigDecimal valorVenta, BigDecimal profitVenta, String marginProfitVenta, String tipoVenta, LocalDateTime fechaVenta, String estadoVenta) {
        ValidadorArgumento.validarObligatorio(idSale, "Debes ingresar el id para reconstruir venta");
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado para reconstruir venta");
        ValidadorArgumento.validarObligatorio(cliente, "Debes ingresar el cliente para reconstruir venta");
        ValidadorArgumento.validarObligatorio(valorVenta, "Debes ingresar el valor de venta para reconstruir venta");
        ValidadorArgumento.validarObligatorio(profitVenta, "Debes ingresar el profit venta para reconstruir venta");
        ValidadorArgumento.validarObligatorio(marginProfitVenta, "Debes ingresar el margen de profit de venta para reconstruir venta");
        ValidadorArgumento.validarObligatorio(tipoVenta, "Debes ingresar el tipo de venta para reconstruir venta");
        ValidadorArgumento.validarObligatorio(fechaVenta, "Debes ingresar la fecha de venta para reconstruir venta");
        ValidadorArgumento.validarObligatorio(estadoVenta, "Debes ingresar el estado de venta para reconstruir venta");
        return new Sale(idSale, employee, cliente, valorVenta, profitVenta, marginProfitVenta, tipoVenta, fechaVenta, estadoVenta);
    }

    public Sale(DataDTOEmployee employee, Cliente cliente, String tipoVenta) {
        this.employee = employee;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.profitVenta = BigDecimal.valueOf(0);
        this.valorVenta = BigDecimal.valueOf(0);
        gananciaProfitMargin();
    }

    public static Sale crear(DataDTOEmployee employee, Cliente cliente, String tipoVenta) {
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado para crear venta");
        ValidadorArgumento.validarObligatorio(cliente, "Debes ingresar el cliente para crear venta");
        ValidadorArgumento.validarObligatorio(tipoVenta, "Debes ingresar el tipo de venta para crear venta");
        return new Sale(employee, cliente, tipoVenta);
    }

    private void gananciaProfitMargin(){
        if (this.profitVenta.equals(BigDecimal.ZERO)){
            this.marginProfitVenta = "0%";
        }else{
            this.marginProfitVenta = this.getProfitVenta().divide(this.getValorVenta(), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)) + "%";
        }
    }

    public Long getIdSale() {
        return idSale;
    }

    public DataDTOEmployee getEmployee() {
        return employee;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorVenta() {
        return valorVenta;
    }

    public BigDecimal getProfitVenta() {
        return profitVenta;
    }

    public String getMarginProfitVenta() {
        return marginProfitVenta;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }
}
