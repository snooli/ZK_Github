package dots.clb.common.constants;

public class N5Status {

	public static class DocumentMedium {

		public final static String PHYSICAL = "Fysisk medium";
		public final static String ELECTRONIC = "Elektronisk arkiv";
		public final static String MIXED = "Blandet fysisk og elektronisk arkiv";

	}

	public static class CaseStatus {

		public final static String BEING_PROCESSED = "Under behandling";
		public final static String FINALISED = "Avsluttet";
		public final static String DISCONTINUED = "Utgår";

	}

	public static class DocumentStatus {

		public final static String BEING_EDITED = "Dokumentet er under redigering";
		public final static String FINALISED = "Dokumentet er ferdigstilt";

	}

	public static class AssociatedWithRecordAs {

		public final static String MAIN_DOCUMENT = "Hoveddokument";
		public final static String ATTACHMENT = "Vedlegg";

	}

	public static class VariantFormat {

		public final static String PRODUCTION = "Produksjonsformat";
		public final static String ARCHIVE = "Arkivformat";
		public final static String SCREENED = "Dokument hvor deler av innholdet er skjermet";

	}

	public static class FondsStatus {

		public final static String CREATED = "Opprettet";
		public final static String FINALISED = "Avsluttet";

	}

	public static class RegistryEntryType {

		public final static String INCOMING_DOC = "Inngående dokument";
		public final static String OUTGOING_DOC = "Utgående dokument";
		public final static String INTERNAL_DOC_FOLLOW_UP = "Organinternt dokument for oppfølging";
		public final static String INTERNAL_DOC_NO_FOLLOW_UP = "Organinternt dokument uten oppfølging";
		public final static String CASE_PRESENTATION = "Saksframlegg";

	}

	public static class RecordStatus {

		public final static String REGISTERED = "Journalført";
		public final static String FINALISED = "Ferdigstilt fra saksbehandler";
		public final static String APPROVED = "Godkjent av leder";
		public final static String DISPATCHED = "Ekspedert";
		public final static String ARCHIVED = "Arkivert";
		public final static String DISCONTINUED = "Utgår";

	}

	public static class SeriesStatus {

		public final static String ACTIVE_PERIOD = "Aktiv periode";
		public final static String OVERLAP_PERIOD = "Overlappingsperiode";
		public final static String CLOSED_PERIOD = "Avsluttet periode";
		public final static String IRRELEVANT_FILES = "Uaktuelle mapper";

	}

}
