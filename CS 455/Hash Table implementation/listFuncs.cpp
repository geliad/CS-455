// Name:Georgios Iliadis
// USC NetID:giliadis
// CSCI 455 PA5
// Spring 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below

//Removes a node by providing the string of it(the key). If found, it is removed and it returns true, otherwise returns false
bool listRemove(ListType &list, string target){
  Node * p = list;
  if(p!=NULL){
    if(p->key == target){
      list = list->next;
      delete p;
      return true;
    }
    while(p->next !=NULL){
      Node *prev = p;
      p = p->next;
      if(p->key == target){
	prev->next = p->next;
	delete p;
	return true;
      }
    }
  }
  return false;
}

//Prints the list with key first and then the value
void listPrint(ListType list){
  Node *p = list;
  if(list == NULL){
    return;
  }
  while(p!=NULL){
    cout<< p->key << " "<< p->value << endl;
    p = p->next;
  }
}

//Inserts the new node at the front of the list
void listInsertFront(ListType &list,string keyInsert, int valInsert){
  Node *p = new Node(keyInsert,valInsert);
  p->next = list;
  list = p;
}

//Returns value of target if found, if not found returns -1.
int listLookup(ListType list,string target){
  Node *p = list;
  if(p!=NULL){
    if(p->key == target){
      return p->value;
    }
    while(p->next!=NULL){
      p = p->next;
      if(p->key == target){
	return p->value;
      }
    }
  }
  return -1;
}

//Initialises the list to NULL
void listInitialize(ListType &list){
  list = NULL;
}

//Returns the size of the list
int listGetSize(ListType list){
  Node *p = list;
  int x = 0;
  if(list == NULL){
    return x;
  }
  while(p!=NULL){
    x++;
    p=p->next;
  }
  return x;
}
