# 用子查询
select s.id, s.`name` from Students as s where s.`department_id` not in (select d.`id` from Departments as d);

