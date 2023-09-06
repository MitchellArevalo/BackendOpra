package ecommerce.productos.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearProduct {
    private String name;
    private Long idCategory;
    private String itemCode;
    private String size;
    private String description;
    private String image;
}
