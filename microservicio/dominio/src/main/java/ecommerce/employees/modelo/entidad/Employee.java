package ecommerce.employees.modelo.entidad;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.roles.modelo.entidad.Rol;

public class Employee {
    private Long idEmployee;
    private Rol rol;
    private String name;
    private String email;
    private String password;
    private String document;
    private String address;
    private String phoneNumber;
    private String avatar;
    private boolean active;
    private boolean notificationsEmail;

    public Employee(Long idEmployee, Rol rol, String name, String email, String password, String document, String address, String phoneNumber, String avatar, boolean active, boolean notificationsEmail) {
        this.idEmployee = idEmployee;
        this.rol = rol;
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.active = active;
        this.notificationsEmail = notificationsEmail;
    }



    public Employee(Rol rol, String name, String email, String password, String document, String address, String phoneNumber, String avatar) {
        this.rol = rol;
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
    }

    public Employee(Rol rol, String name, String email, String document, String address, String phoneNumber, String avatar, boolean active, boolean notificationsEmail) {
        this.rol = rol;
        this.name = name;
        this.email = email;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.active = active;
        this.notificationsEmail = notificationsEmail;
    }

    public static Employee reconstruir(Long idEmployee, Rol rol, String name, String email, String password, String document, String address, String phoneNumber, String avatar, boolean active, boolean notificationsEmail){
        ValidadorArgumento.validarObligatorio(idEmployee, "Debes ingresar el id del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el name del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar el email del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(password, "Debes ingresar el password del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(document, "Debes ingresar el document del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(address, "Debes ingresar el address del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(phoneNumber, "Debes ingresar el phoneNumber del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(avatar, "Debes ingresar el avatar del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(active, "Debes ingresar el active del empleado para reconstruir");
        ValidadorArgumento.validarObligatorio(notificationsEmail, "Debes ingresar el notificationEmail del empleado para reconstruir");
        return new Employee(idEmployee, rol, name, email, password, document, address, phoneNumber, avatar, active, notificationsEmail);
    }

    public static Employee crear(Rol rol, String name, String email, String password, String document, String address, String phoneNumber, String avatar){
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el name del empleado para crear");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar el email del empleado para crear");
        ValidadorArgumento.validarObligatorio(password, "Debes ingresar el password del empleado para crear");
        ValidadorArgumento.validarObligatorio(document, "Debes ingresar el document del empleado para crear");
        ValidadorArgumento.validarObligatorio(address, "Debes ingresar el address del empleado para crear");
        ValidadorArgumento.validarObligatorio(phoneNumber, "Debes ingresar el phoneNumber del empleado para crear");
        ValidadorArgumento.validarObligatorio(avatar, "Debes ingresar el avatar del empleado para crear");
        return new Employee(rol, name, email, password, document, address, phoneNumber, avatar);
    }

    public static Employee actualizar(Rol rol, String name, String email, String document, String address, String phoneNumber, String avatar, boolean active, boolean notificationsEmail){
        ValidadorArgumento.validarObligatorio(name, "Debes ingresar el name del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(email, "Debes ingresar el email del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(document, "Debes ingresar el document del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(address, "Debes ingresar el address del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(phoneNumber, "Debes ingresar el phoneNumber del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(avatar, "Debes ingresar el avatar del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(active, "Debes ingresar el active del empleado para actualizar");
        ValidadorArgumento.validarObligatorio(notificationsEmail, "Debes ingresar el notificationEmail del empleado para actualizar");
        return new Employee(rol, name, email, document, address, phoneNumber, avatar, active, notificationsEmail);
    }


    public Long getIdEmployee() {
        return idEmployee;
    }

    public Rol getRol() {
        return rol;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isNotificationsEmail() {
        return notificationsEmail;
    }
    public boolean isActive() {
        return active;
    }
}
