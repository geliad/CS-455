/*  Name: Georgios Iliadis
 *  USC NetID: giliadis
 *  CS 455 Spring 2018, Extra Credit assignment
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


bool isInOrder(ListType list) {
  if(list == NULL || list->next == NULL){
    return true;
  }
  Node *p = list;
  while(p->next!=NULL){
    if(p->next->data > p->data){
      p = p->next;
    }
    else{
      return false;
    }
  }
  return true;
}



void insertInOrder(ListType & list, Node *itemP) {
  assert(isInOrder(list));     // checks the preconditions
  assert(itemP->next == NULL);
  
  Node *p = list;
  //empty list
  if(list == NULL){
    //p = itemP;
    //list = p;
    //return;
    list = itemP;
    return;
  }
  
  //List with only 1 value
  if(p->data >= itemP->data){
    itemP->next = p;
    list = itemP;
    return;
  }
  
  // I need two pointers. One to point to the previous node and one the next node. Once I find the node that is bigger than itemP, I will need to use both of them in order to insert itemP in between them. That's why I create Node *temp.
  while(p->next!=NULL){
    if(p->next->data >= itemP->data){
      Node *temp = p->next;
      p->next = itemP;
      itemP->next = temp;
      return;
    }
    p=p->next;
  }
  p->next = itemP; //if itemP is the largest of all the list
  return;
}



void insertionSort(ListType &list) {
  if(list==NULL){
    return;
  }
  Node *p = list;
  Node *sortedList = NULL; //I create a new sorted list where everything will be added here. At the end I will say that my list equals this sorted list.
  list = NULL;
  
  while(p!=NULL){
    Node *q = p; //I create a new pointer so that p is always one 'step' ahead of p. q is always one step behind p.
    p = p->next;
    q->next = NULL;
    insertInOrder(sortedList, q);
  }
  list = sortedList;
}
  

void splitEvenOdd(ListType &list, ListType &a, ListType &b){
  if(list == NULL) {
    a = list; //List 'a' is the list with odd located elements(1st,3rd,5th..)
    b = list; //List 'b' is the list with even located elements(2nd,4th,6th..)
    return;
  }
    
  Node *p = list;
  Node *pointA = NULL; //Pointer for list A
  Node *pointB = NULL; //Pointer for list B
  int i = 0;//index
    
  while(p != NULL) {
    if(i % 2 == 0) { //IF i is even, but since it's index we get the odd. So index of 0 for me is considered as 1 since it's the first located element. 
      if(pointA != NULL) {
	pointA->next = p;
	pointA = pointA->next;
	pointB->next = NULL;
      } 
      else { //if pointA == NULL
	pointA = p;
	a = pointA;
	//I don't have to put pointB->next =NULL here since this is the first statement that my code with go through. As a result pointB is already NULL since I initialized it at the top.
      }
    } 
    else { // If I is odd but since it's an index, it's for even located elements.
      if(pointB != NULL) {
	pointB->next = p;
	pointB = pointB->next;
	pointA->next = NULL;
      } 
      else { //if pointB == NULL
	pointB = p;
	b = pointB;
	pointA->next = NULL;
      }
    }
    p = p->next;
    i++;
  }
  //list = NULL;
  list = p; // to make the list NULL
  
}



