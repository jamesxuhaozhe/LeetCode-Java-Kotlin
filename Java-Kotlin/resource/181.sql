SELECT
	a.NAME AS Employee
FROM
	Employee a
	JOIN Employee b ON a.ManagerId = b.Id
WHERE
	a.Salary > b.Salary;

	select e1.`Name` as Employee from Employee e1 join Employee e2 on e1.ManagerId = e2.Id where e1.Salary > e2.Salary;