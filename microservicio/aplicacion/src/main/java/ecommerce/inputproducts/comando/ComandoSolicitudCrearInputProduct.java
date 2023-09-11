package ecommerce.inputproducts.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearInputProduct {
    private Long idEmployee;
    private Long idProduct;
    private BigDecimal costProduct;
    private BigDecimal quantityProduct;
    private String description;

}
