-- liquibase formatted sql

-- changeset liquibase:7

-- -----------------------------------------------------
-- Initial employees,for testing purposes,to be deleted after testing
-- -----------------------------------------------------
INSERT INTO employees (  employee_id,first_name,last_name,middle_name,birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date)
VALUES ("007", "James 7", "Bond", "Arthur",curdate(), "London", 'M',null,null,null,"Developer", now(),"Developer", now());

INSERT INTO employees (  employee_id,first_name,last_name,middle_name,birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date)
VALUES ("001", "James 1", "Bond", "Arthur",curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());

INSERT INTO employees (  employee_id,first_name,last_name,middle_name,birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date)
VALUES ("002", "James 2", "Bond", "Arthur",curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());

INSERT INTO employees (  employee_id,first_name,last_name,middle_name,birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date)
VALUES ("003", "James 3", "Bond", "Arthur",curdate(), "London", 'M',null,null,null,"Developer", now(),"Developer", now());

INSERT INTO employees (  employee_id,first_name,last_name,middle_name,birthday,birthplace,gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date)
VALUES ("004", "James 4", "Bond", "Arthur",curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());