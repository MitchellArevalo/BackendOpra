package ecommerce.outputsproducts.adaptador.repositorio;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class MapeoOutputProduct implements RowMapper<OutputProduct>, MapperResult {
    private final DaoProduct daoProduct;
    private final DaoEmployee daoEmployee;

    public MapeoOutputProduct(DaoProduct daoProduct, DaoEmployee daoEmployee) {
        this.daoProduct = daoProduct;
        this.daoEmployee = daoEmployee;
    }

    private Product obtenerProducto(Long id){
        return this.daoProduct.getByID(id);
    }
    private Employee obtenerEmployee(Long id){
        return this.daoEmployee.getEmployee(id);
    }

    @Override
    public OutputProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idOutput = rs.getLong("id");
        Long idEmployee = rs.getLong("employee_id");
        Long idProduct = rs.getLong("product_id");
        BigDecimal quantityProduct = rs.getBigDecimal("output_quantity");
        String description = rs.getString("ouput_description");
        LocalDate dateInput = rs.getDate("output_date").toLocalDate();
        return OutputProduct.reconstruir(idOutput, obtenerEmployee(idEmployee), obtenerProducto(idProduct),quantityProduct, description,
                dateInput);
    }
}
