package ecommerce.payment.comando;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ComandoSolicitudCrearPayment {
    private Long idSale;
    private BigDecimal priceToPay;
}
