package ci.cantineADA.macantine.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_menu;

    private Date creationDate;

    @Transient
    private Plat plat;
}
