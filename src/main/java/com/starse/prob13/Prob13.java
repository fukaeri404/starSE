package com.starse.prob13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Prob13 {
	public static void main(String[] args) {
		String sourceFilePath = "src/main/java/com/starse/prob4/list.csv";
		String destinationFilePath = "src/main/java/com/starse/prob4/list-copy.csv";

		try {
			FileInputStream sourceFile = new FileInputStream(sourceFilePath);
			try (Workbook sourceWorkbook = new XSSFWorkbook(sourceFile)) {
				Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Assuming data is in the first sheet

				try (Workbook destinationWorkbook = new XSSFWorkbook()) {
					Sheet destinationSheet = destinationWorkbook.createSheet("Copy of " + sourceSheet.getSheetName());

					int rowCount = sourceSheet.getLastRowNum();

					for (int i = 0; i <= rowCount; i++) {
						Row sourceRow = sourceSheet.getRow(i);
						Row destinationRow = destinationSheet.createRow(i);

						if (sourceRow != null) {
							int columnCount = sourceRow.getLastCellNum();
							for (int j = 0; j < columnCount; j++) {
								Cell sourceCell = sourceRow.getCell(j);
								Cell destinationCell = destinationRow.createCell(j);

								if (sourceCell != null) {
									CellType cellType = sourceCell.getCellType();
									switch (cellType) {
									case STRING:
										destinationCell.setCellValue(sourceCell.getStringCellValue());
										break;
									case NUMERIC:
										destinationCell.setCellValue(sourceCell.getNumericCellValue());
										break;
									case BOOLEAN:
										destinationCell.setCellValue(sourceCell.getBooleanCellValue());
										break;
									case FORMULA:
										destinationCell.setCellValue(sourceCell.getCellFormula());
										break;
									default:
										break;
									}
								}
							}
						}
					}

					FileOutputStream destinationFile = new FileOutputStream(destinationFilePath);
					destinationWorkbook.write(destinationFile);

					sourceFile.close();
					destinationFile.close();
				}
			}
			System.out.println("Data copied successfully from " + sourceFilePath + " to " + destinationFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
