package org.jabref.asv;

import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.fileformat.PdfContentImporter;
import org.jabref.logic.util.StandardFileType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class PdfContentImporterTest {

    private PdfContentImporter pdf;

    @BeforeEach
    void setUp() {
        pdf = new PdfContentImporter(mock(ImportFormatPreferences.class));
    }

    @Test
    void incorrectExtensionTest() {
        assertEquals(StandardFileType.PDF, pdf.getFileType());
    }
}