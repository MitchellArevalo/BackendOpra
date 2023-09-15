package ecommerce.inputsproducts.adaptador.repositorio;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class MapeoInputProduct implements RowMapper<InputProduct>, MapperResult {
    private final DaoProduct daoProduct;
    private final DaoEmployee daoEmployee;

    public MapeoInputProduct(DaoProduct daoProduct, DaoEmployee daoEmployee) {
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
    public InputProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idInput = rs.getLong("id");
        Long idEmployee = rs.getLong("employee_id");
        Long idProduct = rs.getLong("product_id");
        BigDecimal costProduct = rs.getBigDecimal("input_product_cost");
        BigDecimal quantityProduct = rs.getBigDecimal("input_quantity");
        String description = rs.getString("input_description");
        LocalDate dateInput = rs.getDate("input_date").toLocalDate();
        return InputProduct.reconstruir(idInput, obtenerEmployee(idEmployee), obtenerProducto(idProduct), costProduct,quantityProduct,description,
                dateInput);
    }
}
