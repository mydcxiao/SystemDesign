// Name: Yuhang Xiao
// USC NetID: YXiao776
// CSCI 455 PA5
// Fall 2021

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

// for hash function called in private hashCode method defined below
#include <functional>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {
   hashSize = HASH_SIZE;
   hashArray = new ListType[hashSize]();
   numOfEntries = 0;
   numNonemptyBucket = 0;
}


Table::Table(unsigned int hSize) {
   hashSize = hSize;
   hashArray = new ListType[hashSize]();
   numOfEntries = 0;
   numNonemptyBucket = 0;
}


int * Table::lookup(const string &key) {
   ListType list = hashArray[hashCode(key)];
   while(list != NULL) {
      if(list->key == key) {
         return &(list->value);
      }
      list = list->next;
   }
   return NULL;
}


bool Table::remove(const string &key) {
   bool indicator = listRemove(hashArray[hashCode(key)], key);
   if(indicator){
      numOfEntries--;
      if(hashArray[hashCode(key)] == NULL) {
         numNonemptyBucket--;
      }
   }
   return indicator;
}


bool Table::insert(const string &key, int value) {
   bool indicator = listAppend(hashArray[hashCode(key)], key, value);
   if(indicator){
      numOfEntries++;
      if(hashArray[hashCode(key)]->next == NULL) {
         numNonemptyBucket++;
      }
   }
   return indicator;
}


int Table::numEntries() const {
   return numOfEntries;
}


void Table::printAll() const {
   for(unsigned int i = 0; i < hashSize; i++) {
      printList(hashArray[i]);
   }
}


void Table::hashStats(ostream &out) const {
   out << "number of buckets: " << hashSize << endl
      << "number of entries: " << numOfEntries << endl
      << "number of non-empty buckets: " << numNonemptyBucket << endl
      << "longest chain: " << findLongestChain() << endl;
}


// hash function for a string
// (we defined it for you)
// returns a value in the range [0, hashSize)
unsigned int Table::hashCode(const string &word) const {

   // Note: calls a std library hash function for string (it uses the good hash
   //   algorithm for strings that we discussed in lecture).
   return hash<string>()(word) % hashSize;

}


// add definitions for your private methods here

unsigned int Table::findLongestChain() const{
   unsigned int maxLen = 0;
   for(unsigned int i = 0; i < hashSize; i++) {
      unsigned int len = listSize(hashArray[i]);
      maxLen < len ? maxLen = len : maxLen = maxLen;
   }
   return maxLen;
}
