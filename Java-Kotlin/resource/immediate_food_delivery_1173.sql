SELECT
	round(
		sum(
		CASE
				WHEN order_date = customer_pref_delivery_date THEN
				1 ELSE 0
			END
			) / count( * ) * 100,
			2
		) AS immediate_percentage
	FROM
		Delivery;