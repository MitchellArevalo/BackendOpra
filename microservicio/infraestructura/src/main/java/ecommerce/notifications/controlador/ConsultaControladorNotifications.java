package ecommerce.notifications.controlador;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.notifications.consulta.ManejadorObtenerNotification;
import ecommerce.notifications.consulta.ManejadorObtenerNotificationsByEmployee;
import ecommerce.notifications.modelo.entidad.Notification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@Tag(name = "Controlador consulta notifications")
public class ConsultaControladorNotifications {

    private final ManejadorObtenerNotification manejadorObtenerNotification;
    private final ManejadorObtenerNotificationsByEmployee notificationsByEmployee;

    public ConsultaControladorNotifications(ManejadorObtenerNotification manejadorObtenerNotification, ManejadorObtenerNotificationsByEmployee notificationsByEmployee) {
        this.manejadorObtenerNotification = manejadorObtenerNotification;
        this.notificationsByEmployee = notificationsByEmployee;
    }

    @GetMapping("/employee/{employee_id}")
    @Operation(summary = "Visualizar notificaciones por empleado",
            description = "Metodo utilizado para consultar las notificaciones")
    public List<Notification> getNotificationsByEmployee(@PathVariable("employee_id") Long id){
        return notificationsByEmployee.ejecutar(id);
    }
    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable("id") Long id){
        return manejadorObtenerNotification.ejecutar(id);
    }

}
