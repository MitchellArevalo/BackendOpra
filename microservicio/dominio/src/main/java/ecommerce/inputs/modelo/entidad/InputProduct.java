package ecommerce.inputs.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.productos.modelo.entidad.Product;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InputProduct {
    private Long idInput;
    private Employee employee;
    private Product product;
    private BigDecimal costProduct;
    private BigDecimal quantityProduct;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateInput;


    public InputProduct(Long idInput, Employee employee, Product product, BigDecimal costProduct, BigDecimal quantityProduct, String description, LocalDate dateInput) {
        this.idInput = idInput;
        this.employee = employee;
        this.product = product;
        this.costProduct = costProduct;
        this.quantityProduct = quantityProduct;
        this.description = description;
        this.dateInput = dateInput;
    }
    public static InputProduct reconstruir(Long idInput, Employee employee, Product product, BigDecimal costProduct, BigDecimal quantityProduct, String description, LocalDate dateInput) {
        ValidadorArgumento.validarObligatorio(idInput, "Debes ingresar el id del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(costProduct, "Debes ingresar el coste del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(quantityProduct, "Debes ingresar la cantidad del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar la descripcion del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(dateInput, "Debes ingresar la fecha del input para reconstruir objeto");
        return new InputProduct(idInput, employee, product,costProduct, quantityProduct, description,dateInput);
    }

    public InputProduct(Employee employee, Product product, BigDecimal costProduct, BigDecimal quantityProduct, String description) {
        this.employee = employee;
        this.product = product;
        this.costProduct = costProduct;
        this.quantityProduct = quantityProduct;
        this.description = description;
        this.dateInput = LocalDate.now();
    }
    public static InputProduct crear(Employee employee, Product product, BigDecimal costProduct, BigDecimal quantityProduct, String description) {
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(costProduct, "Debes ingresar el coste del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(quantityProduct, "Debes ingresar la cantidad del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar la descripcion del input para crear el objeto");
        return new InputProduct(employee, product, costProduct, quantityProduct, description);
    }



    public Long getIdInput() {
        return idInput;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getCostProduct() {
        return costProduct;
    }

    public BigDecimal getQuantityProduct() {
        return quantityProduct;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateInput() {
        return dateInput;
    }
}
