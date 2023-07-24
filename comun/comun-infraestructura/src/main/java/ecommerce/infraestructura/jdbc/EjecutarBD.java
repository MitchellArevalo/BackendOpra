package ecommerce.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}