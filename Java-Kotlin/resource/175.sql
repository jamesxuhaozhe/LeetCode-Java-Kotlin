SELECT
	p.FirstName,
	p.LastName,
	a.City,
	a.State
FROM
	Person AS p
	LEFT JOIN Address AS a ON p.PersonId = a.PersonId;


select FirstName, LastName, City, State from Person left join Address using(PersonId);