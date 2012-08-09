package dots.module.hlapi.find;

import java.util.List;

import javax.persistence.EntityManager;

import dots.clb.common.api.find.LLSeriesFindAPI;
import dots.clb.common.entities.Series;
import dots.module.base.entitybeans.SeriesBean;
import dots.module.base.helpers.EntityHelper;

public class SeriesFindAPI {

	public static SeriesBean findBySystemId(EntityManager em, String systemId) {

		Series series = LLSeriesFindAPI.findBySystemId(em, systemId);

		SeriesBean seriesBean = (SeriesBean) EntityHelper.entityToBean(series,
				SeriesBean.class);

		return seriesBean;
	}

	public static List<SeriesBean> findAll(EntityManager em) {

		List<Series> series = LLSeriesFindAPI.findAll(em);

		List<SeriesBean> seriesBeans = EntityHelper.entitiesToBeans(series,
				SeriesBean.class);

		return seriesBeans;
	}

	public static List<SeriesBean> findAllByTitle(EntityManager em, String title) {

		List<Series> series = LLSeriesFindAPI.findAllByTitle(em, title);

		List<SeriesBean> seriesBeans = EntityHelper.entitiesToBeans(series,
				SeriesBean.class);

		return seriesBeans;
	}

	public static List<SeriesBean> findAllByDescription(EntityManager em,
			String description) {

		List<Series> series = LLSeriesFindAPI.findAllByDescription(em,
				description);

		List<SeriesBean> seriesBeans = EntityHelper.entitiesToBeans(series,
				SeriesBean.class);

		return seriesBeans;
	}

	public static List<SeriesBean> findAllByCreatedBy(EntityManager em,
			String createdBy) {

		List<Series> series = LLSeriesFindAPI.findAllByCreatedBy(em, createdBy);

		List<SeriesBean> seriesBeans = EntityHelper.entitiesToBeans(series,
				SeriesBean.class);

		return seriesBeans;
	}

}
