SELECT
	min(
		abs( a.x - b.x )
	) AS shortest
FROM
	point a
	JOIN point b ON a.x != b.x;