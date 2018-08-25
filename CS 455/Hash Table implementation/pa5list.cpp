// Name:
// USC NetID:
// CS 455 PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
  
  ListType list;
  listInitialize(list);
  listPrint(list);
  cout << "Size = " << listGetSize(list) << endl;

  cout << "Inserting George,John,Leo,Scott!" << endl;
  listInsertFront(list,"George" , 90);
  listInsertFront(list,"John" , 60);
  listInsertFront(list,"Leo" , 70);
  listInsertFront(list,"Scott", 80); 
  cout << "Print after inserting: " << endl;
  cout << "Expected list: Scott(80), Leo(70), John(60), George(90) " << endl;
  listPrint(list);
  cout<< "List size is: " << listGetSize(list) << endl;

   cout << "Remove George and Leo!" << endl;
   cout << listRemove(list,"George") << endl;
   cout << listRemove(list,"Leo") << endl;
   cout << "Attempt to remove Joe who is not in the list " << endl;
   cout << listRemove(list,"Joe") << endl;
   
  
  cout<< "Print after removing George and Leo: " << endl;
  listPrint(list);
  cout<<"List size is: " << listGetSize(list) << endl;
  
  cout << "I will lookup for Scott, it should return 80!" << endl;
  cout << "Scott's score: " << listLookup(list,"Scott")<< endl;
  cout << "I will lookup for George, it should return -1 since he is not present" << endl;
  cout << "George's score: " << listLookup(list,"George") << endl;

  return 0;
}
