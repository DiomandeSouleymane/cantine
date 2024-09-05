package ci.cantineADA.macantine.services.dto;

import ci.cantineADA.macantine.models.Plat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Setter
@Getter
@Slf4j
@ToString
public class MenuDTO {

    private Long id_menu;

    private Date creationDate;

    private Plat plat;

}
