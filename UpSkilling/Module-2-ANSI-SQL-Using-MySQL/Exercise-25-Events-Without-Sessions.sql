USE ansi_sql_module;

SELECT
    e.event_id,
    e.title,
    e.city,
    e.status
FROM Events e
LEFT JOIN Sessions s
    ON e.event_id = s.event_id
WHERE s.session_id IS NULL;