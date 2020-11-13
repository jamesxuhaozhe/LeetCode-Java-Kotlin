SELECT
	c.NAME AS Customers
FROM
	Customers c
WHERE
	c.Id NOT IN ( SELECT o.CustomerId FROM Orders o );

	select c.`Name` as Customers from Customers c left join Orders o on c.Id = o.CustomerId where o.CustomerId is NULL;

select `Name` as `Customers` from Customers where Id not in (select CustomerId from Orders);