/* Queries to test the database */

/* Testing hourly duration */
SELECT * FROM Log WHERE log_date BETWEEN '2017-01-01 15:00:00' AND '2017-01-01 16:00:00' GROUP BY ip HAVING count(ip) >= 200 

/* Testing daily duration */
SELECT * FROM Log WHERE log_date BETWEEN '2017-01-01 00:00:00' AND '2017-01-02 00:00:00' GROUP BY ip HAVING count(ip) >= 500 