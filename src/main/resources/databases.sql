CREATE TABLE author (
authorId INT(10) NOT NULL AUTO_INCREMENT,
firstName VARCHAR(25) NOT NULL,
lastName VARCHAR(25) NOT NULL,
PRIMARY KEY (authorId)
 );
 CREATE TABLE book (
 bookId INT(10) NOT NULL AUTO_INCREMENT,
 bookTitle VARCHAR(25) NOT NULL,
 bookDescription VARCHAR(250) NOT NULL,
 authorId INT(10) NOT NULL,
 bookRelaseDate DATE NOT NULL,
 PRIMARY KEY (bookID),
 FOREIGN KEY (authorId) REFERENCES author(authorId)
 );
 DROP TABLE author2;
 DESCRIBE book;

 CREATE TABLE reviews (
reviewsId INT(10) AUTO_INCREMENT,
reviews TEXT NOT NULL,
bookId INT(10) NOT NULL,
score INT(10) NOT NULL,
PRIMARY KEY (reviewsId),
FOREIGN KEY (bookId) REFERENCES book(bookId)
   );

