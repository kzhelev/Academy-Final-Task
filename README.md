**Task name:**

Pair of employees who have worked together

**Task description:**

Create an application that identifies the pair of employees who have worked together on common projects for the longest period of time and the time for each of those projects.

**Specific requirements:**

1) DateTo can be NULL, equivalent to today
2) We are interested in the number of days they worked together
3) The input data must be loaded to the program from a CSV file
4) More than one date format to be supported, extra points will be given if all date formats are supported 
5) In a README.md file summarize your understanding for the task and your algorithm 
6) Do not use external libraries for the CSV parsing 
7) Follow clean code conventions

**Task summary:**

Create an application that:

- reads data from a CSV file;
- analyze the data and create pairs of employees who have worked together on common projects;
- find the pair of employees who have worked together on common projects for the longest period of time and the time for each of those projects.

**Project title:**

Longest working together employees

**Project description:**

The application gives solution to the problem described above by the following steps:

	1. The user enters the path to the file that contains the information that should be processed.
	2. The application takes the data, contained in the file.
	3. The application processes the data and creates a list of all assignments, given to the employees. Every assignment 
        contains information on the project, the employee assigned to it and information about the duration the employee has worked
        on the project. The assignments are sorted into groups based on their associated project.
	4. The application processes the sorted data and creates pairs of employees who have worked together on a common project.
	5. Sorts the pairs in a descending order based on the sum of the days they have worked together on all projects.
	6. Prints the information about the pair that have worked longest together.

**Algorithm:**

	- Gets the file path, entered by the user;
	- Checks the extension of the file;
	- Depending on the file extension creates a reader object – CSVReader, TXTReader;
	- Reads the data from the file and creates assignment objects.
 	- The assignment objects are putted into a Map /Key: ProjectID, Value: assigment/. If the Map does not contain the key /
     ProjectID/, the assignment is directly added. If the Map contains the key, the application checks if the key entry value /
     assignment/ is about the same employee. In case the employee is identical only the new information about the work period is
     added to the assignment, otherwise the assignment is added as a new value of the entry; 
    - Passes through all map entries and checks if there is an overlap in work periods of the different employees that have worked
     on the same project. If an overlap is found the application creates an Pair Object that contains information about two 
     employees and their collaboration /projectID, period they have worked together on the project/. The method returns a Map<Integer,Pair>;
    - Sorts the pairs in a descending order based on the sum of the days they have worked together on all projects;
    - Prints the information about the pair that have worked longest together;

**Supported file extensions:** .CSV .TXT

**Supported date formats:** 

"yyyy-MM-dd", "dd-MM-yyyy", "dd/MM/yyyy", "yyyy/MM/dd", "dd.MM.yyyy", "yyyy.MM.dd", "dd/MM/yy", "dd-MM-yy", "dd.MM.yy", "yyyy-M-d",
 "d-M-yyyy", "d/M/yyyy", "yyyy/M/d", "d.M.yyyy", "yyyy.M.d", "dd/M/y", "d-M-yy", "d.M.yy", "yyyy-MM-d", "d-MM-yyyy", "d/MM/yyyy", 
 "yyyy/MM/d", "d.MM.yyyy", "yyyy.MM.d", "d/MM/yy", "d-MM-yy", "d.MM.yy", "yyyy-M-dd", "dd-M-yyyy", "dd/M/yyyy", "yyyy/M/dd", 
 "dd.M.yyyy", "yyyy.M.dd", "dd/M/yy", "dd-M-yy", "dd.M.yy"
