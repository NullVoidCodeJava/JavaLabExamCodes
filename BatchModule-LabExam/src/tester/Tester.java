package tester;

import java.sql.*;
import dao.*;
import entity.Batch;
import entity.Module;
import service.BatchService;
import service.ModuleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

	private static final Scanner scanner = new Scanner(System.in);
	private static ModuleService moduleService = new ModuleService();
	private static BatchService batchService = new BatchService();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
    	
            int choice;
            
            do {
                System.out.println("Menu:");
                System.out.println("0. Exit");
                System.out.println("1. Add new batch");
                System.out.println("2. Display all batches");
                System.out.println("3. Add new module");
                System.out.println("4. Display modules of the given batch");
                System.out.println("5. Delete module by name for given batch id");
                System.out.println("6. Display modulewise total days for given batch id");
                System.out.println("7. Edit module");
                System.out.println("8. Display number of days for each course for each faculty");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                
                scanner.nextLine(); // Consume newline

                switch (choice) {
                
                    case 0:
                    {
                        scanner.close();
                        System.exit(0);
                        break;
                    }
                  
                    //add new batch
                    case 1:
                    {
                    
                        System.out.println("Enter batch name: ");
                        String batchName = scanner.nextLine();
                        System.out.println("Enter course name: ");
                        String courseName = scanner.nextLine();
                        
                        batchService.addBatch(new Batch(batchName,courseName));
                        break;
                    }
                        
                    //display all batches
                    case 2:
                    {
                        batchService.displayAllBatches();
                        break;
                    }
                    
                    //add new module
                    case 3:
                    {
                        System.out.println("Enter module name: ");
                        String moduleName = scanner.nextLine();
                        System.out.println("Enter start date ");
                        System.out.println("Enter year");
                        int year = scanner.nextInt();
                        System.out.println("Enter month");
                        int month = scanner.nextInt();
                        System.out.println("Enter day");
                        int day = scanner.nextInt();
                        Date date = new Date(year-1900, month-1, day);
                        System.out.println("Enter days: ");
                        int days = scanner.nextInt();
                        System.out.println("Enter batch id: ");
                        int batchId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline very important
                        System.out.println("Enter faculty name: ");
                        String facultyName = scanner.nextLine();                  
                        
                        moduleService.addModule(new Module(moduleName, date, days, facultyName, batchId));
                        break;
                    }
                    
                    //display modules of the given batch
                    case 4:
                    	System.out.println("Enter batch id: ");
                    	int batchId = scanner.nextInt();
                        moduleService.displayModulesByBatchId(batchId);
                        break;
                        
                    //delete module by name for given batch id
                    case 5:
                    	System.out.println("Enter module name to be deleted: ");
                    	String moduleName = scanner.nextLine();
                    	
                        moduleService.deleteModuleByName(moduleName);
                        break;
                        
                    //display modulewise total days for given batch id
                    case 6:
                        
                    	System.out.println("Enter batch id: ");
                    	int batchidd = scanner.nextInt();
                    	moduleService.displayModulewiseTotalDays(batchidd);
                        break;
                        
                    //edit module
                    case 7:
                    	
                    	System.out.println("Enter the module id to be edited: ");
                    	int moduleId = scanner.nextInt();
                    	
                    	 scanner.nextLine();
                    	 System.out.println("Enter module name to be edited: ");;
                         String modulename = scanner.nextLine();
                         System.out.println("Enter start date to be edited: ");
                         System.out.println("Enter year");
                         int year = scanner.nextInt();
                         System.out.println("Enter month");
                         int month = scanner.nextInt();
                         System.out.println("Enter day");
                         int day = scanner.nextInt();
                         Date date = new Date(year-1900, month-1, day);
                         System.out.println("Enter days to be edited: ");
                         int days = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Enter faculty name to be edited: ");
                         String facultyName = scanner.nextLine();
                         System.out.println("Enter batch id to be edited: ");
                         int batchid = scanner.nextInt();
                         
                        moduleService.updateModule(new Module(moduleId, modulename , date, days, facultyName, batchid));
                        break;
                        
                    //display number of days for each course for each faculty
                    case 8:
                    {
                        moduleService.displayModulewiseTotalDaysByFaculty(); 
                        break;
                    }

    }
                    }while(choice != 0);
	}
}