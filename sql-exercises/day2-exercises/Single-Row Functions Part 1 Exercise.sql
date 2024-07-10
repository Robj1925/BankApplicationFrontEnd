/*Look through Lesson 6b Single-Row Functions Part 1.sql and run the code examples there, then
   practice single-row functions with the excercises below:
*/

/* 1) Display the first_name, last_name, and the first four letters of 
      the first name with the last four letters of the last name of 
      each employee in department 50. Label the column short_name. */

SELECT first_name, last_name, CONCAT(SUBSTR(first_name, 1, 4), ' ', SUBSTR(last_name, 1, 4) )  as Short_Name FROM employees WHERE department_id = 50;

/* 2) Write a query that displays city concatenated with country id, separated
      by a comma and space. Name the column City and Country. */
	  

	  SELECT CONCAT(city, ', ', country_id) as 'City and Country' FROM locations;
	  
	  
/* 3) Display the employee number, last_name, salary, and salary increased by
      4.8125% for each employee. Round the result two places past the decimal 
      and label the column New_Pay. */
      
      SELECT employee_id, last_name, salary, ROUND(salary *(1 + .048125) , 2) as New_Pay FROM employees;
      

/* 4) Repeat query 3, but add a column that subtracts the old salary from the
      new salary. Ensure that this column is also rounded 2 places. 
      Label the column Pay_Increase. */

SELECT employee_id, last_name, salary, ROUND(salary *(1 + .048125) , 2) as New_Pay, ROUND(ROUND(salary *(1 + .048125) , 2)  - salary, 2) as Pay_Increase FROM employees;

/* 5) Display the last name, length of the last name, for any employee
      whose last name begins with A, J, or M. Label the column Name_Length. */


SELECT LENGTH(last_name) as Name_Length FROM employees WHERE last_name LIKE 'a%'  OR last_name LIKE 'j%' OR last_name LIKE 'm%';

/* 6)  Display employee_id, last_name, job_id, and job_id with MAN replaced with MGR.
		Label the last column Corrected_Job_Id. Be sure to only select those rows whose		
		job_id ends in MAN.*/ 
      

SELECT employee_id, last_name, job_id, REPLACE(job_id, 'MAN', 'MGR') as Corrected_Job_Id FROM employees WHERE job_id LIKE '%MAN';
      
/* 7) Show the consultant id, first name, last name, job_id, and salary. Append _CONS to the job id	
		so that their job ids appear as SA_REP_CONS. Label the column Job_Id. 
        Use RPAD() to accomplish this. Then rewrite the query using CONCAT() instead of RPAD(). */
      
    SELECT consultant_id, first_name, last_name, RPAD(job_id, LENGTH(job_id) + 4, '_CON') as Job_Id, salary FROM consultants

    SELECT consultant_id, first_name, last_name, CONCAT(job_id,  '_CON') as Job_Id, salary FROM consultants
    
/* 8) Show the last name and salary of all employees. Display a 
      fixed dollar sign concatenated with the salary padded with asterisks 
      up to a width of 9 characters.  Label the column Salary.  */
      
      SELECT last_name, salary, RPAD(CONCAT('$', salary), 9, '*') AS Salary FROM employees
      
/* 9) Show the street_address column in the locations table. Next to it display
		the characters in the street address beginning with the character after 
        the first space. For example, if the address is 10 Downing Street, 
        display Downing Street. Label the column Street.  */

SELECT street_address, SUBSTR(street_address, INSTR(street_address, ' '), LENGTH(street_address)) AS Street from locations


/* 10)	Show each consultant's first name, last name, salary, and manager id. Display the salary with a	
		dollar sign followed by the salary with commas and two places past the decimal point. 
		Label the column Salary. */ 
        
SELECT first_name, last_name, FORMAT(CONCAT('$', salary), 2) as Salary, manager_id FROM consultants;

/* 11) Select department id, department name, manager id, and location id of all departments
		in the departments table. If the department has no manager, use Empty Department as the 
        substition value. Use IFNULL() to accomplish this. Then rewrite the query using COALESCE() 
        instead of IFNULL(). Label the column Manager_Id.  */
        
        
        
        SELECT department_id, department_name, IFNULL(manager_id, 'Empty Department')as Manager_Id, location_id FROM departments 

        SELECT department_id, department_name, COALESCE(manager_id, 'Empty Department') as Manager_Id, location_id FROM departments 
        
        
        
        