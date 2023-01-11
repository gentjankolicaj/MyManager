-- liquibase formatted sql

-- changeset liquibase:6

-- -----------------------------------------------------
-- Admin user to login initially on application,change password and username after first login
-- -----------------------------------------------------
INSERT INTO  users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
VALUES ("admin", "ADMIN", "Administrator", "Last Name", "admin",curdate(), "Tirane", 'M', " READ", "Administrator",now(), "Administrator", now());


-- -----------------------------------------------------
-- Initial users,for testing purposes,to be deleted after testing
-- -----------------------------------------------------
INSERT INTO   users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
 VALUES ("1", "ADMIN", "Test User ADMIN", "Last Name", "1",curdate(), "Tirane", 'M', " READ", "Test User ADMIN",now(), "Test User ADMIN", now());
					
INSERT INTO   users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
VALUES ("2", "HR", "Test User HR", "Last Name", "2",curdate(), "Tirane", 'M', " READ", "Test User HR", now(),"Test User HR", now());
					
INSERT INTO   users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
VALUES ("3", "FINANCE", "Test User FINANCE", "Last Name", "3",curdate(), "Tirane", 'M', " READ", "Test User FINANCE", now(),"Test User FINANCE",now());
										
INSERT INTO  users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
VALUES ("4", "MANAGER", "Test User MANAGER", "Last Name", "4",curdate(), "Tirane", 'M', " READ", "Test User MANAGER", now(),"Test User MANAGER", now());
					
					
INSERT INTO   users (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,gender,rights,created_by,created_date,updated_by,updated_date)
VALUES ("5", "ADMIN", "Test User ASSISTANT", "Last Name", "5",curdate(), "Tirane", 'M', " READ", "Test User ASSISTANT", now(),"Test User ASSISTANT", now());
                    
                    