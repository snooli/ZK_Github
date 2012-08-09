package dots.clb.common.constants;

public class Queries {

	// Fonds queries

	public final static String fondsFindAll = "fondsFindAll";
	public final static String fondsFindTopLevel = "fondsFindTopLevel";
	public final static String fondsFindBySystemId = "fondsFindBySystemId";
	public final static String fondsFindAllByTitle = "fondsFindAllByTitle";
	public final static String fondsFindAllByDescription = "fondsFindAllByDescription";
	public final static String fondsFindAllByFondsStatus = "fondsFindAllByFondsStatus";
	public final static String fondsFindAllByDocumentMedium = "fondsFindAllByDocumentMedium";
	public final static String fondsFindAllByCreatedBy = "fondsFindAllByCreatedBy";
	public final static String fondsFindAllByFinalisedBy = "fondsFindAllByFinalisedBy";

	// FondsCreator queries

	public final static String fondsCreatorFindAll = "fondsCreatorFindAll";
	public final static String fondsCreatorFindBySystemId = "fondsCreatorFindBySystemId";
	public final static String fondsCreatorFindByFondsCreatorId = "fondsCreatorFindByFondsCreatorId";
	public final static String fondsCreatorFindAllByFondsCreatorName = "fondsCreatorFindAllByFondsCreatorName";
	public final static String fondsCreatorFindAllByDescription = "fondsCreatorFindAllByDescription";

	// Series queries

	public final static String seriesFindAll = "seriesFindAll";
	public final static String seriesFindBySystemId = "seriesFindBySystemId";
	public final static String seriesFindAllByTitle = "seriesFindAllByTitle";
	public final static String seriesFindAllByDescription = "seriesFindAllByDescription";
	public final static String seriesFindAllBySeriesStatus = "seriesFindAllBySeriesStatus";
	public final static String seriesFindAllByDocumentMedium = "seriesFindAllByDocumentMedium";
	public final static String seriesFindAllByCreatedBy = "seriesFindAllByCreatedBy";
	public final static String seriesFindAllByFinalisedBy = "seriesFindAllByFinalisedBy";
	public final static String seriesFindAllBySeriesStartDate = "seriesFindAllBySeriesStartDate";
	public final static String seriesFindAllBySeriesEndDate = "seriesFindAllBySeriesEndDate";

	// StorageLocation queries

	public final static String storageLocationFindAll = "storageLocationFindAll";
	public final static String storageLocationFindBySystemId = "storageLocationFindBySystemId";
	public final static String storageLocationFindAllByStorageLocation = "storageLocationFindAllByStorageLocation";

	// ClassificationSystem queries

	public final static String classificationSystemFindAll = "classificationSystemFindAll";
	public final static String classificationSystemFindBySystemId = "classificationSystemFindBySystemId";
	public final static String classificationSystemFindAllByClassificationType = "classificationSystemFindAllByClassificationType";
	public final static String classificationSystemFindAllByTitle = "classificationSystemFindAllByTitle";
	public final static String classificationSystemFindAllByDescription = "classificationSystemFindAllByDescription";
	public final static String classificationSystemFindAllByCreatedBy = "classificationSystemFindAllByCreatedBy";
	public final static String classificationSystemFindAllByFinalisedBy = "classificationSystemFindAllByFinalisedBy";

	// Class queries

	public final static String classFindAll = "classFindAll";
	public final static String classFindBySystemId = "classFindBySystemId";
	public final static String classFindByClassId = "classFindByClassId";
	public final static String classFindAllByTitle = "classFindAllByTitle";
	public final static String classFindAllByDescription = "classFindAllByDescription";
	public final static String classFindAllByCreatedBy = "classFindAllByCreatedBy";
	public final static String classFindAllByFinalisedBy = "classFindAllByFinalisedBy";

	// Keyword queries
	public final static String keywordFindAll = "keywordFindAll";
	public final static String keywordFindBySystemId = "keywordFindBySystemId";
	public final static String keywordFindAllByKeyword = "keywordFindAllByKeyword";

	// File queries

	public final static String fileFindAll = "fileFindAll";
	public final static String fileFindBySystemId = "fileFindBySystemId";
	public final static String fileFindByFileId = "fileFindByFileId";
	public final static String fileFindAllByTitle = "fileFindAllByTitle";
	public final static String fileFindAllByOfficialTitle = "fileFindAllByOfficialTitle";
	public final static String fileFindAllByDescription = "fileFindAllByDescription";
	public final static String fileFindAllByDocumentMedium = "fileFindAllByDocumentMedium";
	public final static String fileFindAllByCreatedBy = "fileFindAllByCreatedBy";
	public final static String fileFindAllByFinalisedBy = "fileFindAllByFinalisedBy";

	// CaseFile queries

	public final static String caseFileFindAll = "caseFileFindAll";
	public final static String caseFileFindBySystemId = "caseFileFindBySystemId";
	public final static String caseFileFindByFileId = "caseFileFindByFileId";
	public final static String caseFileFindAllByTitle = "caseFileFindAllByTitle";
	public final static String caseFileFindAllByOfficialTitle = "caseFileFindAllByOfficialTitle";
	public final static String caseFileFindAllByDescription = "caseFileFindAllByDescription";
	public final static String caseFileFindAllByDocumentMedium = "caseFileFindAllByDocumentMedium";
	public final static String caseFileFindAllByCreatedBy = "caseFileFindAllByCreatedBy";
	public final static String caseFileFindAllByFinalisedBy = "caseFileFindAllByFinalisedBy";
	public final static String caseFileFindAllByCaseYear = "caseFileFindAllByCaseYear";
	public final static String caseFileFindAllByCaseSequenceNumber = "caseFileFindAllByCaseSequenceNumber";
	public final static String caseFileFindAllByCaseDate = "caseFileFindAllByCaseDate";
	public final static String caseFileFindAllByAdministrativeUnit = "caseFileFindAllByAdministrativeUnit";
	public final static String caseFileFindAllByCaseResponsible = "caseFileFindAllByCaseResponsible";
	public final static String caseFileFindAllByRecordsManagementUnit = "caseFileFindAllByRecordsManagementUnit";
	public final static String caseFileFindAllByCaseStatus = "caseFileFindAllByCaseStatus";
	public final static String caseFileFindAllByLoanedDate = "caseFileFindAllByLoanedDate";
	public final static String caseFileFindAllByLoanedTo = "caseFileFindAllByLoanedTo";

	// Record queries

	public final static String recordFindAll = "recordFindAll";
	public final static String recordFindBySystemId = "recordFindBySystemId";
	public final static String recordFindAllByCreatedBy = "recordFindAllByCreatedBy";
	public final static String recordFindAllByArchivedBy = "recordFindAllByArchivedBy";

	// BasicRecord queries

	public final static String basicRecordFindAll = "basicRecordFindAll";
	public final static String basicRecordFindBySystemId = "basicRecordFindBySystemId";
	public final static String basicRecordFindAllByCreatedBy = "basicRecordFindAllByCreatedBy";
	public final static String basicRecordFindAllByArchivedBy = "basicRecordFindAllByArchivedBy";
	public final static String basicRecordFindByRecordId = "basicRecordFindByRecordId";
	public final static String basicRecordFindAllByTitle = "basicRecordFindAllByTitle";
	public final static String basicRecordFindAllByOfficialTitle = "basicRecordFindAllByOfficialTitle";
	public final static String basicRecordFindAllByDescription = "basicRecordFindAllByDescription";
	public final static String basicRecordFindAllByDocumentMedium = "basicRecordFindAllByDocumentMedium";

	// RegistryEntry queries

	public final static String registryEntryFindAll = "registryEntryFindAll";
	public final static String registryEntryFindBySystemId = "registryEntryFindBySystemId";
	public final static String registryEntryFindAllByCreatedBy = "registryEntryFindAllByCreatedBy";
	public final static String registryEntryFindAllByArchivedBy = "registryEntryFindAllByArchivedBy";
	public final static String registryEntryFindByRecordId = "registryEntryFindByRecordId";
	public final static String registryEntryFindAllByTitle = "registryEntryFindAllByTitle";
	public final static String registryEntryFindAllByOfficialTitle = "registryEntryFindAllByOfficialTitle";
	public final static String registryEntryFindAllByDescription = "registryEntryFindAllByDescription";
	public final static String registryEntryFindAllByDocumentMedium = "registryEntryFindAllByDocumentMedium";
	public final static String registryEntryFindAllByRecordYear = "registryEntryFindAllByRecordYear";
	public final static String registryEntryFindAllByRecordSequenceNumber = "registryEntryFindAllByRecordSequenceNumber";
	public final static String registryEntryFindAllByRegistryEntryNumber = "registryEntryFindAllByRegistryEntryNumber";
	public final static String registryEntryFindAllByRegistryEntryType = "registryEntryFindAllByRegistryEntryType";
	public final static String registryEntryFindAllByRecordStatus = "registryEntryFindAllByRecordStatus";
	public final static String registryEntryFindAllByRecordDate = "registryEntryFindAllByRecordDate";
	public final static String registryEntryFindAllByDocumentDate = "registryEntryFindAllByDocumentDate";
	public final static String registryEntryFindAllByDueDate = "registryEntryFindAllByDueDate";
	public final static String registryEntryFindAllByFreedomAssessmentDate = "registryEntryFindAllByFreedomAssessmentDate";
	public final static String registryEntryFindAllByNumberOfAttachments = "registryEntryFindAllByNumberOfAttachments";
	public final static String registryEntryFindAllByLoanedDate = "registryEntryFindAllByLoanedDate";
	public final static String registryEntryFindAllByLoanedTo = "registryEntryFindAllByLoanedTo";
	public final static String registryEntryFindAllByRecordsManagementUnit = "registryEntryFindAllByRecordsManagementUnit";

	// DocumentDescription queries

	public final static String documentDescriptionFindAll = "documentDescriptionFindAll";
	public final static String documentDescriptionFindBySystemId = "documentDescriptionFindBySystemId";
	public final static String documentDescriptionFindAllByDocumentType = "documentDescriptionFindAllByDocumentType";
	public final static String documentDescriptionFindAllByDocumentStatus = "documentDescriptionFindAllByDocumentStatus";
	public final static String documentDescriptionFindAllByTitle = "documentDescriptionFindAllByTitle";
	public final static String documentDescriptionFindAllByDescription = "documentDescriptionFindAllByDescription";
	public final static String documentDescriptionFindAllByCreatedBy = "documentDescriptionFindAllByCreatedBy";
	public final static String documentDescriptionFindAllByDocumentMedium = "documentDescriptionFindAllByDocumentMedium";
	public final static String documentDescriptionFindAllByAssociatedWithRecordAs = "documentDescriptionFindAllByAssociatedWithRecordAs";
	public final static String documentDescriptionFindAllByDocumentNumber = "documentDescriptionFindAllByDocumentNumber";
	public final static String documentDescriptionFindAllByAssociationDate = "documentDescriptionFindAllByAssociationDate";
	public final static String documentDescriptionFindAllByAssociatedBy = "documentDescriptionFindAllByAssociatedBy";

	// DocumentObject queries

	public final static String documentObjectFindAll = "documentObjectFindAll";
	public final static String documentObjectFindBySystemId = "documentObjectFindBySystemId";
	public final static String documentObjectFindAllByVersionNumber = "documentObjectFindAllByVersionNumber";
	public final static String documentObjectFindAllByVariantFormat = "documentObjectFindAllByVariantFormat";
	public final static String documentObjectFindAllByFormat = "documentObjectFindAllByFormat";
	public final static String documentObjectFindAllByFormatDetails = "documentObjectFileAllByFormatDetails";
	public final static String documentObjectFindAllByCreatedBy = "documentObjectFindAllByCreatedBy";
	public final static String documentObjectFindAllByChecksum = "documentObjectFindAllByChecksum";
	public final static String documentObjectFindAllByChecksumAlgorithm = "documentObjectFindAllByChecksumAlgorithm";

	// Author queries

	public final static String authorFindAll = "authorFindAll";
	public final static String authorFindBySystemId = "authorFindBySystemId";
	public final static String authorFindAllByAuthor = "authorFindAllByAuthor";

	// ChangeLogEntry queries

	public final static String changeLogEntryFindAll = "changeLogEntryFindAll";

}
