package ecommerce.outputsproducts.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.repositorio.RepositorioInputProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOutputProductPostgres implements RepositorioInputProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioOutputProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "outputproducts", value = "addoutput")
    private static String sqlCrear;


    @Override
    public Long crear(InputProduct inputProduct) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_id", inputProduct.getEmployee().getIdEmployee());
        parameterSource.addValue("product_id", inputProduct.getProduct().getId());
        parameterSource.addValue("input_product_cost", inputProduct.getCostProduct());
        parameterSource.addValue("input_quantity", inputProduct.getQuantityProduct());
        parameterSource.addValue("input_description", inputProduct.getDescription());
        parameterSource.addValue("input_date", inputProduct.getDateInput());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }
}
