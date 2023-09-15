package ecommerce.sales.adaptador.repositorio;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.dao.DaoCliente;
import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.sales.modelo.entidad.Sale;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class MapeoSale implements RowMapper<Sale>, MapperResult {
    private final DaoCliente daoCliente;
    private final DaoEmployee daoEmployee;

    public MapeoSale(DaoCliente daoCliente, DaoEmployee daoEmployee) {
        this.daoCliente = daoCliente;
        this.daoEmployee = daoEmployee;
    }

    private Cliente obtenerCliente(Long id){
        return this.daoCliente.getClienteById(id);
    }
    private DataDTOEmployee obtenerEmpleado(Long id){
        return this.daoEmployee.getDTOEmployee(id);
    }

    @Override
    public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idSale  = rs.getLong("id");
        Long idEmployee = rs.getLong("employee_id");
        Long idCliente = rs.getLong("client_id");
        BigDecimal valorVenta = rs.getBigDecimal("sale_amount");
        BigDecimal profitVenta = rs.getBigDecimal("sale_profit");
        String marginProfitVenta = rs.getString("sale_margin_profit");
        String tipoVenta = rs.getString("sale_type");
        LocalDateTime fechaVenta = rs.getTimestamp("sale_date").toLocalDateTime();
        String estadoVenta = rs.getString("sale_status");
        return Sale.reconstruir(idSale, obtenerEmpleado(idEmployee), obtenerCliente(idCliente), valorVenta, profitVenta, marginProfitVenta,
                tipoVenta, fechaVenta, estadoVenta);
    }
}
