package ecommerce.module.comando.fabrica;

import ecommerce.module.comando.ComandoSolicitudCrearModulo;
import ecommerce.modulos.modelo.entidad.Modulo;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearModulo {
    public Modulo crear(ComandoSolicitudCrearModulo comandoSolicitudCrearModulo){
        return Modulo.crear(comandoSolicitudCrearModulo.getName(),
                comandoSolicitudCrearModulo.isEdit(),
                comandoSolicitudCrearModulo.isView(),
                comandoSolicitudCrearModulo.isCreate(),
                comandoSolicitudCrearModulo.isDelete()
                );
    }
}
