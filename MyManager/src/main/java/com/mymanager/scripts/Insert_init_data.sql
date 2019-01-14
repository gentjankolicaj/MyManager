-- -----------------------------------------------------
-- Initial setup
-- -----------------------------------------------------
INSERT INTO `mymanager`. `user_type` (user_type) VALUES ('ADMIN');
INSERT INTO `mymanager`.  `user_type` (user_type) VALUES ('HR');
INSERT INTO  `mymanager`.`user_type` (user_type) VALUES ('ASSISTANT');
INSERT INTO `mymanager`. `user_type` (user_type) VALUES ('MANAGER');
INSERT INTO `mymanager`. `user_type` (user_type) VALUES ('FINANCE');



-- -----------------------------------------------------
-- Initial countries
-- -----------------------------------------------------

INSERT INTO `mymanager`.`countries` (country) VALUES ("ALBANIA");
INSERT INTO `mymanager`.`countries` (country) VALUES ("GERMANY");
INSERT INTO `mymanager`.`countries` (country) VALUES ("ITALY");
INSERT INTO `mymanager`.`countries` (country) VALUES ("FRANCE");
INSERT INTO `mymanager`.`countries` (country) VALUES ("SPAIN");
INSERT INTO `mymanager`.`countries` (country) VALUES ("UNITED KINGDOM");
INSERT INTO `mymanager`.`countries` (country) VALUES ("RUSSIA");
INSERT INTO `mymanager`.`countries` (country) VALUES ("AUSTRIA");
INSERT INTO `mymanager`.`countries` (country) VALUES ("TURKEY");
INSERT INTO `mymanager`.`countries` (country) VALUES ("USA");
INSERT INTO `mymanager`.`countries` (country) VALUES ("CHINA");
INSERT INTO `mymanager`.`countries` (country) VALUES ("JAPAN");


-- -----------------------------------------------------
-- Initial payment types
-- -----------------------------------------------------
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("SALARY");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("EXPENSE");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("BILL");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("BONUS");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("REWARD");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("PRICE");
INSERT INTO `mymanager`.`payment_type`(payment_type) VALUES  ("OUTSOURCE");



-- -----------------------------------------------------
-- Initial currencies
-- -----------------------------------------------------
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("EURO");
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("POUND");
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("LEK");
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("DOLLAR");
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("RUBLA");
INSERT INTO `mymanager`.`currencies`  (currency) VALUES ("PESSOS");



-- -----------------------------------------------------
-- Initial file types
-- -----------------------------------------------------
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("jpg");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("svg");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("png");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("pdf");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("doc");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("docx");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("ppt");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("xls");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("java");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("py");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("c");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("cpp");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("txt");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("ico");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("csv");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("sql");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("html");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("js");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("jpeg");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("mp3");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("mp4");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("vlc");
INSERT INTO `mymanager`.`file_types` (file_type) VALUES ("rtf");





-- -----------------------------------------------------
-- Admin user to login initially on application,change password and username after first login
-- -----------------------------------------------------
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("admin", "ADMIN", "Administrator", "Last Name", "admin",
					curdate(), "Tirane", 'M', " READ", "Administrator",now(), "Administrator", now());


-- -----------------------------------------------------
-- Initial users,for testing purposess,to be deleted after testing
-- -----------------------------------------------------
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("1", "ADMIN", "Test User ADMIN", "Last Name", "1",
					curdate(), "Tirane", 'M', " READ", "Test User ADMIN",now(), "Test User ADMIN", now());
					
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("2", "HR", "Test User HR", "Last Name", "2",
					curdate(), "Tirane", 'M', " READ", "Test User HR", now(),"Test User HR", now());
					
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("3", "FINANCE", "Test User FINANCE", "Last Name", "3",
					curdate(), "Tirane", 'M', " READ", "Test User FINANCE", now(),"Test User FINANCE",now());
										
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("4", "MANAGER", "Test User MANAGER", "Last Name", "4",
					curdate(), "Tirane", 'M', " READ", "Test User MANAGER", now(),"Test User MANAGER", now());
					
					
INSERT INTO `mymanager`. `users` (  user_id,user_type,first_name,last_name,`password`,birthday,birthplace,
  gender,rights,created_by,created_date,updated_by,updated_date) VALUES ("5", "ADMIN", "Test User ASSISTANT", "Last Name", "5",
					curdate(), "Tirane", 'M', " READ", "Test User ASSISTANT", now(),"Test User ASSISTANT", now());
                    
                    
                    
-- -----------------------------------------------------
-- Initial employees,for testing purposess,to be deleted after testing
-- -----------------------------------------------------              
                    INSERT INTO `mymanager`. `employees` (  employee_id,first_name,last_name,middle_name,birthday,birthplace,
  gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES ("007", "James 7", "Bond", "Arthur",
					curdate(), "London", 'M',null,null,null,"Developer", now(),"Developer", now());
                    
                      INSERT INTO `mymanager`. `employees` (  employee_id,first_name,last_name,middle_name,birthday,birthplace,
  gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES ("001", "James 1", "Bond", "Arthur",
					curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());
                    
                                      INSERT INTO `mymanager`. `employees` (  employee_id,first_name,last_name,middle_name,birthday,birthplace,
  gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES ("002", "James 2", "Bond", "Arthur",
					curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());
                    
                                        INSERT INTO `mymanager`. `employees` (  employee_id,first_name,last_name,middle_name,birthday,birthplace,
  gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES ("003", "James 3", "Bond", "Arthur",
					curdate(), "London", 'M',null,null,null,"Developer", now(),"Developer", now());
					
					                                      INSERT INTO `mymanager`. `employees` (  employee_id,first_name,last_name,middle_name,birthday,birthplace,
  gender,job_id,department_id,project_name,created_by,created_date,updated_by,updated_date) VALUES ("004", "James 4", "Bond", "Arthur",
					curdate(), "London", 'M', null,null,null,"Developer", now(),"Developer", now());