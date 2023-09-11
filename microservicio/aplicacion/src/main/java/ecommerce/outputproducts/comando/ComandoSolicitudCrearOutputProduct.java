package ecommerce.outputproducts.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearOutputProduct {
    private Long idEmployee;
    private Long idProduct;
    private BigDecimal quantityProduct;
    private String description;

}
