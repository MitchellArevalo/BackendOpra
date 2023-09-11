package ecommerce.outputproducts.puerto.dao;

import ecommerce.outputproducts.modelo.entidad.OutputProduct;

import java.util.List;

public interface DaoOutputProduct {
    OutputProduct getByID(Long id);
    List<OutputProduct> getAllOutputs();

    List<OutputProduct> getAllOutputsByIdProduct(Long id);

}
