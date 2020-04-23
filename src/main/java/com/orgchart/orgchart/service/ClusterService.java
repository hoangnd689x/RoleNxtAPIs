package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Cluster;
import com.orgchart.orgchart.model.Connection;

/**
 * @author RRA81HC
 *
 */
@Transactional
public interface ClusterService {
	
	List<Cluster> GetAllClustersByDepartmentID(long id);
	List<Cluster> GetAllClusters();
}
