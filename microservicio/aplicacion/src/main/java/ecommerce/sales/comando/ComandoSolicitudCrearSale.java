package ecommerce.sales.comando;
import lombok.Getter;

@Getter
public class ComandoSolicitudCrearSale {
    private Long idEmployee;
    private Long idCliente;
    private String tipoVenta;
}
