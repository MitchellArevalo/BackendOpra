package ecommerce.notifications.comando.fabrica;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.notifications.comando.ComandoSolicitudActualizarNotification;
import ecommerce.notifications.comando.ComandoSolicitudCrearNotification;
import ecommerce.notifications.modelo.entidad.Notification;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudActualizarNotificacion {
    private final DaoEmployee daoEmployee;

    public GenerarSolicitudActualizarNotificacion(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }
    private Employee obtenerEmployee(Long id){
        return this.daoEmployee.getEmployee(id);
    }
    public Notification generate(ComandoSolicitudActualizarNotification comandoSolicitudActualizarNotification){
        return Notification.actualizar(obtenerEmployee(comandoSolicitudActualizarNotification.getIdEmployee()),
                comandoSolicitudActualizarNotification.getSubject(), comandoSolicitudActualizarNotification.getMessage(),
                comandoSolicitudActualizarNotification.isReaded());
    }
}
