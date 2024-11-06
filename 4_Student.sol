// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract marksManagement{
    struct StudentInfo {
        string name;
        int marks;
    }
          
    address public owner;
    mapping (int => StudentInfo) public stdRecords;

    constructor() {
        owner = msg.sender; 
    }

    function addStudent (int roll, string memory name, int marks) external  {
        stdRecords[roll] = StudentInfo(name, marks);
    }
    
    function updateStudentsMarks(int marks, int roll) external {
        require (stdRecords[roll].marks != marks, "Already have marks");
        stdRecords[roll].marks = marks;
    }
}
