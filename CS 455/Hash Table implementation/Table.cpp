// Name: Georgios Iliadis
// USC NetID: giliadis
// CSCI 455 PA5
// Spring 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
  hashSize = HASH_SIZE;
  hashTable = new ListType[hashSize]();
  for(int i = 0;i<hashSize; i++){   //initialise everything to NULL using the method I created in listFuncs.cpp
    listInitialize(hashTable[i]);
  }
  numberOfEntries = 0;
}


Table::Table(unsigned int hSize) {
  hashSize = hSize;
  hashTable = new ListType[hashSize]();
  for(int i = 0; i<hashSize; i++){     //initialise everything to NULL
    listInitialize(hashTable[i]);
  }
  numberOfEntries = 0;
}


int * Table::lookup(const string &key) {
  ListType &address = hashTable[hashCode(key)];//Pass by reference
  int value = listLookup(address,key);
  int *p = &value; //create a new pointer to the value(score) of the student
  return p; //returns a pointer 
}

bool Table::remove(const string &key) {
  ListType &address = hashTable[hashCode(key)];
  if(listRemove(address,key)){ //if it returns true, meaning if it is removed
    numberOfEntries--;
    return true;
  }
  return false;
}

bool Table::insert(const string &key, int value) {
  ListType &address = hashTable[hashCode(key)]; //pass by reference
  if(listLookup(address,key) == -1){  //if student doesn't exist in the list(lookup = -1) then I will insert him/her and return true, otherwise it will return false.
    listInsertFront(address,key,value);
    numberOfEntries++;
    return true;
  }
  return false;
}

int Table::numEntries() const {
  return numberOfEntries;
}

void Table::printAll() const {
  for(int i = 0; i< hashSize; i++){
    listPrint(hashTable[i]);
  }
}

void Table::hashStats(ostream &out) const {
  int longestChain = 0;
  int nonEmptyBuckets = 0;
  for(int i = 0; i < hashSize; i++){
    if(listGetSize(hashTable[i])!=0){
      nonEmptyBuckets++;
    }
    if(listGetSize(hashTable[i]) > longestChain){
      longestChain = listGetSize(hashTable[i]) ;
    }
  } 
  out << "number of buckets: " << hashSize << endl;
  out << "number of entries: " << numberOfEntries << endl;
  out << "number of non-empty buckets: " << nonEmptyBuckets << endl;
  out << "longest chain: " << longestChain << endl;
}

