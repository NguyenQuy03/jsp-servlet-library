
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

INSERT INTO book(title, thumbnail, shortDescription, author, categoryId, linkDownload)
VALUES ("Perfect English Grammar","https://covers.zlibcdn2.com/covers299/books/4a/65/86/4a658614f8ce539ec9a412cbe722983a.jpg",
"Expert linguist Grant Barrett gives you all the tools you need to improve your everyday communication―from perfecting your punctuation to polishing your speaking skills―with his accessible, go-to grammar guide.",
"Grant Barrett", 1, "https://book4you.org/dl/2857818/15aa77");

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