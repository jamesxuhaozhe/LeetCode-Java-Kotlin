select S1.post_id, count(distinct S2.sub_id) as number_of_comments
from
(select distinct sub_id as post_id from Submissions where parent_id is NULL) S1 left join Submissions S2 on S1.post_id = S2.parent_id
group by S1.post_id;

https://leetcode-cn.com/problems/number-of-comments-per-post/solution/612ms-by-cai-zhao-shi-tou-guo-he/