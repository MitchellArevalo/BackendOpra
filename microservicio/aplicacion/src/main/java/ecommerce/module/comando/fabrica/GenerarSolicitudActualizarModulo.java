package ecommerce.module.comando.fabrica;

import ecommerce.module.comando.ComandoSolicitudActualizarModulo;
import ecommerce.modules.modelo.entidad.Modulo;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudActualizarModulo {
    public Modulo generar(ComandoSolicitudActualizarModulo comandoSolicitudActualizarModulo){
        return Modulo.actualizar(comandoSolicitudActualizarModulo.getName(),
                comandoSolicitudActualizarModulo.isEdit(),
                comandoSolicitudActualizarModulo.isView(),
                comandoSolicitudActualizarModulo.isCreate(),
                comandoSolicitudActualizarModulo.isDelete()
        );
    }

}
