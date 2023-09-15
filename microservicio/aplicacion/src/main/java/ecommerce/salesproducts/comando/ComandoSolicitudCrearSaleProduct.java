package ecommerce.salesproducts.comando;


import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ComandoSolicitudCrearSaleProduct {
    private Long idSale;
    private Long idProduct;
    private Integer saleProductQuantity;
    private BigDecimal saleProductSalesPrice;
}
