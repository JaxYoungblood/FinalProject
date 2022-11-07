
-- Department
INSERT INTO department (department_ID, description) VALUES('IT', 'IT');
INSERT INTO department (department_ID, description) VALUES('HR', 'Human Resources');
INSERT INTO department (department_ID, description) VALUES('MRKT', 'Marketing');
INSERT INTO department (department_ID, description) VALUES('MGMT', 'Management');
INSERT INTO department (department_ID, description) VALUES('SALES', 'Sales');

-- Employee
INSERT INTO employee (employee_ID, department_ID, first_name, last_name, phone) VALUES('Wizowski_M', 'SALES', 'Mike', 'Wizowski', 8824532875);
INSERT INTO employee (employee_ID, department_ID, first_name, last_name, phone) VALUES('Ryder_F', 'MRKT', 'Flynn', 'Ryder', 8629461726);
INSERT INTO employee (employee_ID, department_ID, first_name, last_name, phone) VALUES('Snowman_O', 'HR', 'Olaf', 'Snowman', 9057253819);
INSERT INTO employee (employee_ID, department_ID, first_name, last_name, phone) VALUES('Prideland_M', 'MGMT', 'Mufasa', 'Prideland', 3345852275);
INSERT INTO employee (employee_ID, department_ID, first_name, last_name, phone) VALUES('VonSchweetz_V', 'IT', 'Venelope', 'VonSchweetz', 7794644421);

-- Skill
INSERT INTO skill (skill_ID, description) VALUES('01', 'Sales Experience');
INSERT INTO skill (skill_ID, description) VALUES('02', 'Management Experience');
INSERT INTO skill (skill_ID, description) VALUES('03', 'Marketing Experience');
INSERT INTO skill (skill_ID, description) VALUES('04', 'Human Resource Expreience');
INSERT INTO skill (skill_ID, description) VALUES('05', 'Back End Coding');
INSERT INTO skill (skill_ID, description) VALUES('06', 'Front End Coding');
INSERT INTO skill (skill_ID, description) VALUES('07', 'Java');
INSERT INTO skill (skill_ID, description) VALUES('08', 'Typing');
INSERT INTO skill (skill_ID, description) values('09', 'First Aid Training, Certified');
INSERT INTO skill (skill_ID, description) VALUES('10', 'Team Leadership');

-- Employee Skills
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Wizowski_M', '01');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Wizowski_M', '10');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Ryder_F', '03');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Ryder_F', '09');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Snowman_O', '04');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Prideland_M', '02');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Prideland_M', '09');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('Prideland_M', '10');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('VonSchweetz_V', '05');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('VonSchweetz_V', '06');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('VonSchweetz_V', '07');
INSERT INTO employee_skill (employee_ID, skill_ID) VALUES('VonSchweetz_V', '10');
