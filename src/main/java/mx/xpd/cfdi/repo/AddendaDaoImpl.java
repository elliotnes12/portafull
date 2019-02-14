package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.ConfiguracionCFDI;

@Repository
@Transactional
public class AddendaDaoImpl {
	
    @Autowired
    @Qualifier(value = "entityManager")
    private EntityManager em;
    private String tenantId;

	
}
