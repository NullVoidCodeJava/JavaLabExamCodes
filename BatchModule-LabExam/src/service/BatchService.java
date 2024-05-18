package service;

import java.sql.SQLException;

import dao.BatchDao;
import entity.Batch;

public class BatchService {

	private BatchDao batchDao;

	//initialize batchDao
	public BatchService() {
		super();
		try {
			this.batchDao = new BatchDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//add a batch to database
	public int addBatch(Batch batch) {
		try {
			batchDao.addBatch(batch);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//display all batches from database
	public void displayAllBatches() {
			try {
            batchDao.displayAllBatches();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
