SELECT
	c.NAME AS Customers
FROM
	Customers c
WHERE
	c.Id NOT IN ( SELECT o.CustomerId FROM Orders o );