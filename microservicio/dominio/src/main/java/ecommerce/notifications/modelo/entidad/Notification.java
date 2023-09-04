package ecommerce.notifications.modelo.entidad;

import ecommerce.dominio.ValidadorArgumento;
import ecommerce.employees.modelo.entidad.Employee;

public class Notification {
    private Long id;
    private Employee employee;
    private String subject;
    private String message;
    private boolean readed;

    public Notification(Long id, String subject, String message, boolean readed) {
        this.id = id;
        this.subject = subject;
        this.message = message;
        this.readed = readed;
    }
    public Notification(Long id, Employee employee, String subject, String message, boolean readed) {
        this.id = id;
        this.employee = employee;
        this.subject = subject;
        this.message = message;
        this.readed = readed;
    }
    public static Notification reconstruir(Long id, Employee employee, String subject, String message, boolean readed) {
        ValidadorArgumento.validarObligatorio(id, "Debes ingresar el id para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(subject, "Debes ingresar el titulo para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(message, "Debes ingresar el mensaje para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(readed, "Debes ingresar el estado de leido para reconstruir notificacion");
        return new Notification(id, employee, subject, message, readed);
    }

    public Notification(Employee employee, String subject, String message, boolean readed) {
        this.employee = employee;
        this.subject = subject;
        this.message = message;
        this.readed = readed;
    }

    public static Notification actualizar(Employee employee, String subject, String message, boolean readed) {
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(subject, "Debes ingresar el titulo para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(message, "Debes ingresar el mensaje para reconstruir notificacion");
        ValidadorArgumento.validarObligatorio(readed, "Debes ingresar el estado de leido para reconstruir notificacion");
        return new Notification(employee, subject, message, readed);
    }

    public Notification(Employee employee, String subject, String message) {
        this.employee = employee;
        this.subject = subject;
        this.message = message;
    }

    public static Notification crear(Employee employee, String subject, String message) {
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el id para crear la notificacion");
        ValidadorArgumento.validarObligatorio(subject, "Debes ingresar el titulo para crear la notificacion");
        ValidadorArgumento.validarObligatorio(message, "Debes ingresar el mensaje para crear la notificacion");
        return new Notification(employee, subject, message);
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public boolean isReaded() {
        return readed;
    }
}
