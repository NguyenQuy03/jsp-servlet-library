use libraryservletjsp;

CREATE TABLE role (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE user (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullName VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    roleId bigint NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleId) REFERENCES role(id);

CREATE TABLE book (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    thumbnail VARCHAR(255) NOT NULL,
    shortDescription VARCHAR(255) NOT NULL,
    author varchar(255) NOT NULL,
    categoryId bigint NOT NULL,
    linkDownload VARCHAR(255) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE category (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    createdDate TIMESTAMP NULL,
    modifiedDate TIMESTAMP NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

ALTER TABLE book ADD CONSTRAINT fk_book_category FOREIGN KEY (categoryId) REFERENCES category(id);
