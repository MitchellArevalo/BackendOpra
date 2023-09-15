package ecommerce.payment.puerto.repositorio;

import ecommerce.payment.modelo.entidad.Payment;

public interface RepositorioPayment {
    Long crear(Payment payment);
}
