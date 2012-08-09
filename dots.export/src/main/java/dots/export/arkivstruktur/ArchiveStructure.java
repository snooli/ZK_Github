package dots.export.arkivstruktur;

import dots.module.base.entitybeans.FondsBean;

public class ArchiveStructure {

	public static void generate(FondsBean fonds) {

		FondsWriter.writeFondsRecursive(fonds, null);

	}

}
