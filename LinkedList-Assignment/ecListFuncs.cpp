
/*
 *  See ecListFuncs.h for specification of each function.
 *
 */

#include <string>
#include <cassert>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;

// *********************************************************
// Node constructors: do not change
Node::Node(int item) {
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
// *********************************************************


ListType buildList(const string & listString) {
   istringstream iss (listString);
   int val;
   ListType head = NULL;
   if(iss >> val) {
     head = new Node(val);
     ListType prev = head;
     while(iss >> val) {
        prev->next = new Node(val);
        prev = prev->next;
     }
   }
   return head;
}


string listToString(ListType list) {
   if(list == NULL) {
      return "()";
   }
   string s = "(";
   while(list) {
      s += to_string(list->data);
      if(list->next) {
         s += " ";
      }
      else {
         s += ")";
      }
      list = list->next;
   }
   return s;
}


void insertAt(ListType & list, int index, int value) {
   if(index == 0) {
      list = new Node(value, list);
      return;
   }
   ListType head = list;
   for(int i = 0; i < index - 1; i++) {
      list = list->next;
   }
   list->next = new Node(value, list->next);
   list = head;
}


ListType partitionBy(ListType & list, int number) {
   if(list == NULL){
      return list;
   }
   ListType head1 = NULL;
   ListType head2 = NULL;
   ListType prev1 = NULL;
   ListType prev2 = NULL;
   while(list != NULL) {
      if(list->data >= number) {
        if(head1 == NULL) {
          head1 = list;
          prev1 = list;
        }
        else {
          prev1->next = list;
          prev1 = list;
        }
      }
      else {
        if(head2 == NULL) {
          head2 = list;
          prev2 = list;
        }
        else {
          prev2->next = list;
          prev2 = list;
        }
      }
    list = list->next;
   }
   if(prev1 != NULL) {
     prev1->next = NULL;
   }
   if(prev2 != NULL) {
     prev2->next = NULL;
   }
   list = head1;
   return head2;
}



