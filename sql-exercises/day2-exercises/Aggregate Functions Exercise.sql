/* Look through Lesson 8b Aggregate Functions.sql and run the code examples there, then
   practice Aggregate Functions with the excercises below:
*/


/* 1) Find the highest, lowest, sum, and average salary of all employees. 
      Label the columns Maximum, Minimum, Sum, and Average. Round any result
      two places past the decimal, if needed. */

SELECT MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary), 2) AS Average
FROM employees
GROUP BY employee_id


-- 2) Modify query 1 to display the aggregated data for each job type.
SELECT MAX(salary) AS Maximum, MIN(salary) AS Minimum, SUM(salary) AS Sum, ROUND(AVG(salary), 2) AS Average
FROM employees
GROUP BY job_id


-- 3) Write a query that counts the number of people in each job type. 

SELECT COUNT(employee_id), job_id
FROM employees
GROUP BY job_id

-- 4) Show how much each manager pays the different jobs that report to them.
--		For every manager id and job id compbination, show the total salary paid. 
-- 	  	Sort the result by the manager id and job id.

SELECT m.employee_id AS manager_id, e.job_id, SUM(e.salary) AS total_salary
FROM employees e
INNER JOIN employees m ON e.manager_id = m.employee_id
GROUP BY m.employee_id, e.job_id
ORDER BY m.employee_id, e.job_id;


/* 5) Display the number of distinct managers. Label the column
      Number of Managers. */ 
      
      SELECT employee_id, first_name, last_name, job_id
FROM employees
WHERE (job_id LIKE '%MAN'
   OR job_id LIKE '%MGR');
      
/* 6) Find the difference between the highest and lowest salary. Label the 
      column Difference. */
          
SELECT MAX(salary) - MIN(salary) AS Difference
FROM employees      
      
/* 7) Display the manager number and the salary of the lowest paid employee
      for each manager. Exclude anyone whose manager is unknown. Exclude any 
      group in which the minimum salary is $6000 or less. Sort the output in 
      descending order of lowest salary. */ 
      
 SELECT m.employee_id AS manager_id, MIN(e.salary) AS lowest_paid_employee
FROM employees e
INNER JOIN employees m
ON e.manager_id = m.employee_id
WHERE m.employee_id IS NOT NULL
GROUP BY m.employee_id
HAVING lowest_paid_employee > 6000
ORDER BY lowest_paid_employee DESC;     
        