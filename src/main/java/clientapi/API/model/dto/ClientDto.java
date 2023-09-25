package clientapi.API.model.dto;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class ClientDto implements Serializable {

    private Integer idClient;
    private String name;
    private String surname;
    private String email;
    private Date registerDate;
}