package ecommerce.errorhandlers;

public class ExcepcionProductoSinStock extends RuntimeException {
    public ExcepcionProductoSinStock() {
        super();
    }

    public ExcepcionProductoSinStock(String message) {
        super(message);
    }

    public ExcepcionProductoSinStock(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionProductoSinStock(Throwable cause) {
        super(cause);
    }
}
