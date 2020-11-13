//better solution
select ad_id,
case when sum(action="Clicked")+sum(action="Viewed")=0 then 0.00
else round(100*sum(action="Clicked")/(sum(action="Clicked")+sum(action="Viewed")),2)
end as ctr
from Ads
group by ad_id
order by ctr desc,ad_id

select ad_id, if(
    sum(case when `action` = 'Clicked' then 1 else 0 end) + sum(case when `action` = 'Viewed' then 1 else 0 end) = 0,
    0,
    round(
        sum(case when `action` = 'Clicked' then 1 else 0 end) / (sum(case when `action` = 'Clicked' then 1 else 0 end) + sum(case when `action` = 'Viewed' then 1 else 0 end)) * 100, 2)) as ctr
from Ads group by ad_id order by ctr desc, ad_id asc;