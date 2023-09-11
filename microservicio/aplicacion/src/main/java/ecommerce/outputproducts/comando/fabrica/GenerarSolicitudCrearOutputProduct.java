package ecommerce.outputproducts.comando.fabrica;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.inputproducts.comando.ComandoSolicitudCrearInputProduct;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.outputproducts.comando.ComandoSolicitudCrearOutputProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearOutputProduct {
    private final DaoProduct daoProduct;
    private final DaoEmployee daoEmployee;

    public GenerarSolicitudCrearOutputProduct(DaoProduct daoProduct, DaoEmployee daoEmployee) {
        this.daoProduct = daoProduct;
        this.daoEmployee = daoEmployee;
    }

    private Product obtenerProducto(Long id){
        return this.daoProduct.getByID(id);
    }

    private Employee obtenerEmployee(Long id){
        return this.daoEmployee.getEmployee(id);
    }

    public OutputProduct generar(ComandoSolicitudCrearOutputProduct comando){
        return OutputProduct.crear(obtenerEmployee(comando.getIdEmployee()), obtenerProducto(comando.getIdProduct()),
                comando.getQuantityProduct(), comando.getDescription());
    }
}
