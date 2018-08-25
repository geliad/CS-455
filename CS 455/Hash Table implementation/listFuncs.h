// Name:Georgios Iliadis
// USC NetID:giliadis
// CSCI 455 PA5
// Spring 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

//Removes element,return true if removed, false if not found.
bool listRemove(ListType &list,string target);
//Prints all elements
void listPrint(ListType list);
//Inserts element at front of list
void listInsertFront(ListType &list,string keyInsert,int valInsert);
//Lookup name and prints her score or -1 if target is not present.
int listLookup(ListType list,string target);
//Initialize list as null
void listInitialize(ListType &list);
//Return the size of the list
int listGetSize(ListType list);






// keep the following line at the end of the file
#endif
