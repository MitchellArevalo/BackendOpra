package ecommerce.notifications.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudActualizarNotification {
    private Long idEmployee;
    private String subject;
    private String message;
    private boolean readed;
}
