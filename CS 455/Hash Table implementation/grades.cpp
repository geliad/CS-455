// Name: Georgios Iliadis
// USC NetID: giliadis
// CSCI 455 PA5
// Spring 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>


//Prototypes
void command(Table *grades);
void insert(Table *grades);
void change(Table *grades);
void lookup(Table *grades);
void remove(Table *grades);
void size(Table *grades);
void help();
void quit();


int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*

  command(grades);
  return 0;
}

void command(Table *grades){
  while(true){
    cout << "cmd> ";
    string userInput;
    cin >> userInput;
    if(userInput == "insert"){
      insert(grades);
    }
    else if(userInput == "change"){
      change(grades);
    }
    else if(userInput == "lookup"){
      lookup(grades);
    }
    else if(userInput == "remove"){
      remove(grades);
    }
    else if(userInput == "print"){
      grades->printAll();
    }
    else if(userInput == "size"){
      size(grades);
    }
    else if(userInput == "stats"){
      grades->hashStats(cout);
    }
    else if(userInput == "help"){
      help();
    }
    else if(userInput == "quit"){
      quit();
    }
    else{
      cout << "ERROR: invalid command" << endl;
      help();
    }
  }
}

//Inserts the name and score in the grade table. If name is already presents, prints an error message
void insert(Table *grades){
  string name;
  int score;
  cin >> name;
  cin >> score;
  if(!grades->insert(name,score)){ //if it returns false, meaning it's not inserted, meaning it's already in the table
    cout << "ERROR: This student is already present in the table! "<< endl;
  }
}

//To change the score of a student, I first have to remove it and then insert it again.
//So if it is present in the table, I will insert a new entry with the same name but different score.
//If it's not found, then the function will print an error message.
void change(Table *grades) {
  string name;
  int newScore;
  cin >> name;
  cin >> newScore;
  int *p = grades->lookup(name); //I create a pointer to the value of the student
  if(*p == -1){ //If the student in not present
    cout << "ERROR: The student with name " << name << " is not present in the table!" << endl;
  }
  else{//if he/she is present, I will remove the student and then insert with the new score
    grades->remove(name);
    grades->insert(name,newScore);
  }
}

//Looks for the name, if it's not present it prints an error message.
//If it's present it print out it's name and score.
void lookup(Table *grades){
  string targetName;
  cin >> targetName;
  int *p = grades->lookup(targetName); // I create a new pointer to the value of the student using the method from Table.cpp
  if(*p == -1){ //If the student is not present 
    cout << "ERROR: This student is not present in the table!"<<endl;
  }
  else{
    cout << "The score of " <<  targetName << " is: " << *p << endl;
  }
}


//Removes the student, if it's not present it prints out and error
void remove(Table *grades) {
  string targetName;
  cin >> targetName;
  if (!grades->remove(targetName)){//if the student is not removed, meaning it's not in the table
    cout << "ERROR: This student is not present in the table!" << endl;
  }
}

//Prints number of entries in the table
void size(Table *grades) {
  cout << "Total number of entries is: " << grades->numEntries() << endl;
}

//Prints out the command summary
void help(){
  cout << "You need to enter one of the following commands: " << endl;
  cout << "insert <name> <score>  \n \t  to insert a name and a score to the table. " << endl;
  cout << "change <name> <newscore> \n \t  to change the score for this name in the table. " << endl;
  cout << "lookup <name> \n \t  to lookup the name, and print out his or her score. " << endl;
  cout << "remove <name> \n \t  to remove this student. " << endl;
  cout << "print \n \t  to print out all names and scores in the table." << endl;
  cout << "size \n \t  to print out the number of entries in the table." << endl;
  cout << "stats \n \t  to print out statistics about the hash table at this point" << endl;
  cout << "help \n \t  to print out a brief command summary." << endl;
  cout << "quit \n \t  to exit the program." << endl;
}

void quit(){
  cout << "Exiting program..." << endl;
  exit(0);
}


