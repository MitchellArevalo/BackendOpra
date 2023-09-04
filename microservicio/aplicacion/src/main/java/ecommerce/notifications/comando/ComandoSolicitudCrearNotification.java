package ecommerce.notifications.comando;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudCrearNotification {
    private Long idEmployee;
    private String subject;
    private String message;
}
