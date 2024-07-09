/*Look through Lesson 06b Where and Order By.sql and run the code examples there, then
   practice restricting and sorting data with the excercises below:
*/


-- 1) Show the last name and salary of those employees who earn  more than $12000.
SELECT last_name, salary FROM employees WHERE salary > 12000;


-- 2) Display the last name and department number of employee 176.
SELECT last_name, department_id FROM employees WHERE employee_id = 176;

/* 3)Display the last name and salary of those employees whose salary is not in 
    the range of $5,000 to $12,000. */

SELECT last_name, salary FROM employees WHERE SALARY NOT BETWEEN 5000 AND 12000 


/* 4) Show the first and last name, salary, and hire date for employees with 
      the last names Matos or Taylor. */



SELECT first_name ,last_name, salary, hire_date FROM employees WHERE last_name = 'Matos' OR last_name = 'Taylor' 

/* 5) Display the last name and department id of all employees in departments 20
      and 50. Sort the result by last name. */ 
      

SELECT last_name, department_id  FROM employees WHERE department_id BETWEEN 20 AND 50 order by last_name
      
      
/* 6) Display the last name, salary, and department of employees who earn 
      between $5,000 and $10,000 and are in department 60 or 80. Label the 
      columns Employee and monthly_salary. */
      

SELECT last_name as Employee, salary as Monthly_Salary, department_id  FROM employees WHERE salary BETWEEN 5000 AND 10000 and department_id between 60 and 80     
    
-- 7) Show the last name and hire date for all emplyees hired in 2004.
      
      
SELECT last_name, hire_date FROM employees having year(hire_date) = 2004


  
  
-- 8) Show the last name and job id of all employees who do not have a manager.

		SELECT last_name, job_id FROM employees where manager_id is null;

/* 9) Display the last_name, salary, and commission of all employees who earn
      a commission. Sort the result in descending order of salary and commission.
      Use the columns' numeric position in the order by clause. */
  select last_name, salary, commission_pct from employees where commission_pct  is not null;    
		
      
      
/*  10) Show the last name and salary of employees who earn more than $10000. */
        
  select last_name, salary from employees where salary > 10000      
    
/*  11) Write a query that  generates employee id, last name, salary, manager_id, and department 
		for the employees of manager 120. Sort the report by the first selected column. */
        
        SELECT employee_id, last_name, salary, manager_id, department_id FROM employees where manager_id = 120 order by employee_id;
        
--  12) Show all last names that have "a" as the third letter.

SELECT last_name FROM employees WHERE last_name LIKE '__a%';


/*  13) Display all last names of employees who have both an "a" and an "e" 
        in their last name. */

		
SELECT last_name FROM employees where last_name like '%a%' AND last_name LIKE '%e%';


/*  14) Show the last name, job, and salary for all employees who are either a
        sales representative or stock clerk, and whose salary is not $2,500, 
        $3,500, or $7,000. Order the result by salary within job. */
        
        SELECT last_name, job_id, salary FROM employees where job_id IN ('ST_CLERK', 'SA_REP')  AND salary NOT IN(2500,3500,7000) ORDER BY job_id, SALARY
		  

        
        
/*  15) Show the last name, salary and commission of those employees whose 
        commission is 20%. */
        

			SELECT last_name,  salary, commission_pct FROM employees WHERE commission_pct = 0.20

/* 16) In the locations table, display street address, city, state/province, postal code, and country id for 
		any location that has a state/province value. Sort the result by country and postal code. 
        */
        
 SELECT street_address, city, state_province, postal_code, country_id from locations WHERE state_province is not null ORDER BY country_id, postal_code
			
          
-- 17) Show the the last name, job id, department id, and salary of the top 10 highest paid employees.       
SELECT last_name, job_id, department_id, salary FROM employees order by salary DESC LIMIT 10;
        
        
          