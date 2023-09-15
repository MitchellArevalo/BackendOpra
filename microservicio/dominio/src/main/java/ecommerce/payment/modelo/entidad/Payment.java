package ecommerce.payment.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.sales.modelo.entidad.Sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private Sale sale;
    private BigDecimal priceToPay;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime paymentDate;

    public Payment(Long id, Sale sale, BigDecimal priceToPay, LocalDateTime paymentDate) {
        this.id = id;
        this.sale = sale;
        this.priceToPay = priceToPay;
        this.paymentDate = paymentDate;
    }
    public static Payment reconstruir(Long id, Sale sale, BigDecimal priceToPay, LocalDateTime paymentDate) {
        ValidadorArgumento.validarObligatorio(id,"El valor del id del pago se debe ingresar para reconstruir");
        ValidadorArgumento.validarObligatorio(sale,"El valor de la venta a pagar se debe ingresar para reconstruir");
        ValidadorArgumento.validarObligatorio(priceToPay,"El valor del priceToPay del pago se debe ingresar para reconstruir");
        ValidadorArgumento.validarObligatorio(paymentDate,"El valor del paymentDate del pago se debe ingresar para reconstruir");
        return new Payment(id, sale, priceToPay, paymentDate);
    }
    public Payment(Sale sale, BigDecimal priceToPay) {
        this.sale = sale;
        this.priceToPay = priceToPay;
    }
    public static Payment crear(Sale sale, BigDecimal priceToPay) {
        ValidadorArgumento.validarObligatorio(sale,"El valor de la venta a pagar se debe ingresar para crear");
        ValidadorArgumento.validarObligatorio(priceToPay,"El valor del priceToPay del pago se debe ingresar para crear");
        return new Payment(sale, priceToPay);
    }

    public Long getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public BigDecimal getPriceToPay() {
        return priceToPay;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
}
