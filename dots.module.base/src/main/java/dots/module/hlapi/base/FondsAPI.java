package dots.module.hlapi.base;

import java.util.List;
import java.util.Set;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;

import dots.clb.common.api.base.LLFondsAPI;
import dots.clb.common.api.find.LLFondsCreatorFindAPI;
import dots.clb.common.api.find.LLFondsFindAPI;
import dots.clb.common.constants.N5Status;
import dots.clb.common.entities.Fonds;
import dots.clb.common.entities.FondsCreator;
import dots.clb.common.entities.Series;
import dots.module.base.beans.Result;
import dots.module.base.entitybeans.FondsBean;
import dots.module.base.entitybeans.FondsCreatorBean;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.base.helpers.EntityHelper;

public class FondsAPI {

	/** Create **/

	public static Result create(EntityManager em, String fondsCreatorId,
			String parentFondsSystemId, String title, String description,
			String documentMedium, String createdBy) {

		// no fonds creator specified
		if (fondsCreatorId == null) {
			throw new EJBException();
		}

		// get the fonds creator
		FondsCreator fondsCreator = LLFondsCreatorFindAPI.findByFondsCreatorId(
				em, fondsCreatorId);

		// specified fonds creator does not exist
		if (fondsCreator == null) {
			throw new EJBException();
		}

		// no parent fonds specified
		if (parentFondsSystemId == null) {

			String fondsSystemId = new LLFondsAPI().create(em, title,
					description, N5Status.FondsStatus.CREATED, documentMedium,
					createdBy);

			// get the newly created fonds
			Fonds fonds = LLFondsFindAPI.findBySystemId(em, fondsSystemId);

			// set its fonds creator
			new LLFondsAPI().addFondsCreator(fonds, fondsCreator);

			return new Result(true, fondsSystemId);

		} else { // parent fonds specified

			// get the parent fonds
			Fonds parentFonds = LLFondsFindAPI.findBySystemId(em,
					parentFondsSystemId);

			// specified parent fonds does not exist
			if (parentFonds == null) {
				throw new EJBException();
			}

			// create the new fonds
			String fondsSystemId = new LLFondsAPI().create(em, title,
					description, N5Status.FondsStatus.CREATED, documentMedium,
					createdBy);

			// get the newly created fonds
			Fonds childFonds = LLFondsFindAPI.findBySystemId(em, fondsSystemId);

			// add it the the parent fonds
			new LLFondsAPI().addChildFonds(parentFonds, childFonds);

			// set the fonds creator of the new fonds
			new LLFondsAPI().addFondsCreator(childFonds, fondsCreator);

			return new Result(true, fondsSystemId);
		}

	}

	/** Delete **/

	public static Result delete(EntityManager em, String systemId) {
		// TODO
		return null;
	}

	/** Get **/

	public static List<FondsBean> getChildFonds(EntityManager em,
			String systemId) {

		Fonds fonds = LLFondsFindAPI.findBySystemId(em, systemId);

		List<FondsBean> childFonds = EntityHelper.entitiesToBeans(
				fonds.getReferenceChildFonds(), FondsBean.class);

		return childFonds;
	}

	public static FondsBean getParentFonds(EntityManager em, String systemId) {

		Fonds fonds = LLFondsFindAPI.findBySystemId(em, systemId);

		FondsBean parentFonds = (FondsBean) EntityHelper.entityToBean(
				fonds.getReferenceParentFonds(), FondsBean.class);

		return parentFonds;
	}

	public static List<SeriesBean> getSeries(EntityManager em, String systemId) {

		Fonds fonds = LLFondsFindAPI.findBySystemId(em, systemId);

		Set<Series> series = fonds.getReferenceSeries();

		List<SeriesBean> seriesBeans = EntityHelper.entitiesToBeans(series,
				SeriesBean.class);

		return seriesBeans;
	}

	public static List<FondsCreatorBean> getFondsCreators(EntityManager em,
			String systemId) {

		Fonds fonds = LLFondsFindAPI.findBySystemId(em, systemId);

		Set<FondsCreator> fondsCreators = fonds.getReferenceFondsCreator();

		List<FondsCreatorBean> fondsCreatorsBeans = EntityHelper
				.entitiesToBeans(fondsCreators, FondsCreatorBean.class);

		return fondsCreatorsBeans;
	}

}
