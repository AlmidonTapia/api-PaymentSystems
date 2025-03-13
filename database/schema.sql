CREATE DATABASE IF NOT EXISTS PaymentSystemsDB;
USE PaymentSystemsDB;

CREATE TABLE testudent (
    idEstudent VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    surName VARCHAR(255),
    dni VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(255),
    codEst VARCHAR(255) UNIQUE,
    gender BOOLEAN,
    birthDate DATE,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);

CREATE TABLE tteacher (
    idTeacher VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    surName VARCHAR(255),
    dni VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(255),
    codTeach VARCHAR(255) UNIQUE,
    gender BOOLEAN,
    birthDate DATE,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);

CREATE TABLE tcourses (
    idCourse VARCHAR(255) PRIMARY KEY,
    codCourse VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    description TEXT,
    credits INT,
    price DOUBLE,
    idTeacher VARCHAR(255),
    maxStudents INT,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP,
    FOREIGN KEY (idTeacher) REFERENCES tteacher(idTeacher)
);

CREATE TABLE tpayment (
    idPayment VARCHAR(255) PRIMARY KEY,
    codPayment VARCHAR(255) UNIQUE,
    paymentDate TIMESTAMP,
    amount DOUBLE,
    type VARCHAR(255),
    status VARCHAR(255),
    file VARCHAR(255),
    idEstudent VARCHAR(255),
    FOREIGN KEY (idEstudent) REFERENCES testudent(idEstudent)
);

CREATE TABLE tenrollment (
    idEnrollment VARCHAR(255) PRIMARY KEY,
    codEnrollment VARCHAR(255) UNIQUE,
    idPayment VARCHAR(255),
    idCourse VARCHAR(255),
    Status   VARCHAR(255),
    enrollmentDate TIMESTAMP,
    FOREIGN KEY (idPayment) REFERENCES tpayment(idPayment),
    FOREIGN KEY (idCourse) REFERENCES tcourses(idCourse)
);