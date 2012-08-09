package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLFondsCreatorFindAPI;
import dots.clb.common.entities.FondsCreator;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.helpers.EntityHelper;

public class FondsCreatorFindAPI {

	public static FondsCreatorBean findBySystemId(EntityManager em,
			String systemId) {

		FondsCreator fondsCreator = LLFondsCreatorFindAPI.findBySystemId(em,
				systemId);

		FondsCreatorBean fondsCreatorBean = (FondsCreatorBean) EntityHelper
				.entityToBean(fondsCreator, FondsCreatorBean.class);

		return fondsCreatorBean;
	}

	public static FondsCreatorBean findByFondsCreatorId(EntityManager em,
			String fondsCreatorId) {

		FondsCreator fondsCreator = LLFondsCreatorFindAPI.findByFondsCreatorId(
				em, fondsCreatorId);

		FondsCreatorBean fondsCreatorBean = (FondsCreatorBean) EntityHelper
				.entityToBean(fondsCreator, FondsCreatorBean.class);

		return fondsCreatorBean;
	}

	public static List<FondsCreatorBean> findAll(EntityManager em) {

		List<FondsCreator> fondsCreators = LLFondsCreatorFindAPI.findAll(em);

		List<FondsCreatorBean> fondsCreatorBeans = EntityHelper
				.entitiesToBeans(fondsCreators, FondsCreatorBean.class);

		return fondsCreatorBeans;
	}

	public static List<FondsCreatorBean> findAllByFondsCreatorName(
			EntityManager em, String fondsCreatorName) {

		List<FondsCreator> fondsCreators = LLFondsCreatorFindAPI
				.findAllByFondsCreatorName(em, fondsCreatorName);

		List<FondsCreatorBean> fondsCreatorBeans = EntityHelper
				.entitiesToBeans(fondsCreators, FondsCreatorBean.class);

		return fondsCreatorBeans;
	}

	public static List<FondsCreatorBean> findAllByDescription(EntityManager em,
			String description) {

		List<FondsCreator> fondsCreators = LLFondsCreatorFindAPI
				.findAllByDescription(em, description);

		List<FondsCreatorBean> fondsCreatorBeans = EntityHelper
				.entitiesToBeans(fondsCreators, FondsCreatorBean.class);

		return fondsCreatorBeans;
	}

}
