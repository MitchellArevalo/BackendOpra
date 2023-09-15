package ecommerce.payment.servicio;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.repositorio.RepositorioPayment;
import ecommerce.sales.puerto.repositorio.RepositorioSale;

public class ServiciosPayment {
    private final RepositorioPayment repositorioPayment;
    private final RepositorioSale repositorioSale;

    public ServiciosPayment(RepositorioPayment repositorioPayment, RepositorioSale repositorioSale) {
        this.repositorioPayment = repositorioPayment;
        this.repositorioSale = repositorioSale;
    }

    public Long crear(Payment payment){
        actualizarEstadoDeVenta(payment);
        return this.repositorioPayment.crear(payment);
    }

    private void actualizarEstadoDeVenta(Payment payment){
        int comparacion = payment.getPriceToPay().compareTo(payment.getSale().getValorVenta());
        if(comparacion >= 0){
            this.repositorioSale.modificarEstadoVenta(payment.getSale().getIdSale(), "APROBADA");
        }
        else {
            this.repositorioSale.modificarEstadoVenta(payment.getSale().getIdSale(), "RECHAZADA");
        }


    }
}
