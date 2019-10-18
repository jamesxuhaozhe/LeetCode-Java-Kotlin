SELECT
	Email
FROM
	Person
GROUP BY
	Email
HAVING
	COUNT( Id ) > 1;