package ecommerce.inputproducts.comando.fabrica;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.inputproducts.comando.ComandoSolicitudCrearInputProduct;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearInputProduct {
    private final DaoProduct daoProduct;
    private final DaoEmployee daoEmployee;

    public GenerarSolicitudCrearInputProduct(DaoProduct daoProduct, DaoEmployee daoEmployee) {
        this.daoProduct = daoProduct;
        this.daoEmployee = daoEmployee;
    }

    private Product obtenerProducto(Long id){
        return this.daoProduct.getByID(id);
    }

    private Employee obtenerEmployee(Long id){
        return this.daoEmployee.getEmployee(id);
    }

    public InputProduct generar(ComandoSolicitudCrearInputProduct comandoSolicitudCrearInputProduct){
        return InputProduct.crear(obtenerEmployee(comandoSolicitudCrearInputProduct.getIdEmployee()), obtenerProducto(comandoSolicitudCrearInputProduct.getIdProduct()),
                comandoSolicitudCrearInputProduct.getCostProduct(), comandoSolicitudCrearInputProduct.getQuantityProduct(), comandoSolicitudCrearInputProduct.getDescription());
    }
}
