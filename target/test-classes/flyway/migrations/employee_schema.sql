DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE department (
department_ID VARCHAR(8) NOT NULL,
description VARCHAR(50) NOT NULL,
PRIMARY KEY(department_ID)
);

CREATE TABLE employee (
employee_ID VARCHAR(30) NOT NULL,
department_ID VARCHAR(8) NOT NULL,
first_name VARCHAR (25) NOT NULL,
last_name VARCHAR (25) NOT NULL,
phone VARCHAR (13),
PRIMARY KEY (employee_ID),
FOREIGN KEY (department_ID) REFERENCES department (department_ID)
);

CREATE TABLE skill (
skill_ID INT NOT NULL AUTO_INCREMENT,
description varchar (100) not null,
PRIMARY KEY(skill_ID)
);

CREATE TABLE employee_skill (
employee_ID VARCHAR(30) NOT NULL,
skill_ID INT NOT NULL,
FOREIGN KEY(employee_ID) REFERENCES employee(employee_ID),
FOREIGN KEY(skill_ID) REFERENCES skill(skill_ID)
);
