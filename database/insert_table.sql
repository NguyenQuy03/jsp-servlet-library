
//User
INSERT INTO user(userName, password, fullName, status, roleId)
VALUES ("admin", "123456", "NHadmin", true, 1);

INSERT INTO user(userName, password, fullName, status, roleId)
VALUES ("nvA", "123456", "NguyenVanA", true, 2);

INSERT INTO user(userName, password, fullName, status, roleId)
VALUES ("nvB", "123456", "NguyenVanB", true, 3);

//Book
INSERT INTO book(title, thumbnail, shortDescription, author, categoryId, linkDownload)
VALUES ("English Vocabulary in Use: Advanced","https://covers.zlibcdn2.com/covers299/books/4f/2b/64/4f2b64202c11ce4863b388053209b2b7.jpg",
"The words you need to communicate with confidence. Vocabulary explanations and practice for advanced level (C1 to C2) learners of English.",
"Michael McCarthy, Felicity O'Dell", 1, "https://book4you.org/dl/4985683/e44d03");

//Comment
INSERT INTO comment(content, userId, bookId)
VALUES ("Thanks for sharing so good word book! It is very useful for me.",
3, 1);

//Category
INSERT INTO category(name, code) VALUES ("Ngôn ngữ - Ngữ pháp", "Languages - Grammar");

INSERT INTO category(name, code) VALUES ("Kinh doanh & Kinh tế", "Business & Economics");

//Role
INSERT INTO role(name, code) VALUES ("Admin", "admin");

INSERT INTO role(name, code) VALUES ("Publisher", "publisher");

INSERT INTO role(name, code) VALUES ("User", "user");