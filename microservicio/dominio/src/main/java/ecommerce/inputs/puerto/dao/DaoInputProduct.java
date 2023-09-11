package ecommerce.inputs.puerto.dao;

import ecommerce.inputs.modelo.entidad.InputProduct;

import java.util.List;

public interface DaoInputProduct {
    InputProduct getByID(Long id);
    List<InputProduct> getAllInputs();

    List<InputProduct> getAllInputsByIdProduct(Long id);

}
