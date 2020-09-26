CREATE TABLE author(
authorId int(10) NOT NULL AUTO_INCREMENT,
firtsName varchar(25) NOT NULL,
lastName varchar(25) NOT NULL,
PRIMARY KEY (authorId)
);

ALTER TABLE author CHANGE `firtsName` `firstName` varchar(25);
CREATE TABLE book (
 bookId INT(10) NOT NULL AUTO_INCREMENT,
 bookTitle VARCHAR(25) NOT NULL,
 bookDescription VARCHAR(250) NOT NULL,
 authorId INT(10) NOT NULL,
 bookRelaseDate DATE NOT NULL,
 PRIMARY KEY (bookID),
 FOREIGN KEY (authorId) REFERENCES author(authorId)
 );

DROP TABLE author;

CREATE TABLE reviews(
reviewsId INT(10) NOT NULL AUTO_INCREMENT,
bookId INT(10) NOT NULL,
score int NOT NULL,
review text NOT NULL,
PRIMARY KEY(reviewsId),
FOREIGN KEY (bookId) REFERENCES book(bookId)
);
SELECT * FROM author
