package ecommerce.outputsproducts.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.repositorio.RepositorioInputProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.repositorio.RepositorioOutputProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOutputProductPostgres implements RepositorioOutputProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    public RepositorioOutputProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "outputproducts", value = "addoutput")
    private static String sqlCrear;

    @Override
    public Long crear(OutputProduct outputProduct) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_id", outputProduct.getEmployee().getIdEmployee());
        parameterSource.addValue("product_id", outputProduct.getProduct().getId());
        parameterSource.addValue("output_quantity", outputProduct.getQuantityProduct());
        parameterSource.addValue("output_description", outputProduct.getDescription());
        parameterSource.addValue("output_date", outputProduct.getDateOutput());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }
}
