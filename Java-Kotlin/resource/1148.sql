SELECT DISTINCT
	author_id AS id
FROM
	Views
WHERE
	author_id = viewer_id
ORDER BY
	author_id;

	select distinct author_id as id from Views where author_id = viewer_id order by id asc;