DELETE
FROM
	Person
WHERE
	Id IN (
	SELECT
		id
	FROM
		(
		SELECT DISTINCT
			p1.Id AS id
		FROM
			Person p1,
			Person p2
		WHERE
			p1.Email = p2.Email
			AND p1.Id > p2.Id
		) AS temp
	);


DELETE p1
FROM
	Person p1
	JOIN Person p2 USING ( Email )
WHERE
	p1.Email = p2.Email
	AND p1.Id > p2.Id;