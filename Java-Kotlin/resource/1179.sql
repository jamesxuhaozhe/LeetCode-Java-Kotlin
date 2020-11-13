因为group by分组操作之后，每个分组有多行记录，如果不加sum或者max，mysql会取分组的第一条记录，这时候case when只能匹配到其中一个，结果就是只有一个月份不为null，其他月份都是null。
select
id,
sum(case when `month` = 'Jan' then revenue end) as Jan_Revenue,
sum(case when `month` = 'Feb' then revenue end) as Feb_Revenue,
sum(case when `month` = 'Mar' then revenue end) as Mar_Revenue,
sum(case when `month` = 'Apr' then revenue end) as Apr_Revenue,
sum(case when `month` = 'May' then revenue end) as May_Revenue,
sum(case when `month` = 'Jun' then revenue end) as Jun_Revenue,
sum(case when `month` = 'Jul' then revenue end) as Jul_Revenue,
sum(case when `month` = 'Aug' then revenue end) as Aug_Revenue,
sum(case when `month` = 'Sep' then revenue end) as Sep_Revenue,
sum(case when `month` = 'Oct' then revenue end) as Oct_Revenue,
sum(case when `month` = 'Nov' then revenue end) as Nov_Revenue,
sum(case when `month` = 'Dec' then revenue end) as Dec_Revenue

from Department
group by id