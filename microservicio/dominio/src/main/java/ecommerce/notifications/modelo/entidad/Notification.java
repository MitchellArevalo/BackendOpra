package ecommerce.notifications.modelo.entidad;

import ecommerce.employees.modelo.entidad.Employee;

public class Notification {
    private Long id;
    private Employee employee;
    private String subject;
    private String message;
    private boolean readed;

}
