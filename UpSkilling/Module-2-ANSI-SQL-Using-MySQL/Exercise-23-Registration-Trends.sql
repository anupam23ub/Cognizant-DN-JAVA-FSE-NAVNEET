USE ansi_sql_module;

SELECT
    DATE_FORMAT(registration_date, '%Y-%m') AS registration_month,
    COUNT(*) AS registration_count
FROM Registrations
GROUP BY DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY registration_month;