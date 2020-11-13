# 这个场合 union要更快 当 or 作用在 几个不同的 列上时 一般只有一个索引会有用 https://stackoverflow.com/questions/13750475/sql-performance-union-vs-or%EF%BC%89
select `name`, population, `area` from World where `area` > 3000000
union
select `name`, population, `area` from World where `population` > 25000000;

select `name`, population, `area` from World where `area` > 3000000 or population > 25000000;