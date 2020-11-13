update salary set sex = if(sex = 'f', 'm', 'f');

update salary
set sex = case sex when 'm' then 'f' else 'm'
end;