package ecommerce.module.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudActualizarModulo {
    private String name;
    private boolean edit;
    private boolean view;
    private boolean create;
    private boolean delete;

}
