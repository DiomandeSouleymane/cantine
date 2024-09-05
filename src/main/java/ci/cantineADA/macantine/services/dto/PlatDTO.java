package ci.cantineADA.macantine.services.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@ToString
public class PlatDTO {

    private Long id_plat;

    private String name;

    private String summary;

}
