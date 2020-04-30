package com.qafocus.core.util;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.qafocus.data.Testcase;

public final class CsvLoader {

	public static List<Testcase> readCSV(File csvfile) throws IOException {
		List<Testcase> modifiedRecordList = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(Paths.get(csvfile.getAbsolutePath()));
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withHeader("ID", "Description", "Tags", "Label", "Enabled")
								.withIgnoreHeaderCase().withTrim());) {

			List<CSVRecord> records = csvParser.getRecords();
			for (CSVRecord csvRecord : records) {
				String masterCode = csvRecord.get("ID");
				String enabled = csvRecord.get("Enabled");
				Testcase testcaseRecord = new Testcase();
				testcaseRecord.setIdentifier(masterCode);
				testcaseRecord.setEnabled(Boolean.valueOf(enabled));
				modifiedRecordList.add(testcaseRecord);

			}

			return modifiedRecordList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
