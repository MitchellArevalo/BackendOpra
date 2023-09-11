package ecommerce.outputproducts.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.productos.modelo.entidad.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OutputProduct {
    private Long idOutput;
    private Employee employee;
    private Product product;
    private BigDecimal quantityProduct;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOutput;


    public OutputProduct(Long idOutput, Employee employee, Product product,BigDecimal quantityProduct, String description, LocalDate dateOutput) {
        this.idOutput = idOutput;
        this.employee = employee;
        this.product = product;
        this.quantityProduct = quantityProduct;
        this.description = description;
        this.dateOutput = dateOutput;
    }
    public static OutputProduct reconstruir(Long idOutput, Employee employee, Product product, BigDecimal quantityProduct, String description, LocalDate dateOutput) {
        ValidadorArgumento.validarObligatorio(idOutput, "Debes ingresar el id del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(quantityProduct, "Debes ingresar la cantidad del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar la descripcion del input para reconstruir objeto");
        ValidadorArgumento.validarObligatorio(dateOutput, "Debes ingresar la fecha del input para reconstruir objeto");
        return new OutputProduct(idOutput, employee, product, quantityProduct, description,dateOutput);
    }

    public OutputProduct(Employee employee, Product product, BigDecimal quantityProduct, String description) {
        this.employee = employee;
        this.product = product;
        this.quantityProduct = quantityProduct;
        this.description = description;
        this.dateOutput = LocalDate.now();
    }
    public static OutputProduct crear(Employee employee, Product product, BigDecimal quantityProduct, String description) {
        ValidadorArgumento.validarObligatorio(employee, "Debes ingresar el empleado del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(quantityProduct, "Debes ingresar la cantidad del input para crear el objeto");
        ValidadorArgumento.validarObligatorio(description, "Debes ingresar la descripcion del input para crear el objeto");
        return new OutputProduct(employee, product, quantityProduct, description);
    }


    public Long getIdOutput() {
        return idOutput;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Product getProduct() {
        return product;
    }


    public BigDecimal getQuantityProduct() {
        return quantityProduct;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateOutput() {
        return dateOutput;
    }
}
