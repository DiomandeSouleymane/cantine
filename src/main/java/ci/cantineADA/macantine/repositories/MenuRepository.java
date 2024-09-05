package ci.cantineADA.macantine.repositories;

import ci.cantineADA.macantine.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

