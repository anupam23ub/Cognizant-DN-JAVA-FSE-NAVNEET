-- ===========================================================================
-- 04-payroll-data.sql  (Doc 2 / Hands-on 3 - equivalent of payroll.sql)
-- Departments, employees, skills and the employee_skill links used by the
-- ManyToOne / OneToMany / ManyToMany hands-on (Doc 2 H4-H6) and the HQL
-- hands-on (Doc 3).
-- ===========================================================================

DELETE FROM employee_skill;
DELETE FROM attempt_option;
DELETE FROM employee;
DELETE FROM skill;
DELETE FROM department;

INSERT INTO department (dp_id, dp_name) VALUES (1, 'Human Resources');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Finance');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Engineering');

-- em_permanent stored as bit: 1 = permanent, 0 = contract
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (1, 'John Abraham', 850000, 1, '1988-05-12', 3);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (2, 'Steve Waugh',  920000, 1, '1985-11-23', 3);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (3, 'Priya Menon',  780000, 0, '1992-02-09', 2);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (4, 'Rahul Verma',  640000, 1, '1990-07-30', 2);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES (5, 'Anita Desai',  710000, 0, '1994-09-15', 1);

INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'Hibernate');
INSERT INTO skill (sk_id, sk_name) VALUES (4, 'SQL');

-- employee_skill links (leave employee 1 + skill 4 unlinked so the
-- testAddSkillToEmployee hands-on has a pair with no existing relationship)
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (4, 4);
