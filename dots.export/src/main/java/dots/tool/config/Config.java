package dots.tool.config;

import java.io.File;

public class Config {

	// temporary directory
	public static File tmpRoot;

	// documents directory
	public static File tmpDocuments;

	// output archive file
	public static File outputFile;

	// arkivstruktur
	public static File archiveStructureFile;
	public static File archiveStructureSchema;

	// offentligJournal
	public static File publicRecordsFile;
	public static File publicRecordsSchema;

	// loependeJournal
	public static File runningRecordsFile;
	public static File runningRecordsSchema;

	// endringslogg
	public static File changeLogFile;
	public static File changeLogSchema;

	// arkivuttrekk
	public static File archiveExtractionFile;
	public static File archiveExtractionSchema;

	// metadatakatalog
	public static File metadataCatalogSchema;

	// address and port of the Noark 5 core
	public static String n5Address;
	public static String n5Port;

}
