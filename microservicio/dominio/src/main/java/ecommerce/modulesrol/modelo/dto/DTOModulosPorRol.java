package ecommerce.modulesrol.modelo.dto;

import ecommerce.modules.modelo.entidad.Modulo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DTOModulosPorRol {
    private List<Modulo> listadoDeModulos;
}
