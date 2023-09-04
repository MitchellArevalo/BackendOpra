package ecommerce.notifications.comando.fabrica;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.notifications.comando.ComandoSolicitudCrearNotification;
import ecommerce.notifications.modelo.entidad.Notification;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearNotification {
    private final DaoEmployee daoEmployee;

    public GenerarSolicitudCrearNotification(DaoEmployee daoEmployee) {
        this.daoEmployee = daoEmployee;
    }

    private Employee obtenerEmployee(Long id){
        return this.daoEmployee.getEmployee(id);
    }
    public Notification generate(ComandoSolicitudCrearNotification comandoSolicitudCrearNotification){
        return Notification.crear(obtenerEmployee(comandoSolicitudCrearNotification.getIdEmployee()),
                comandoSolicitudCrearNotification.getSubject(), comandoSolicitudCrearNotification.getMessage());
    }

}
