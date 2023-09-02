package ecommerce.module.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearModulo {
    private String name;
    private boolean edit;
    private boolean view;
    private boolean create;
    private boolean delete;
}
