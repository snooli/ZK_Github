package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLFondsFindAPI;
import dots.clb.common.entities.Fonds;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.helpers.EntityHelper;

public class FondsFindAPI {

	public static FondsBean findBySystemId(EntityManager em, String systemId) {

		Fonds fonds = LLFondsFindAPI.findBySystemId(em, systemId);

		FondsBean fondsBean = (FondsBean) EntityHelper.entityToBean(fonds,
				FondsBean.class);

		return fondsBean;
	}

	public static List<FondsBean> findAll(EntityManager em) {

		List<Fonds> fonds = LLFondsFindAPI.findAll(em);

		List<FondsBean> fondsBeans = EntityHelper.entitiesToBeans(fonds,
				FondsBean.class);

		return fondsBeans;
	}

	public static List<FondsBean> findTopLevel(EntityManager em) {

		List<Fonds> fonds = LLFondsFindAPI.findTopLevel(em);

		List<FondsBean> fondsBeans = EntityHelper.entitiesToBeans(fonds,
				FondsBean.class);

		return fondsBeans;
	}

	public static List<FondsBean> findAllByTitle(EntityManager em, String title) {

		List<Fonds> fonds = LLFondsFindAPI.findAllByTitle(em, title);

		List<FondsBean> fondsBeans = EntityHelper.entitiesToBeans(fonds,
				FondsBean.class);

		return fondsBeans;
	}

	public static List<FondsBean> findAllByDescription(EntityManager em,
			String description) {

		List<Fonds> fonds = LLFondsFindAPI
				.findAllByDescription(em, description);

		List<FondsBean> fondsBeans = EntityHelper.entitiesToBeans(fonds,
				FondsBean.class);

		return fondsBeans;
	}

	public static List<FondsBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<Fonds> fonds = LLFondsFindAPI.findAllByCreatedBy(em, createdBy);

		List<FondsBean> fondsBeans = EntityHelper.entitiesToBeans(fonds,
				FondsBean.class);

		return fondsBeans;
	}

}
