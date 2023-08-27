
/*
 *  ectest.cpp
 *
 *  a non-interactive test program to test the functions described in ecListFuncs.h
 *
 *    to run it use the command:   ectest
 *
 *  Note: this uses separate compilation.  You put your list code ecListFuncs.cpp
 *  Code in this file should call those functions.
 */


#include <iostream>
#include <string>

#include "ecListFuncs.h"

using namespace std;

//reclaim the memory of a linkedlist

void deleteList(ListType & list) {
   ListType head = list;
   while(head){
      list = head->next;
      delete head;
      head = list;
   }
}

int main ()
{
   // test function listToString()
   ListType list1 = NULL;
   ListType list2 = new Node(3);
   ListType list3 = new Node(3, new Node(4, new Node(5)));
   ListType list4 = NULL;
   ListType list5 = NULL;
   cout << "list to string: " << endl;
   cout << "string1 [Exp: ()]:" << " " << listToString(list1) << endl;
   cout << "string2 [Exp: (3)]:" << " " << listToString(list2) << endl;
   cout << "string3 [Exp: (3 4 5)]:" << " " << listToString(list3) << endl;
   deleteList(list1);
   deleteList(list2);
   deleteList(list3);
   
   // test function buildList()
   string string1 = "" ;
   string string2 = "-32" ;
   string string3 = "     -32   " ;
   string string4 = "1 3 2" ;
   string string5 = "  1 3 2" ;
   cout << "build list: " << endl;
   cout << "list1 [Exp: ()]: " << listToString(list1 = buildList(string1)) << endl;
   cout << "list2 [Exp: (-32)]: " << listToString(list2 = buildList(string2)) << endl;
   cout << "list3 [Exp: (-32)]: " << listToString(list3 = buildList(string3)) << endl;
   cout << "list4 [Exp: (1 3 2)]: " << listToString(list4 = buildList(string4)) << endl;
   cout << "list5 [Exp: (1 3 2)]: " << listToString(list5 = buildList(string5)) << endl;
   deleteList(list1);
   deleteList(list2);
   deleteList(list3);
   deleteList(list4);
   deleteList(list5);
   
   //test function insertAt()
   list1 = NULL;
   list2 = new Node(12);
   list3 = new Node(12);
   list4 = new Node(7, new Node(4, new Node(7, new Node(7))));
   insertAt(list1, 0, 3);
   insertAt(list2, 0, 3);
   insertAt(list3, 1, 3);
   insertAt(list4, 2, -10);
   cout << "insert at index in list: " << endl;
   cout << "list1 [Exp: (3)]: " << listToString(list1) << endl;
   cout << "list2 [Exp: (3 12)]: " << listToString(list2) << endl;
   cout << "list3 [Exp: (12 3)]: " << listToString(list3) << endl;
   cout << "list4 [Exp: (7 4 -10 7 7)]: " << listToString(list4) << endl;
   deleteList(list1);
   deleteList(list2);
   deleteList(list3);
   deleteList(list4);
   
   //test function partitionBy()
   list1 = new Node(7, new Node(4, new Node(4, new Node(3, new Node(9)))));
   list2 = new Node(7, new Node(4, new Node(4, new Node(3, new Node(9)))));
   list3 = new Node(7, new Node(4, new Node(2, new Node(3, new Node(9)))));
   list4 = new Node(1, new Node(2, new Node(3, new Node(3, new Node(2)))));
   list5 = NULL;
   ListType filt1 = partitionBy(list1, 5);
   ListType filt2 = partitionBy(list2, 4);
   ListType filt3 = partitionBy(list3, 0);
   ListType filt4 = partitionBy(list4, 10);
   ListType filt5 = partitionBy(list5, 3);
   
   cout << "partition the list: " << endl;
   cout << "list1 [Exp: (7 9) (4 4 3)]: " << listToString(list1) << " " <<
      listToString(filt1) << endl;
   cout << "list2 [Exp: (7 4 4 9) (3)]: " << listToString(list2) << " " <<
      listToString(filt2) << endl;
   cout << "list3 [Exp: (7 4 2 3 9) ()]: " << listToString(list3) << " " <<
      listToString(filt3) << endl;
   cout << "list4 [Exp: () (1 2 3 3 2)]: " << listToString(list4) << " " <<
      listToString(filt4) << endl;
   cout << "list5 [Exp: () ()]: " << listToString(list5) << " " <<
      listToString(filt5) << endl;
   deleteList(list1);
   deleteList(list2);
   deleteList(list3);
   deleteList(list4);
   deleteList(list5);
   deleteList(filt1);
   deleteList(filt2);
   deleteList(filt3);
   deleteList(filt4);
   deleteList(filt5);
   return 0;
}



