package mx.xpd.cfdi.repo;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import mx.xpd.cfdi.domain.BannerPopup;

@Repository
public class BannerPopupImpl implements BannerPopupDao {
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	@Override
	public BannerPopup findActive() {
		String strQuery = "from BannerPopup where activo = '1' order by id desc";
		Query query = em.createQuery(strQuery);
		List<BannerPopup> results = (List<BannerPopup>)query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
}
