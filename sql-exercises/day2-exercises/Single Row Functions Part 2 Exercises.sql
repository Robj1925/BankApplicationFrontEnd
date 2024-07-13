/* 
Look through Lesson 7b Single-Row Functions Part 2.sql and run the code examples there, then
   practice single-row functions with the excercises below: */
------------------------------------------------------------------------------------------------
/* 1) Show the last name, hire date, job id, and salary for any employee that was hired
		in the last four years. Write the query using DATE_ADD(), then rewrite it using DATE_SUB().*/

SELECT last_name, hire_date, job_id, salary FROM employees WHERE hire_date >= DATE_ADD(CURDATE(), INTERVAL -4 YEAR)
	SELECT last_name, hire_date, job_id, salary FROM employees WHERE hire_date >= DATE_SUB(CURDATE(), INTERVAL 4 YEAR)

/* 2) How many days have the employees worked here? Display each employee's first_name, last name, 
		hire date, days on the job. Label the column Days_on_the_Job. */
        
     SELECT first_name, last_name, hire_date, DATEDIFF(CURDATE(), hire_date) as Days_on_the_Job FROM employees   
		
		
       
/* 3) For each consultant display the first_name, last name, salary, and hire date. Show the 
		hire date in the format Monday, 08-05-23, where the first two digits are the day of the month, 
		the next two digits are the month, and the last two digits are the year. Label the column Hire_Date. 
        Order the output by the numeric day of the week starting with Sunday. */
        
 SELECT first_name, last_name, salary, hire_date, DATE_FORMAT(hire_date, '%W, %d-%m-%y') as Hire_Date  FROM consultants
ORDER BY DAYOFWEEK(hire_date)       
		
		

/* 4) Calculate how many months each employee has been on the job. Display their last name, hire date,
		salary, manager id, and the number of months. Label the column Months_on_the_Job. */
        
        
		
		SELECT last_name, salary, hire_date, salary, manager_id, TIMESTAMPDIFF(MONTH, hire_date, CURDATE()) AS Months_On_Job FROM employees
		

/* 5) For each sale, show the sales id, the sales rep id, and the sales timestamp. In the next column,
		show the date portion of the sales timestamp in a separate column. Label the column Sales_Date.
        Then show the time portion of the sales timestamp. Label the column Sales_Time.
        Lastly, display the sales amount.       */
        
       
	   SELECT sales_id, sales_rep_id, sales_timestamp, DATE(sales_timestamp) AS Sales_Date, TIME(sales_timestamp) AS  Sales_Time, sales_amt FROM sales 
        
        
	/* 6) Display the last_name, hire_date, and the number of weeks each employee has worked
      in department 90. Label the column Tenure. Use the DATEDIFF() function.
      Truncate the number of weeks zero places past the decimal. Sort the result in descending 
      order of tenure. */
      
      
	  
	  SELECT last_name, hire_date, 
      ROUND(DATEDIFF(CURDATE(), hire_date) / 7) AS Tenure 
      FROM employees 
      WHERE department_id = 90 
      ORDER BY Tenure DESC;
	  
	  
		
/* 7) Rewrite your answer to question 6 using TIMESTAMPDIFF(). There is no need to use TRUNCATE()
		as TIMESTAMPDIFF() only returns integers.  */
        
   SELECT last_name, hire_date, TIMESTAMPDIFF(WEEK, CURDATE(), hire_date) * -1 AS Tenure 
   FROM employees 
   WHERE department_id = 90 
   ORDER BY Tenure DESC;     
		       
/* 8) Show last name, manager, job, hire date, and the date
        benefits began. Benefits begin on the first day of the month after hire. 
        Label the column Benefits_Start. */ 
        
    SELECT last_name,
     manager_id,
      job_id,
       hire_date,
        DATE_SUB(DATE_ADD(hire_date, INTERVAL  1 MONTH ), INTERVAL DAY(hire_date) - 1  DAY) AS Benefits_Start 
    FROM employees    
		
		
		

/* 9)	Display any employees who were hired in the third quarter of the year. Show the first and last names, 
			Job id, hire_date, and manager id.  */
            
            
			SELECT first_name, last_name, job_id, hire_date, manager_id
FROM employees
WHERE QUARTER(hire_date) = 3;
			

/* 10)	For each consultant, show the first and last names, salary, manager id, and the manager's last name.
		Using the CASE operator display the manager last name as follows:
		
        If the manager id is:			Display:
        145								Russell
        146								Partners
        147								Errazuriz
        148								Cambrault
        149								Zlotkey
        anything else					Other
        Label the column Manager. */
        
        	SELECT c.first_name, c.last_name, c.salary, c.manager_id, 
    CASE
        WHEN c.manager_id = 145 THEN 'Russell'
        WHEN c.manager_id = 146 THEN 'Partners'
        WHEN c.manager_id = 147 THEN 'Errazuriz'
        WHEN c.manager_id = 148 THEN 'Cambrault'
        WHEN c.manager_id = 149 THEN 'Zlotkey'
        ELSE 'Other'
    END AS manager_name
FROM consultants c
INNER JOIN employees e
ON c.manager_id = e.employee_id;

			