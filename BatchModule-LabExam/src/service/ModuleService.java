package service;

import java.sql.SQLException;

import dao.ModuleDao;
import entity.Module;

public class ModuleService {

	private ModuleDao moduleDao;

	public ModuleService() {
		super();
		try {
			this.moduleDao = new ModuleDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addModule(Module module)
	{
		try {
			return this.moduleDao.addModule(module);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void displayModulesByBatchId(int batchId)
	{
		try {
            this.moduleDao.displayModulesByBatchId(batchId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deleteModuleByName(String moduleName)
	{
		try {
            this.moduleDao.deleteModuleByName(moduleName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateModule(Module module)
	{
		try {
            this.moduleDao.updateModule(module);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void displayModulewiseTotalDays(int batchId)
	{
		try {
            this.moduleDao.displayModulewiseTotalDays(batchId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//display number of days for each course for each faculty
	public void displayModulewiseTotalDaysByFaculty()
	{
		try {
            this.moduleDao.displayNumberOfDaysForEachCourseForEachFaculty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
