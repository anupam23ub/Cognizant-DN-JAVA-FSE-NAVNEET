-- ===========================================================================
-- 05-quiz-data.sql  (Doc 3 / Hands-on 3)
-- Reconstruction of the quiz.mwb schema data. Produces the exact attempt
-- detail output shown in the assignment for user 1 / attempt 1.
--
-- NOTE: attempt_option holds ONE ROW PER OPTION of each attempted question,
-- with ao_selected = 1 only for the option the user actually picked. This is
-- what lets the HQL view list every option (with its score and a
-- selected/not-selected flag), matching the assignment's printout.
-- ===========================================================================

DELETE FROM attempt_option;
DELETE FROM attempt_question;
DELETE FROM attempt;
DELETE FROM options;
DELETE FROM question;
DELETE FROM quiz_user;

INSERT INTO quiz_user (us_id, us_name) VALUES (1, 'john');

-- questions (qu_score = score awarded for the correct answer)
INSERT INTO question (qu_id, qu_text, qu_score) VALUES
 (1, 'What is the extension of the hyper text markup language file?', 1.0);
INSERT INTO question (qu_id, qu_text, qu_score) VALUES
 (2, 'What is the maximum level of heading tag can be used in a HTML page?', 1.0);
INSERT INTO question (qu_id, qu_text, qu_score) VALUES
 (3, 'The HTML document itself begins with <html> and ends </html>. State True or False', 1.0);
INSERT INTO question (qu_id, qu_text, qu_score) VALUES
 (4, 'Choose the right option to store text value in a variable', 0.5);

-- options (op_correct flags the correct option)
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (1, 1, '.xhtm', 0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (2, 1, '.ht',   0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (3, 1, '.html', 1);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (4, 1, '.htmx', 0);

INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (5, 2, '5', 0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (6, 2, '3', 0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (7, 2, '4', 0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (8, 2, '6', 1);

INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (9,  3, 'false', 0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (10, 3, 'true',  1);

INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (11, 4, '''John''', 1);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (12, 4, 'John',    0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (13, 4, '"John"',  0);
INSERT INTO options (op_id, op_qu_id, op_text, op_correct) VALUES (14, 4, '/John/',  0);

-- one attempt by user 1 covering all four questions
INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, '2019-10-15');

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qu_id) VALUES (4, 1, 4);

-- attempt_option: every option of each attempted question, ao_selected=1 only
-- for the option the user chose.
-- Q1 (aq 1): user picked .html (op 3)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 2, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 3, 1);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 4, 0);
-- Q2 (aq 2): user picked 3 (op 6) - wrong; correct is 6 (op 8)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 5, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 6, 1);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 7, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 8, 0);
-- Q3 (aq 3): user picked true (op 10)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (3, 9,  0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (3, 10, 1);
-- Q4 (aq 4): user picked 'John' (op 11)
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 11, 1);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 12, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 13, 0);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (4, 14, 0);
