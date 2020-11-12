# 用子查询
select s.id, s.`name` from Students as s where s.`department_id` not in (select d.`id` from Departments as d);

# use left join
select s.`id`, s.`name` from Students s left join Departments d on s.department_id = d.id where d.id is NULL;