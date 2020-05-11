--RANK RANK并列跳跃排名，并列即相同的值，相同的值保留重复名次，遇到下一个不同值时，跳跃到总共的排名。
SELECT course_id, score,RANK() OVER(ORDER BY score DESC) FROM score;
--DENSE_RANK DENSE_RANK并列连续排序，并列即相同的值，相同的值保留重复名次，遇到下一个不同值时，依然按照连续数字排名。
--ROW_NUMBER ROW_NUMBER连续排名，即使相同的值，依旧按照连续数字进行排名。


-- 使用场景,用以查询分数最高的同学或者薪水