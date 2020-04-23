/**
 * 
 */
package com.orgchart.orgchart.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orgchart.orgchart.model.Cluster;
import com.orgchart.orgchart.model.Connection;
import com.orgchart.orgchart.model.Organization;
import com.orgchart.orgchart.model.Position;
import com.orgchart.orgchart.service.ClusterService;

/**
 * @author RRA81HC
 *
 */
public class ClusterServiceImpl implements ClusterService {

	private static final String FILE_NAME = "data_structure.xlsx";
	private static String filePath = "";
	
	public ClusterServiceImpl() {
		super();
		// use this file path because in war file cannot point to resource folder, have
		// to point to folder class/...
		filePath = Thread.currentThread().getContextClassLoader().getResource(FILE_NAME).getPath();
	}

	@Override
	public List<Cluster> GetAllClustersByDepartmentID(long id) {
		List<Cluster> clusters= this.GetAllClusters();
		
		return null;
	}

	@Override
	public List<Cluster> GetAllClusters() {
		List<Cluster> clusters= new ArrayList<Cluster>();
		try {
			File file = new File(filePath);

			FileInputStream inputStream = new FileInputStream(file);

			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet datatypeSheet = workbook.getSheetAt(8);
			Iterator<Row> iterator = datatypeSheet.iterator();
			boolean firstRow = true;

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				Cluster cluster = new Cluster();

				if (firstRow) {
					firstRow = false;
				} else {
					try {
						if (currentRow.getCell(0) != null) {
							cluster.setId((long) currentRow.getCell(0).getNumericCellValue());
						}
						if (currentRow.getCell(1) != null) {
							cluster.setLabel((currentRow.getCell(1).toString()));
						}
						cluster.setChideNodes(new ArrayList<Position>());
						clusters.add(cluster);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
	
}
