USE ansi_sql_module;

SELECT
    u.user_id,
    u.full_name,
    COUNT(e.event_id) AS total_events,
    SUM(e.status = 'upcoming') AS upcoming_events,
    SUM(e.status = 'completed') AS completed_events,
    SUM(e.status = 'cancelled') AS cancelled_events
FROM Users u
LEFT JOIN Events e
    ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name
HAVING total_events > 0;