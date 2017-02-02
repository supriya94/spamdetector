# Spam Detector

A simple Java application that analyzes a sequence of user activities in a social app and classifies the users as spam or not spam.  

A user suspected to be spam is identified by the following characteristics:  
  1. Sends more than a predetermined number of friend requests  
  2. Reported as spam by other trusted users  
  3. Sends unwarranted spam reports against other users  
  4. Does not reject friend requests
  5. Does not have any friends
  
## Requirements

* Java 1.7
* Maven

## Usage

```
mvn compile
mvn package
java -cp target/spam-classifier-1.0-SNAPSHOT.jar antispam.Main input_file1 [input_file2 ...]
```

## Notes

* A user is suspected to be a spammer if the number of requests sent is greater than half the total number of users. This measure can be changed to reflect appropriate spammer behaviour.  

* It is assumed that a user can either accept or reject a friend request. If a friend request is accepted, spam can be reported but the spammer is not removed from the user's friend list.  

* A suspended user is also not removed from other users' friend lists. This does not affect the classification of spam.  
